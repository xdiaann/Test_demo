package 尚硅谷面试;

import org.junit.Test;

//判断true or false
public class StringPool_intern {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        //“ss"和"ss"拼接成"ssss”,变量str指向堆中的"ssss",常量池中是没有"ssss"的。
        //intern()方法在常量池中的进行如下操作，如果有"ssss"就返回已有"ssss"的地址值，如果没有就在常量池中创建一个"ssss"并返回。
        // 这个时候就有人要问了一个指向堆空间，一个指向常量池，不应该返回false吗。这样想是对的，不过是在jdk7之前是对的
        //jdk7开始intern()方法逻辑变了。如果常量池中没有"ssss"，不是立即创建，而是看看堆中有没有，如果有就直接用堆中的数据。
        // 所以两个引用指向的都是堆中的"ssss"，返回true。 存疑
        //另一种说法是append 调用的不是new String() 而是 new String (char value[],int offset ,int count)
        //也就是说这个三个参数的new String没有在常量池中创建对象，因为他底层只是复制了一下
        //如 String s = new String (new char[]{'a','b'},0,2) 可以查看对应的字节码常量池有没有ab
        System.out.println(str1 == str1.intern());//true

        String str3 = new String("58tongcheng");
        System.out.println(str3 == str3.intern());//false

        System.out.println();

        // String str2 = "ja" + "va";  //此种方式为true
        String str2 = new StringBuilder("ja").append("va").toString();
        //只有java(或Version类中定义的静态常量)是false 其他都是true
        //在system类下initializeSystemClass方法中 sun.misc.Version.init();  里 定义了
        //  private static final String launcher_name = "java"; 等等
        //初始化的java进入字符串常量池 string table里 此时str2 在new一个  所以不是同一个
        System.out.println(str2 == str2.intern()); //只有java是false 其他都是true


    }

    @Test
    public void test_intern() {
        String a = "abc";
        String b = "abc";
        String c = "ab" + "c";
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
