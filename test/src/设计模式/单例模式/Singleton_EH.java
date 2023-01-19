package 设计模式.单例模式;

import lombok.Data;

/**
 * @author MR.Z
 * @date 2020/6/22 23:47
 */
public class Singleton_EH {
    //饿汉式 在类初始化时直接创建  不管你需不要需要   不存在线程安全问题
    String name;
    String age;

    public static final Singleton_EH INSTANCE = new Singleton_EH();

    private Singleton_EH() {
        System.out.println("Singleton_EH构造方法执行啦...");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            new Thread(()->
            {
                Singleton_EH instance = Singleton_EH.INSTANCE();
                System.out.println(Thread.currentThread().getName()+"\t"+instance);
            },String.valueOf(i)).start();
        }
    }

    private static Singleton_EH INSTANCE() {
        return INSTANCE;
    }

}
