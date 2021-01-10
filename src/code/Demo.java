package code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author sunmeixin
 * @description
 * @date 2020-02-03 10:55
 */
public class Demo {
    private final static Integer count = 100;
    public List<Integer> queue;
    private Integer index = 0;
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.queue = new ArrayList<>(count);


        new Thread(new Runnable() {
            @Override
            public void run() {
//                synchronized (Demo.class){
                for (int i = 0; i < 20; i++) {
                    System.out.println("变量" + i + "入队");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    demo.in(i);
                }
//                }

//                countDownLatch.countDown();

            }
        }).start();

//        demo.queue.forEach(x -> System.out.println(x));
//        System.out.println("-----分割线--------");

//

        new Thread(new Runnable() {
            @Override
            public void run() {
//                synchronized (Demo.class){
                for (int i = 0; i < 20; i++) {
                    int x = demo.out();
                    System.out.println("变量" + x + "出队");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

//                countDownLatch.countDown();

//            }
        }).start();


//        System.out.println("队列现状：");
//        demo.queue.forEach(x -> System.out.println("队列剩余元素:"+x));

    }

    private synchronized void in(int x) {
        if (index != count - 1) {
            queue.add(x);
            index++;
        }

    }

    private synchronized int out() {
        if (!queue.isEmpty()) {
            int x = queue.remove(0);
            index--;
            return x;
        }
        return -1;
    }
}
