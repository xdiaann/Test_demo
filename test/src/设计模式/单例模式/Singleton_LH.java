package 设计模式.单例模式;

/**
 * @author MR.Z
 * @date 2020/6/23 0:14
 */
public class Singleton_LH {

    // DCL 双重接近完美 但是考虑倒指令重排下 可以考虑加volatile
    private static /*volatile*/ Singleton_LH  singleton_lh;

    private Singleton_LH() {
        System.out.println(Thread.currentThread().getName()+"\t"+"构造方法");
    }

    //DCL
    public static Singleton_LH getInstance() {
        if (singleton_lh == null) {
            //双重校验 解决多线程问题
            synchronized (Singleton_LH.class) {
            if (singleton_lh == null) {
                try {
                    Thread.sleep(222);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singleton_lh = new Singleton_LH();
            }
            }
        }
        return singleton_lh;
    }

    /*
     懒汉式  延迟创建   有线程安全问题
      */
    public static Singleton_LH getInstance1() {
        if (singleton_lh == null) {
            singleton_lh = new Singleton_LH();
        }
        return singleton_lh;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                Singleton_LH.getInstance1();
//
//            },String.valueOf(i)).start();
//        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Singleton_LH.getInstance();

            },String.valueOf(i)).start();
        }
    }

}
