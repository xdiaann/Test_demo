package 深浅克隆.浅克隆;

/**
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

    }
}
