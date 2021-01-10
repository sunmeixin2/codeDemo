package code.ThreadDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author sunmeixin
 * @description
 * @date 2020-12-06
 */
public class SynchronizedDemo2 {

    Object object = new Object();
    public void method1() {
        synchronized (object) {

        }
    }
}

/**
 *
 * javac SynchronizedDemo2.java  编译为.class文件
 * javap -verbose SynchronizedDemo2.class 反编译查.class文件
 */
