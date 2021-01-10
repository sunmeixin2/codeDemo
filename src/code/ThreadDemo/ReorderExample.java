package code.ThreadDemo;

/**
 * @author sunmeixin
 * @description
 * @date 2020-12-12
 */
public class ReorderExample {
    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;                   //1
        flag = true;             //2
    }

    public void reader() {
        if (flag) {              //3
            int i =  a * a;      //4
            System.out.println("i="+i);
        }

    }

    public static void main(String[] args) {
        ReorderExample reorderExample = new ReorderExample();
//        for (int i = 0; i<2; i++) {
//
//            reorderExample.func();
//        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reorderExample.reader();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reorderExample.writer();
//                System.out.println("当前线程："+Thread.currentThread());
            }
        });

        System.out.println("thread run...");
        thread1.start();
        thread2.start();
        System.out.println("thread end...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void func() {
        ReorderExample reorderExample = new ReorderExample();

    }
}
