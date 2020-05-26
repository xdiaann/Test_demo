package 异步;

/**
 * @author MR.Z
 * @date 2020/4/27 17:41
 */
public class EmployeeWithJoin extends Thread{

    private String employeeName;

    private long time;

    public EmployeeWithJoin(String employeeName, long time){
        this.employeeName = employeeName;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            System.out.println(employeeName+ "开始准备");
            Thread.sleep(time);
            System.out.println(employeeName+" 准备完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
