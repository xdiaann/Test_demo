package 尚硅谷面试;

//判断true or false
public class StringPool_intern {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();

//        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());
        System.out.println(str1.equals(str1.intern()));

        System.out.println();
        // String str2 = "ja" + "va";  //此种方式为true
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        //只有java(或Version类中定义的静态常量)是false 其他都是true
        //在system类下initializeSystemClass方法中 sun.misc.Version.init();  里 定义了
        //  private static final String launcher_name = "java"; 等等
        //初始化的java进入字符串常量池 string table里 此时str2 在new一个  所以不是同一个
        System.out.println(str2 == str2.intern()); //只有java是false 其他都是true
        System.out.println(str2.equals(str2.intern()));


    }
}
