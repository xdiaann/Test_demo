package 多态;


//多态的一个作用体现
public class AnimalTest {
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

    public void sleep() {
        System.out.println("shuigepi");
    }
}



