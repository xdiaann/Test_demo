package 设计模式.单例模式;

/**
 * @author MR.Z
 * @date 2020/6/23 0:14
 */
public class Singleton_LH {
    /*
    懒汉式  延迟创建   有线程安全问题
     */

    private static Singleton_LH singleton_lh;

    private Singleton_LH() {

    }

    public static Singleton_LH getInstance() {
        if (singleton_lh == null) {
            //双重校验 解决多线程问题
//            synchronized (Singleton_LH.class) {
                if (singleton_lh == null) {
                    try {
                        Thread.sleep(222);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singleton_lh = new Singleton_LH();
                }
//            }
        }
        return singleton_lh;
    }
}
