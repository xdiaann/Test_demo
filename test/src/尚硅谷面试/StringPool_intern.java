package 尚硅谷面试;

import org.junit.Test;

//判断true or false
public class StringPool_intern {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();

//        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println("等等 " + str1 == str1.intern());
        System.out.println("equals " + str1.equals(str1.intern()));

        System.out.println();
        // String str2 = "ja" + "va";  //此种方式为true
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern());
        //只有java(或Version类中定义的静态常量)是false 其他都是true
        //在system类下initializeSystemClass方法中 sun.misc.Version.init();  里 定义了
        //  private static final String launcher_name = "java"; 等等
        //初始化的java进入字符串常量池 string table里 此时str2 在new一个  所以不是同一个
        System.out.println("等等 " + str2 == str2.intern()); //只有java是false 其他都是true
        System.out.println("equals " + str2.equals(str2.intern()));


    }

    @Test
    public void test_intern() {
        String a = "abc";
        String b = "abc";
        String c = "ab"+"c";
        System.out.println(a == b);//true
        System.out.println(c == b);//true
        //此时都位于字符串常量池?
        System.out.println(a == a.intern());//true
        System.out.println(a == b.intern());//true
        System.out.println(a == c.intern());//true
        //d位于堆中
        String d = new String("abc");
        System.out.println(a == d);//false
        //intern 后位于常量池中?
        System.out.println(a == d.intern());//true

    }


}
