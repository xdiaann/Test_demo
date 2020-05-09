package 深浅克隆.浅克隆;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author MR.Z
 * @date 2019/12/30 16:59
 */
@Data
@AllArgsConstructor
public class Person implements Cloneable {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 邮件
    private String email;
    // 描述
    private String desc;

    /*
     * 重写 clone 方法，需要将权限改成 public ，直接调用父类的 clone 方法就好了
     */
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
    //不改权限也可以?
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
