package 类的初始化;

/**
 * @author MR.Z
 * @date 2020/7/12 18:44
 */
public class Son extends Father{

    //super  i test 子类的非静态代码块 子类的无参构造器
    
    private int i = test();

    private static int j = method();



    static {
        System.out.print("(6)");
    }

    Son() {

        System.out.print("(7)");
    }

    {

        System.out.print("(8)");
    }

    public int test() {
        System.out.print("(9)");
        return 1;
    }

    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        //(5)(1)(10)(6)(9)此处因为new的是子类 子类重写了该方法所以是9 (3)(2)(9)(8)(7)
        //(9)(3)(2)(9)(8)(7)
        Son son = new Son();
        System.out.println();
        Son son1 = new Son();


    }

}
