package 异步;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author MR.Z
 * @date 2020/4/26 10:55
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行……");
        //第一个子线程执行
        ExecutorService es1 = Executors.newSingleThreadExecutor();
//        Executors.
        es1.execute(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("子线程：" + Thread.currentThread().getName() + "执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        es1.shutdown();
        System.out.println("zzz");
        //第二个子线程执行
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程：" + Thread.currentThread().getName() + "执行");
            latch.countDown();
        });
        es2.shutdown();
        System.out.println("等待两个线程执行完毕……");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");
        System.out.println("业务逻辑...");
    }
}
