package 异步;

import java.util.concurrent.CountDownLatch;

/**
 * @author MR.Z
 * @date 2020/4/27 17:45
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        //CountDownLatch中我们主要用到两个方法一个是await()方法，调用这个方法的线程会被阻塞，另外一个是countDown()方法，
        //调用这个方法会使计数器减一，当计数器的值为0时，因调用await()方法被阻塞的线程会被唤醒，继续执行。
        CountDownLatch countDownLatch = new CountDownLatch(2);
//        EmployeeWithCountDownLatch a = new EmployeeWithCountDownLatch("A", 3000,countDownLatch);
//        EmployeeWithCountDownLatch b = new EmployeeWithCountDownLatch("B", 3000,countDownLatch);
//        EmployeeWithCountDownLatch c = new EmployeeWithCountDownLatch("C", 4000,countDownLatch);
//
//        b.start();
//        c.start();
//        countDownLatch.await();
//        System.out.println("B,C准备完成");
//        a.start();

        //分两个阶段  bc先完成
        EmployeeWithCountDownLatch2 a2 = new EmployeeWithCountDownLatch2("A", 3000,countDownLatch);
        EmployeeWithCountDownLatch2 b2 = new EmployeeWithCountDownLatch2("B", 3000,countDownLatch);
        EmployeeWithCountDownLatch2 c2 = new EmployeeWithCountDownLatch2("C", 4000,countDownLatch);

        b2.start();
        c2.start();
        countDownLatch.await();
        System.out.println("B,C 1阶段-----完成");
        a2.start();
    }
}
