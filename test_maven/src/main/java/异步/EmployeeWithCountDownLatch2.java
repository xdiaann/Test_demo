package 异步;

import java.util.concurrent.CountDownLatch;

/**
 * @author MR.Z
 * @date 2020/4/29 8:35
 */
public class EmployeeWithCountDownLatch2 extends Thread {

    private String employeeName;

    private long time;

    private CountDownLatch countDownLatch;

    public EmployeeWithCountDownLatch2(String employeeName, long time, CountDownLatch countDownLatch) {
        this.employeeName = employeeName;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(employeeName + " 1阶段-----开始");
            Thread.sleep(time);
            System.out.println(employeeName + " 1阶段-----完成");

            countDownLatch.countDown();

            System.out.println(employeeName + " 2阶段-----开始");
            Thread.sleep(time);
            System.out.println(employeeName + " 2阶段-----完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
