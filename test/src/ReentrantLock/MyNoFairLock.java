package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MR.Z
 * @date 2020/10/8 20:55
 */
public class MyNoFairLock {

    /**
     *     false 表示 ReentrantLock 的非公平锁  `运行后发现启动和获得锁是[不]一致的
     */
    private ReentrantLock lock = new ReentrantLock(false);

    public  void testFail(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +"获得了锁");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        MyNoFairLock nonfairLock = new MyNoFairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"启动");
            nonfairLock.testFail();
        };
        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }
    }
}

