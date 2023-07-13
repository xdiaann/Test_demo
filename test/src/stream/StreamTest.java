package stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("jack", 20));
        personList.add(new Person("mike", 25));
        personList.add(new Person("mike", 20));
        personList.add(new Person("tom", 30));

        List<Person> personList2 = new ArrayList<>();
        personList2.add(new Person("jack", 20));
        personList2.add(new Person("mike", 25));
        personList2.add(new Person("mike", 20));
        personList2.add(new Person("tom", 30));
//        personList.add(new Person(null, null));

        //这两种写法一样 lambda 方法引用
//        personList.forEach(x-> System.out.println(x));
//        personList.forEach(System.out::println);
        System.out.println("==============================");
        testFilter(personList2);
        System.out.println("==============================");
        testMap1(personList2);
        System.out.println("==============================");
        testMap(personList, personList2);

    }

    private static void testFilter(List<Person> personList) {

        List<Person> personList1 = personList;
        //filter(T -> boolean)
        //保留 boolean 为 true 的元素
        //保留Name为 jack 的 person 元素
        List<Person> collect = personList1.stream().filter(person -> "jack".equals(person.getName())).collect(toList());
        //personList1filterJack[Person{name='jack', age=20}]
        System.out.println("personList1filterJack" + collect);
        System.out.println("==============================");
        //保留Name为 mike 的 person 元素
        //personList1filterMike[Person{name='mike', age=25}, Person{name='mike', age=20}]
        personList1 = personList1.stream().filter(s -> "mike".equals(s.getName())).collect(toList());
        System.out.println("personList1filterMike" + personList1);
        System.out.println("==============================");
        personList1.forEach(System.out::println);
        System.out.println("==============================");
        //保留年龄为 20 的 person 元素
        personList = personList.stream().filter(person -> person.getAge() == 20).collect(toList());
        //personList[Person{name='jack', age=20}, Person{name='mike', age=20}]
        System.out.println("personList" + personList);
        personList.forEach(System.out::println);

    }

    //将某个字段转为list
    private static void testMap(List<Person> students, List<Person> students1) {
        List<String> collect = students.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(collect);//[jack, mike, mike, tom]
        collect.forEach(System.out::println);

        List<String> name = students.stream().map(s -> "name:" + s.getName()).collect(Collectors.toList());
        System.out.println(name);//[name:jack, name:mike, name:mike, name:tom]
        name.forEach(System.out::println);
    }

    private static void testMap1(List<Person> students) {
        //
        Map<Integer, Person> collect = students.stream().distinct().collect(Collectors.toMap(Person::getAge, a -> a));
        System.out.println("testMap : "+collect);
        int a = 1;
        short b = 2;

    }

    @Test
    public void testDistinct1() {
        //简单字符串的去重
        List<String> list = Arrays.asList("111", "222", "333", "111", "222");
        list.stream().distinct().forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        //map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> squaresList = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(squaresList);//[9, 4, 4, 9, 49, 9, 25]
        List<Integer> squaresList1 = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(squaresList1);//[9, 4, 49, 25]
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
        random.ints(0, 10).limit(100).forEach(System.out::println);
    }

    @Test
    public void test12() {

    }

    //filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
    @Test
    public void test13() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println(count);//2
    }
}
