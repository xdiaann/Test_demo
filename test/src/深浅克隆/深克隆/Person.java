package 深浅克隆.深克隆;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MR.Z
 * @date 2019/12/30 22:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 邮件
    private String email;

    private PersonDesc personDesc;


    /**
     * clone 方法不是简单的调用super的clone 就好，
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person person = (Person)super.clone();
        // 需要将引用对象也克隆一次
        person.personDesc = (PersonDesc) personDesc.clone();
        return person;
    }
}
