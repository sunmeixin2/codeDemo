package code.ThreadDemo;

/**
 * @author sunmeixin
 * @description
 * @date 2021-03-30
 */
public class CreateThreadTest {

    public static void main(String[] args) {
        System.out.println("主线程执行开始");
        Thread threadA = new Thread(new RunnableTest(), "线程A");
        threadA.start();
        System.out.println("主线程执行结束");
    }
}

class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行结束");
    }
}
