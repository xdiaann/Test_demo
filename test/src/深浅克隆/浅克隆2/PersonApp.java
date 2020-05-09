package 深浅克隆.浅克隆2;

/**
 * @author MR.Z
 * @date 2019/12/30 21:37
 */
public class PersonApp {
    public static void main(String[] args) throws Exception {
        // 初始化一个对象
        Person person = new Person("000",20,"123456@qq.com","000");
        // 复制对象
        Person person1 = (Person) person.clone();
        // 改变 person1 的属性值
        person1.setName("111");
        // 修改 person age 的值
        person1.setAge(22);
        person1.setDesc("111");
        System.out.println("person对象："+person);
        System.out.println();
        //我们修改 person1 的 desc 字段之后，person 的 desc 也发生了改变，这说明 person 对象和 person1 对象指向是同一个 PersonDesc 对象地址
        System.out.println("person1对象："+person1);
    }
}
