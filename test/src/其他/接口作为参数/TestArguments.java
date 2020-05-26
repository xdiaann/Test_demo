package 其他.接口作为参数;

/**
 * @author MR.Z
 * @date 2019/12/18 0:37
 */
public class TestArguments {
    public static void main(String[] args) {
        //调用noSmoking方法，传递实现类对象
        //实现类对象时自己的对象
        Student s = new Student();
        noSmoking(s);

        noSmoking(new Student());

        //实现类对象，是采用多态创建出来的
        Smoking t = new Student();
        noSmoking(t);
    }

    /*
         * 定义方法，方法参数写成接口类型
         */
    public static void noSmoking(Smoking s) {
        //接口的引用变量s，调用方法
        s.smoking();
        //调用接口中的常量a
        System.out.println(Smoking.a);
    }

}

