package 抽象和接口;

public class test extends Dog implements Dog1 {


    @Override
    public void eat() {
        System.out.println(1);
    }

    @Override
    public void sleep() {

    }

    public static void main(String[] args) {
        test test = new test();
        test.eat();
    }
}
