package code.ThreadDemo;

/**
 * @author sunmeixin
 * @description
 * @date 2021-04-05
 */
public class MyRunnable implements Runnable {
    NotThreadSafe instance = null;

    public MyRunnable(NotThreadSafe instance){
        this.instance = instance;
    }

    public void run(){
        this.instance.add("some text");
    }
}
