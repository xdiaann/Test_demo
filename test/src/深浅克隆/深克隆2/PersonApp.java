package 深浅克隆.深克隆2;

/**
 * @author MR.Z
 * @date 2019/12/30 22:55
 */
public class PersonApp {
    public static void main(String[] args) throws Exception {
        // 初始化一个对象
        Person person = new Person("平头哥",20,"123456@qq.com",new PersonDesc("我的公众号是：平头哥的技术博文"));
        // 复制对象
        Person person1 = (Person) person.clone();
        // 改变 person1 的属性值
        person1.setName("我是平头哥的克隆对象");
        // 修改 person age 的值
        person1.setAge(22);
        person1.setDesc("我已经关注了平头哥的技术博文公众号");
        System.out.println("person对象："+person);
        System.out.println();
        System.out.println("person1对象："+person1);
    }
}
