package 多态;


//多态的一个作用体现
public class DuoTaiTest {
    public static void main(String[] args) {
        method(new Dog());
        method(new Cat());
    }

    public static void method(Animal animal) {
        animal.eat();
        animal.sleep();
    }
}

class Animal  {
    public void eat() {
        System.out.println("chi");
    }

    public void sleep() {
        System.out.println("shui");
    }
}

class Dog extends Animal{
    public void eat() {
        System.out.println("chibaba");
    }

    public void sleep() {
        System.out.println("shuilanjiao");
    }
}

class Cat extends Animal{
    public void eat() {
        System.out.println("chiyu");
    }

//    public void sleep() {
//        System.out.println("shuigepi");
//    }
}

/**
 * 测试多态的特性 子类没有父类的方法时 多态获取不到子类的方法
 */
class A {
    public void Eat(){
        System.out.println("爱吃大米饭");
    }
}
class B extends A{
    @Override
    public void Eat() {
        System.out.println("爱吃红烧肉");
    }

    public void Play(){
        System.out.println("爱玩游戏");
    }
}
class C extends B{
    @Override
    public void Play() {
        System.out.println("爱刷短视频");
    }
}

class Test_{
    public static void main(String[] args) {
        A a=new A();
        A b=new B();
        B c=new C();

        a.Eat();   //爱吃大米饭
        b.Eat();   //爱吃红烧肉
        B b1 = new B();
        //通过
        getEat(b1);   //爱吃红烧肉
        //###  b实际上是 A a= new B() 多态不能调用子类独有的方法  ###
//        b.Play()  会报错
        //调用父类的->B 的eat
        c.Eat();    //爱吃红烧肉
        c.Play();   //爱刷短视频
    }

    private static void getEat(A a) {
        a.Eat();
    }
}


