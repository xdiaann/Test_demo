package 其他;

/**
 * @author MR.Z
 * @date 2020/5/11 10:19
 */
public class LifeCycle {
    // 构造函数
    public LifeCycle() {
        System.out.println("构造函数初始化");
    }
    // 静态属性
    private static String staticField = getStaticField();
    // 静态方法块
    static {
        System.out.println(staticField);
        System.out.println("静态方法块初始化");
    }
    // 普通属性
    private String field = getField();
    // 普通方法块
    {
        System.out.println(field);
    }


    public static String getStaticField() {
        return "Static Field Initial";
    }

    public static String getField() {
        return "Field Initial";
    }

    //静态属性初始化
    //静态方法块初始化
    //普通属性初始化
    //普通方法块初始化
    //构造函数初始化
    public static void main(String[] argc) {
        new LifeCycle();
    }
}

