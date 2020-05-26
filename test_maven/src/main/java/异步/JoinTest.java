package 异步;

/**
 * @author MR.Z
 * @date 2020/4/27 17:42
 */
public class JoinTest {
    //假设现在公司有三个员工A,B,C，他们要开会。但是A需要等B,C准备好之后再才能开始，B,C需要同时准备。
    //我们用join模拟上面的场景。
    public static void main(String[] args) throws InterruptedException {
        EmployeeWithJoin a = new EmployeeWithJoin("A", 3000);
        EmployeeWithJoin b = new EmployeeWithJoin("B", 3000);
        EmployeeWithJoin c = new EmployeeWithJoin("C", 4000);

        b.start();
        c.start();

        b.join();
        c.join();
        System.out.println("B,C准备完成");
        a.start();
    }
}
