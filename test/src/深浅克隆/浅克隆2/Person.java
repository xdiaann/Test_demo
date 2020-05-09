package 深浅克隆.浅克隆2;

import lombok.Data;

/**
 * @author MR.Z
 * @date 2019/12/30 21:27
 */
@Data
public class Person implements Cloneable {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 邮件
    private String email;
    // 将原来的 string desc 变成了 PersonDesc 对象，这样 personDesc 就是引用类型
    private PersonDesc personDesc;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setDesc(String desc) {
        this.personDesc.setDesc(desc);
    }

    public Person(String name, int age, String email, String desc) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.personDesc = new PersonDesc();
        this.personDesc.setDesc(desc);
    }
}
