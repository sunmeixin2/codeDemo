package code.ThreadDemo;

/**
 * @author sunmeixin
 * @description
 * @date 2020-02-03 10:57
 */
public class SyncTest implements Runnable {

    public static int count;

    public SyncTest() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        Thread thread = new Thread(new SyncTest(), "thread1");
        Thread thread1 = new Thread(new SyncTest(), "thread2");
        thread.start();
        thread1.start();
    }
}

