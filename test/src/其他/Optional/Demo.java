package 其他.Optional;

import org.junit.Assert;
import org.junit.Test;
import stream.Person;

import java.util.Optional;

/**
 * @author MR.Z
 * @描述:
 * @date 2019/12/4 18:25
 */
public class Demo {
    /**
     * 测试Optional包装类的创建方式， 两种创建方式
     *
     * @see java.util.Optional#of(Object)
     * @see java.util.Optional#ofNullable(Object)
     */
    @Test
    public void testCreate() {
        // create one
        Optional<Person> ofNullable = Optional.<Person>ofNullable(new Person());
        Optional<Person> of = Optional.<Person>of(new Person());

        // 获取create one中封装的对象
        if (ofNullable.isPresent()) {
            Person object = ofNullable.get();
            System.out.println(object);
            Assert.assertNotNull(object);
        }
        // 获取create one中封装的对象
        if (of.isPresent()) {
            Person object = ofNullable.get();
            System.out.println(object);
            Assert.assertNotNull(object);
        }
    }

    /**
     * 测试Optional类的ifPresent方法
     *
     * @see java.util.Optional#ifPresent(java.util.function.Consumer)
     */
    @Test
    public void testIfPresent() {

        // create one
        Optional<Person> userOne = Optional.<Person>ofNullable(new Person());
        // 用LAMDA表达式实现Consumer接口
        userOne.ifPresent(e -> e.setName("yanghang"));
        // test
        System.out.println(userOne.get().getName());
    }

    /**
     * 测试Optional类的filter方法
     *
     * @see java.util.Optional#filter(java.util.function.Predicate)
     */
    @Test
    public void testFilter() {
        // create one
        Optional<Person> userOne = Optional.<Person>ofNullable(new Person());
        // 用LAMDA表达式实现Predicate接口
        userOne = userOne.filter(e -> {
            return e.getName() == null || "".equals(e.getName());
        });
        // test
        Assert.assertTrue(userOne.isPresent());
    }

    /**
     * 测试Optional类的map方法和flatMap方法
     *
     * @see java.util.Optional#map(java.util.function.Function)
     * @see java.util.Optional#flatMap(java.util.function.Function)
     */
    @Test
    public void testMapAndFlatMap() {
        // create one
        Person user = new Person("yanghang@163.com");
        Optional<Person> userOne = Optional.<Person>ofNullable(user);
        // 用LAMDA表达式实现Function接口
        Optional<Person> personOne = userOne.map(e -> {
            Person per = new Person();
            per.setName(e.getName());
            return per;
        });
        // test
        System.out.println(personOne.get().getName());
    }

    /**
     * 测试Optional类的orElse方法
     *
     * @see java.util.Optional#orElse(Object)
     */
    @Test
    public void testOrElse() {
        Optional<Person> userOne = Optional.<Person>ofNullable(null);
        // 用LAMDA表达式实现Function接口
        Person user = userOne.orElse(new Person("anqichong@163.com"));
        // test
        System.out.println(user.getName());
    }
}
