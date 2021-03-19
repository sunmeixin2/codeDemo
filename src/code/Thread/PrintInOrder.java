package code.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunmeixin
 * @description 按序打印
 * @date 2021-02-10
 */
public class PrintInOrder {

    public PrintInOrder() {

    }

//    AtomicInteger first = new AtomicInteger(0);
//    AtomicInteger second = new AtomicInteger(0);

    Semaphore first = new Semaphore(0);
    Semaphore second = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
//        first.incrementAndGet();

        first.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
//        while (first.get() == 1) {
//            printSecond.run();
//            second.incrementAndGet();
//        }

        first.acquire();
        printSecond.run();
        second.release();

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
//        while (second.get() == 1) {
//            printThird.run();
//        }

        second.acquire();
        printThird.run();
    }
}
