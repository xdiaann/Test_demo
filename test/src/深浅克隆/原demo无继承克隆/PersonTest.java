package 深浅克隆.原demo无继承克隆;

import lombok.*;

/**
 * 两者是指向同一个地址值 即便只修改了person1 person也会改变
 *
 * @author yangwu
 * @version 1.0, 2023/6/19 17:51
 */
public class PersonTest {
    public static void main(String[] args) {
        // 初始化一个对象
        Person person = new Person("张三",20,"123456@qq.com","我是张三");
        // 复制对象
        Person person1 = person;
        // 改变 person1 的属性值
        person1.setName("我不是张三了");
        //person对象：Person(name=我不是张三了, age=20, email=123456@qq.com, desc=我是张三)
        //person1对象：Person(name=我不是张三了, age=20, email=123456@qq.com, desc=我是张三)
        //所以两者是指向同一个地址值 即便只修改了person1 person也会改变
        System.out.println("person对象："+person);
        System.out.println("person1对象："+person1);

    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Person {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 邮件
    private String email;
    // 描述
    private String desc;

}