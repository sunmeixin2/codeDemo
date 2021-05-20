package code.ThreadDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunmeixin
 * @description 线程间通信
 * @date 2021-04-21
 */
public class TestSync {

    /**
        // 定义一个共享变量来实现通信，它需要是volatile修饰，否则线程不能及时感知
        static volatile boolean notice = false;

        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            // 实现线程A
            Thread threadA = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    list.add("abc");
                    System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    if (list.size() == 5)
                        notice = true;
                }
            });
            // 实现线程B
            Thread threadB = new Thread(() -> {
                while (true) {
                    if (notice) {
                        System.out.println("线程B收到通知，开始执行自己的业务...");
                        break;
                    }
                }
            });
            //　需要先启动线程B
            threadB.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 再启动线程A
            threadA.start();
     }**/

        public static void main(String[] args) {
            // 定义一个锁对象
            Object lock = new Object();
            List<String>  list = new ArrayList<>();
            // 实现线程A
            Thread threadA = new Thread(() -> {
                synchronized (lock) {
                    for (int i = 1; i <= 10; i++) {
                        list.add("abc");
                        System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (list.size() == 5)
                            lock.notify();// 唤醒B线程
                    }
                }
            });
            // 实现线程B
            Thread threadB = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        if (list.size() != 5) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("线程B收到通知，开始执行自己的业务...");
                    }
                }
            });
            //　需要先启动线程B
            threadB.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 再启动线程A
            threadA.start();
        }
        // 线程A发出notify()唤醒通知之后，依然是走完了自己线程的业务之后，线程B才开始执行，这也正好说明了，notify()方法不释放锁，而wait()方法释放锁。




}
