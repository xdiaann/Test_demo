package 深浅克隆.浅克隆2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 这里的浅克隆是另一种特殊情况 Person类中有另一个PersonDesc类
 * @author MR.Z
 * @date 2019/12/30 21:37
 */
public class PersonApp {
    public static void main(String[] args) throws Exception {
        // 初始化一个对象
        Person person = new Person("000",20,"123456@qq.com",new PersonDesc("000"));
        // 复制对象
        Person person1 = (Person) person.clone();
        // 改变 person1 的属性值
        person1.setName("111");
        // 修改 person age 的值
        person1.setAge(22);
        /**
         * 这里是修改 person1 的 desc
         */
        person1.getPersonDesc().setDesc("111");
        System.out.println("person对象："+person);//person对象：Person(name=000, age=20, email=123456@qq.com, personDesc=PersonDesc(desc=111))
        System.out.println();
        //修改 person1 的 desc 字段之后，person 的 desc 也发生了改变，这说明 person 对象和 person1 对象指向是同一个 PersonDesc 对象地址
        System.out.println("person1对象："+person1);//person1对象：Person(name=111, age=22, email=123456@qq.com, personDesc=PersonDesc(desc=111))
        System.out.println(person== person1);
    }
}

@Data
@AllArgsConstructor
 class Person implements Cloneable {
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

}


@Data
@AllArgsConstructor
class PersonDesc {
    // 描述
    private String desc;

}
