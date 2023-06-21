package 深浅克隆.深克隆;


/**
 * @author MR.Z
 * @date 2019/12/30 21:37
 */
public class PersonApp {
    public static void main(String[] args) throws Exception {
        // 初始化一个对象
        Person person = new Person("平头哥",20,"123456@qq.com",new PersonDesc("我的公众号是：平头哥的技术博文"));
        // 复制对象
        Person person1 = (Person) person.clone();
        person1.setName("我是平头哥的克隆对象");
        person1.setAge(22);
        person1.setPersonDesc(new PersonDesc("我已经关注了平头哥的技术博文公众号"));
        //person对象： Person(name=平头哥, age=20, email=123456@qq.com, personDesc=PersonDesc(desc=我的公众号是：平头哥的技术博文))
        //person1对象：Person(name=我是平头哥的克隆对象, age=22, email=123456@qq.com, personDesc=PersonDesc(desc=我已经关注了平头哥的技术博文公众号))
        System.out.println("person对象："+person);
        System.out.println();
        //我们修改 person1 的 desc 字段之后，person 的 desc 也发生了改变，这说明 person 对象和 person1 对象指向是同一个 PersonDesc 对象地址
        System.out.println("person1对象："+person1);
    }
}
