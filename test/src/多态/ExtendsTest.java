package 多态;

import org.junit.Test;

/**
 * TODO 关于 ? extends T 和 ? super T 的存在意义和使用
 *
 * @author zd
 * @version 1.0, 2023/7/4 11:31
 */
public class ExtendsTest {
    //Lev 1
    class Food {
    }

    //Lev 2
    class Meat extends Food {
    }

    class Fruit extends Food {
    }

    //Lev 3
    class Banana extends Fruit {
    }

    class Apple extends Fruit {
    }

    class Pork extends Meat {
    }

    class Beef extends Meat {
    }

    //Lev 4
    class RedApple extends Apple {
    }

    class GreenApple extends Apple {
    }


    //盘子类 可以装水果的容易
    class Plate<T> {
        private T item;

        public Plate() {
        }

        public Plate(T t) {
            item = t;
        }

        public void set(T t) {
            item = t;
        }

        public T get() {
            return item;
        }

    }

    //Java编译器不允许这个操作。会报错，“装苹果的盘子”无法转换成“装水果的盘子”。
    //苹果 IS-A 水果
    //装苹果的盘子 NOT-IS-A 装水果的盘子
//    Plate<Fruit> p=new Plate<Apple>(new Apple());
    //?只能是Fruit的子类
//不能存入任何元素  只能取
    Plate<? extends Fruit> applePlate = new Plate<Apple>(new Apple());
    Plate<? extends Fruit> bananaPlate = new Plate<Banana>(new Banana());

    //
//    Plate<? super Fruit> b=new Plate<Apple>(new Apple());

    Plate<? super Fruit> foodPlate = new Plate<Food>(new Food());

    @Test
    public void test() {

          //不能存入任何元素
//        applePlate.set(new Fruit());    //Error
//        applePlate.set(new Apple());    //Error

        //读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1 = applePlate.get();
        Apple newFruit2 = (Apple) applePlate.get();

        //存入元素正常
        foodPlate.set(new Fruit());
        foodPlate.set(new Apple());

        //读取出来的东西只能存放在Object类里。
        Object object = foodPlate.get();

    }

}
