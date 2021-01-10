package code.ThreadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunmeixin
 * @description
 * @date 2020-02-03 10:56
 */
public class DemoQueue {
    private volatile int total = 20;
    private List<Integer> list = new ArrayList<>();
    private List<String> queen = new ArrayList<>();
    private volatile int modCount = 0;
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition write = reentrantLock.newCondition();
    private final Condition read = reentrantLock.newCondition();

    public static void main(String[] args) throws Exception {
        DemoQueue demo = new DemoQueue();
        Executor executor = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        executor.execute(() -> {
            for (int i = 0; i < 20; i++) {
                demo.add(i);
            }
        });
        executor.execute(() -> {
            for (int i = 0; i < 20; i++) {
                demo.add(i);
            }
        });
        executor.execute(() -> {
            for (int i = 0; i < 20; i++) {
                demo.pool();
            }
        });
        executor.execute(() -> {
            for (int i = 0; i < 20; i++) {
                demo.pool();
            }
        });
        System.out.println("队列现状:");
        /*for (int i = 0; i < demo.list.size() ; i++) {
            System.out.print(demo.list.get(i)+",");
        }*/
        demo.list.forEach(x -> System.out.println(x));
    }

    //竞态
    public void add(Integer integer) {
        synchronized (list) {
            if (modCount == total) {
                System.out.println("队列已满，无法写入，等待出队之后唤醒。");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("队列未满，写入变量" + integer + "");
                modCount++;
                list.add(integer);
                list.notifyAll();
                System.out.println("变量" + integer + "入队成功，唤醒出队");
            }
        }
    }

    public int pool() {
        int result = 0;
        synchronized (list) {
            if (modCount == 0) {
                System.out.println("队列为空，无法出队，等待入队之后唤醒。");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("队列未满，准备出队");
                modCount--;
                result = list.remove(0);
                list.notifyAll();
                System.out.println("变量" + result + "出队成功，唤醒入队");
            }
            return result;
        }
    }

    //竞态
    public void add(String str) {
        reentrantLock.lock();
        try {
            if (modCount == total) {
                System.out.println("队列已满，无法写入，等待出队之后唤醒。");
                try {
                    write.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("队列未满，写入变量" + str + "");
                modCount++;
                queen.add(str);
                read.signalAll();
                System.out.println("变量" + str + "入队成功，唤醒出队");
            }
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
    }

    public int poollock() {
        int result = 0;
        reentrantLock.lock();
        try {
            if (modCount == 0) {
                System.out.println("队列为空，无法出队，等待入队之后唤醒。");
                try {
                    read.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("队列未空，准备出队");
                modCount--;
                result = list.remove(0);
                write.signalAll();
                System.out.println("变量" + result + "出队成功，唤醒入队");
            }
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
        return result;
    }

}
