package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("jack", 20));
        personList.add(new Person("mike", 25));
        personList.add(new Person("mike", 20));
        personList.add(new Person("tom", 30));
        personList.forEach(System.out::println);
//        testFilter(personList);
        testMap(personList);
    }

    private static void testFilter(List<Person> personList) {

        List<Person> personList1 = personList;
        //保留Name为 mike 的 person 元素
        personList1 = personList1.stream().filter(s -> "mike".equals(s.getName())).collect(Collectors.toList());
        System.out.println("personList1" + personList1);
        personList1.forEach(x-> System.out.println(x.getName()));
        //下面这两种写法一样
//        personList1.forEach(x-> System.out.println(x));
        personList1.forEach(System.out::println);
        //保留年龄为 20 的 person 元素
        personList = personList.stream().filter(person -> person.getAge() == 20).collect(toList());
        System.out.println("personList" + personList);
        personList.forEach(System.out::println);

    }

    private static void testMap(List<Person> students) {
        //在地址前面加上部分信息，只获取地址输出
        List<String> name = students.stream().map(s ->"name:"+s.getName()).collect(Collectors.toList());
        name.forEach(System.out::println);
    }

    @Test
    public void testDistinct1() {
        //简单字符串的去重
        List<String> list = Arrays.asList("111","222","333","111","222");
        list.stream().distinct().forEach(System.out::println);
    }

    //stream() − 为集合创建串行流。
    @Test
    public void test10() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
    }

    //Stream 提供了新的方法 ‘forEach’ 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数
    @Test
    public void test11() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    //map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
    @Test
    public void test12() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        List<Integer> squaresList1 = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);//[9, 4, 4, 9, 49, 9, 25]
        System.out.println(squaresList1);//[9, 4, 49, 25]
    }

    //filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
    @Test
    public void test13() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);//2
    }
}
