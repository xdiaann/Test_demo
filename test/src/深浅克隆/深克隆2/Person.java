package 深浅克隆.深克隆2;

import lombok.*;

import java.io.*;

/**
 * 实现 Serializable 接口方式也可以实现深拷贝，而且这种方式还可以解决多层克隆的问题，
 * 多层克隆就是引用类型里面又有引用类型，层层嵌套下去，用 Cloneable 方式实现还是比较麻烦的，一不小心写错了就不能实现深拷贝了
 * @author MR.Z
 * @date 2019/12/30 22:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 369285298572941L;
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 邮件
    private String email;

    private PersonDesc personDesc;



    public Person clone() {
        Person person = null;
        try { // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            person = (Person) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void setDesc(String desc) {
        this.personDesc.setDesc(desc);
    }
}
