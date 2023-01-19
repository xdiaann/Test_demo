package 设计模式.单例模式;

/**
 * @author MR.Z
 * @date 2020/8/20 19:19
 */
public class SingletonDemo {
    // DCL 双重接近完美 但是考虑倒指令重排下 可以考虑加volatile
    private static /*volatile*/ SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法SingletonDemo");
    }

    //如果不加synchronized 则在多线程情况下会生成多个 但是不全面 方法锁
    public  static synchronized SingletonDemo getInstance() {
        if (instance == null) {
             instance = new SingletonDemo();
        }
        return instance;
    }

    //DCL double check lock 双重检锁机制
    public  static SingletonDemo getInstanceWithDCL() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //单线程下没问题
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());

 /*       for (int i = 0; i < 11; i++) {
            new Thread(()->
            {
                SingletonDemo instance = SingletonDemo.getInstance();
                System.out.println(Thread.currentThread().getName()+"\t"+instance);
            },String.valueOf(i)).start();
        }*/

        for (int i = 0; i < 11; i++) {
            new Thread(()->
            {
                SingletonDemo instance = SingletonDemo.getInstanceWithDCL();
                System.out.println(Thread.currentThread().getName()+"\t"+instance);
            },String.valueOf(i)).start();
        }

    }
}
