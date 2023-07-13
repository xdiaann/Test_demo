package 抽象和接口;

public class test extends DogA implements DogI {


    @Override
    public void eat() {
        System.out.println("testeat");
    }

    @Override
    public void sleep() {
        System.out.println("testsleep");
    }

    public static void main(String[] args) {
        test test = new test();
        test.eat();//testeat
        test.eat1();//eat1()
        test.sleep();//testsleep
        testI test1 = new testI();
        test1.eat();//2
    }


}

class testI extends DogA implements DogI {
    @Override
    public void eat() {
        System.out.println(2);
    }

    @Override
    public void sleep() {

    }
}

