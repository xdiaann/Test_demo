package 其他;

public class Circular_reference_problem {

    private Circular_reference_problem instance;

    public static void main(String[] args) {
        //循环引用问题
        Circular_reference_problem a = new Circular_reference_problem();
        Circular_reference_problem b = new Circular_reference_problem();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

    }
}
