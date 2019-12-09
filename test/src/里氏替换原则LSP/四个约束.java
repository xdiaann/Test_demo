package 里氏替换原则LSP;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 1子类必须实现父类的抽象方法，但不得重写（覆盖）父类的非抽象（已实现）方法  可能会带来意想不到的错误。
 * 2子类中可以增加自己特有的方法。
 * 3当子类覆盖或实现父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。
 * 4当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。
 * @author: Mr.Z
 * @create: 2019-04-22 16:07
 */
class A {
    public void fun(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
    }

    void fun1(HashMap map) {
        System.out.println("父类被执行...");
    }

    public void fun2(Map map) {
        System.out.println("父类被执行...");
    }
}

class B extends A {
    @Override
    public void fun(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a - b));
    }

    //子类并非重写了父类的方法，而是重载了父类的方法。子类方法的参数Map比父类方法的参数HashMap的范围要大
    public void fun1(Map map) {
        System.out.println("子类被执行...");
    }

    public void fun2(HashMap map) {
        System.out.println("子类被执行...");
    }

    void newFun() {
        System.out.println("这是子类的新方法...");
    }
}

class demo {
    public static void main(String[] args) {
        System.out.println("父类的运行结果：");
        A a = new A();
        HashMap map = new HashMap();
        a.fun(1, 2);//1+2=3
        a.fun1(map);//父类被执行...
        a.fun2(map);//父类被执行...

        //子类B替代父类A
        System.out.println("子类运行结果");
        B b = new B();
        b.fun(1, 2);//1-2=-1
        b.fun1(map);//父类被执行...
        //在父类方法没有被重写的情况下，子方法被执行了，这样就引起了程序逻辑的混乱。所以子类中方法的
        //前置条件必须与父类中被覆写的方法的前置条件相同或者更宽松。即 父hashmap  子 map 没问题  父map 子hashmap 不行
        b.fun2(map);//子类被执行...
        b.newFun();//这是子类的新方法...

    }
}