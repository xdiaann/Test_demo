package 深浅克隆.直接赋值;

/**
 * @author MR.Z
 * @date 2019/12/30 16:47
 */
public class PersonApp {
    public static void main(String[] args) {
        // 初始化一个对象
        Person person = new Person("张三",20,"123456@qq.com","我是张三");
        // 复制对象
        Person person1 = person;
        // 改变 person1 的属性值
        person1.setName("我不是张三了");
        System.out.println("person对象："+person);
        System.out.println("person1对象："+person1);

    }
}
