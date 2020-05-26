package 其他.接口作为参数;

/**
 * @author MR.Z
 * @date 2019/12/18 0:37
 */
public class Student implements Smoking {
    @Override
    public void smoking() {
        System.out.println("请不要吸烟");
    }

}
