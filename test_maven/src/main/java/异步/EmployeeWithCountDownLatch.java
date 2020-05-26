package 异步;

import java.util.concurrent.CountDownLatch;

/**
 * @author MR.Z
 * @date 2020/4/27 17:44
 */
public class EmployeeWithCountDownLatch extends Thread{
    private String employeeName;

    private long time;

    private CountDownLatch countDownLatch;

    public EmployeeWithCountDownLatch(String employeeName,long time, CountDownLatch countDownLatch){
        this.employeeName = employeeName;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(employeeName+ "开始准备");
            Thread.sleep(time);
            System.out.println(employeeName+" 准备完成");
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
