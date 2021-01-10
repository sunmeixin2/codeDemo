package code.ThreadDemo;

/**
 * @author sunmeixin
 * @description
 * @date 2020-12-06
 */
public class SynchronizedObjectLock implements Runnable  {


     static SynchronizedObjectLock instence = new SynchronizedObjectLock();

    @Override
    public void run() {
        // 同步代码块形式——锁为this,两个线程使用的锁是一样的,线程1必须要等到线程0释放了该锁后，才能执行
        synchronized (this) {
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }
    public void print() {
        System.out.println(134);
    }

    public static void main(String[] args) {
//        SynchronizedObjectLock instence = new SynchronizedObjectLock();
        Thread t1 = new Thread(new SynchronizedObjectLock());
        Thread t2 = new Thread(new SynchronizedObjectLock());
        t1.start();
        t2.start();
    }
}
