package code.ThreadDemo;

/**
 * @author sunmeixin
 * @description
 * @date 2020-12-12
 */
public class DaemonDemo {

    public static void main(String[] args) {

        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("i an alive");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("finally block");
                    }
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();
        //确保main线程结束前能给daemonThread能够分到时间片
        try {
            System.out.println("main thread start");
            Thread.sleep(8000);
            System.out.println("main thread end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finish");
        }
    }
}
