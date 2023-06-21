package 深浅克隆.浅克隆;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 通常情况没问题  但是对象里面包含了对象（浅克隆2）就不行  所以是浅克隆
 * @author MR.Z
 * @date 2019/12/30 17:00
 */
public class PersonApp {
    public static void main(String[] args) throws Exception {
        // 初始化一个对象
        Person person = new Person("张三",20,"123456@qq.com","我是张三");
        // 复制对象
        Person person1 = (Person) person.clone();
        // 改变 person1 的属性值
        person1.setName("我是张三的克隆对象");
        // 修改 person age 的值
        person1.setAge(22);
        person1.setEmail("250160@qq.com");
        person1.setDesc("我是张三克隆");
        System.out.println("person对象："+person);//person对象：Person(name=张三, age=20, email=123456@qq.com, desc=我是张三)
        System.out.println();
        //这种引用是一种特列，因为这些引用具有不可变性，并不具备通用性 通用性见浅拷贝2
        System.out.println("person1对象："+person1);//person1对象：Person(name=我是张三的克隆对象, age=22, email=250160@qq.com, desc=我是张三克隆)
        System.out.println(person== person1);

    }
}

@Getter
@Setter
@AllArgsConstructor
  class Person implements Cloneable {
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
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    //不改权限也可以?
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}
