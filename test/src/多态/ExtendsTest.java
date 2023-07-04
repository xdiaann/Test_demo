package 多态;

/**
 * TODO 关于 ? extends T 和 ? super T 的存在意义和使用
 *
 * @author zd
 * @version 1.0, 2023/7/4 11:31
 */
public class ExtendsTest {
    //Lev 1
    class Food{}
    //Lev 2
    class Meat extends Food{}
    class Fruit extends Food{}
    //Lev 3
    class Banana extends Fruit{}
    class Apple extends Fruit {}
    class Pork extends Meat{}
    class Beef extends Meat{}
    //Lev 4
    class RedApple extends Apple{}
    class GreenApple extends Apple{}



    //盘子类 可以装水果的容易
    class Plate<T>{
        private T item;
        public Plate(T t){item=t;}
        public void set(T t){item=t;}
        public T get(){return item;}
    }

    //Java编译器不允许这个操作。会报错，“装苹果的盘子”无法转换成“装水果的盘子”。
    //苹果 IS-A 水果
    //装苹果的盘子 NOT-IS-A 装水果的盘子
//    Plate<Fruit> p=new Plate<Apple>(new Apple());
    //?只能是Fruit以下的
//不能存入任何元素
    Plate<? extends Fruit> a=new Plate<Apple>(new Apple());

    Fruit newFruit1=a.get();


    //
//    Plate<? super Fruit> b=new Plate<Apple>(new Apple());

    Plate<? super Fruit> b=new Plate<Food>(new Food());



}
