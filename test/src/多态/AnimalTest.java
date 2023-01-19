package 多态;


import javax.swing.*;

//多态的一个作用体现
public class AnimalTest {
    public static void main(String[] args) {
        method(new dog());
        method(new cat());

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

class dog extends Animal{
    public void eat() {
        System.out.println("chibaba");
    }

    public void sleep() {
        System.out.println("shuilanjiao");
    }
}

class cat extends Animal{
    public void eat() {
        System.out.println("chiyu");
    }

    public void sleep() {
        System.out.println("shuigepi");
    }
}



