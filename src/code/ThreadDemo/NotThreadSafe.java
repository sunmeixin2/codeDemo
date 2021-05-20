package code.ThreadDemo;

/**
 * @author sunmeixin
 * @description
 * @date 2021-04-05
 */
public class NotThreadSafe {
    StringBuilder builder = new StringBuilder();

    public void add(String text){
        this.builder.append(text);
    }

    public NotThreadSafe() {
    }

    public static void main(String[] args) {
        NotThreadSafe sharedInstance = new NotThreadSafe();

        new Thread(new MyRunnable(new NotThreadSafe())).start();
        new Thread(new MyRunnable(new NotThreadSafe())).start();
        System.out.println(sharedInstance.builder.toString());
    }
}
