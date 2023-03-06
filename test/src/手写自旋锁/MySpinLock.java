package 手写自旋锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author MR.Z
 * @date 2020/10/9 21:16
 */
public class MySpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {

        Thread thread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + " come in");

        while (!atomicReference.compareAndSet(null, thread)) {

        }

        System.out.println(Thread.currentThread().getName() + " locked");

    }

    public void unLock() {

        Thread thread = Thread.currentThread();

        atomicReference.compareAndSet(thread, null);

        System.out.println(Thread.currentThread().getName() + " unLock");
    }

    public static void main(String[] args) {
        MySpinLock mySpinLock = new MySpinLock();
        new Thread(() ->
        {
            mySpinLock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySpinLock.unLock();
        }, "A").start();

        new Thread(() ->
        {
            mySpinLock.lock();

            mySpinLock.unLock();
        }, "B").start();
    }
}
