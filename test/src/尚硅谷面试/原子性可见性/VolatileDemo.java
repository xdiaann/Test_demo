package 尚硅谷面试.原子性可见性;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile    提供轻量级的同步机制  保证可见性   禁止指令重排(重排序) 不保证原子性
 *
 * 为什么能解决可见性不能解决原子性
 * 可见性即每次副本操作时都会写回主内存中  但是多线程的情况下 原子性将不能保证
 * 如何解决原子性  1 加 sync 2 使用juc下的atomicInteger
 *
 * @author MR.Z
 * @date 2020/8/1 15:12
 */

public class VolatileDemo {

    public static void main(String[] args) {

        可见性ByVolatile();

//        原子性();

    }

    private static void 原子性() {
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 2000; j++) {
                    myData.addIntPlus();
                    //此处有疑问  多线程环境下  如果不加下面这句  则 number数值的原子性会有问题 结果比预期相差较大
                    // 但是加了之后没问题,偶尔会出现结果比预期少1  猜测每次操作的时候会将数据写回主内存
                    System.out.println(Thread.currentThread().getName() + "\t" + myData.number);
                    myData.addAtomicInt();
                }
            }, String.valueOf(i)).start();
        }
        //为什么大于2  因为默认有两个线程  mian线程和GC线程
        while (Thread.activeCount() > 2) {
//            System.out.println("while: "+
//            Thread.activeCount());
            Thread.yield();//礼让线程
        }
        System.out.println(Thread.currentThread().getName() + " number value " + myData.number); //小于20000

        System.out.println(Thread.currentThread().getName() + " atomicInteger value " + myData.atomicInteger); //20000
    }


    //可见性
    private static void 可见性ByVolatile() {
        MyData myData = new MyData();
        System.out.println("myData.number: " + myData.number);
        new Thread(() -> {
            String name = Thread.currentThread().getName();

            System.out.println(name + "\t come in");
            try {
                //sleep会刷新工作内存 如果下面两句换位置(myData.addTO60()放在上面) 即先更新值在刷新内存 则不加volatile也可以跑完
                TimeUnit.SECONDS.sleep(1);
                myData.addTO60();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + "\t update number value: " + myData.number);
        }, "AAA").start();

        System.out.println(Thread.currentThread().getName() + "\t number value: " + myData.number);

        //循环等待 直到不等于0执行下面的语句
        //如果number 不加volatile 则一直在这里等待 没有可见性
        while (myData.number == 0) {

//            System.out.println("waiting:"+myData.number);  //疑问:如果加了这句 则可以执行完

        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}

class MyData {
    //加上volatile 后 只要有一个线程改了 主内存会修改值 可见性问题解决   可以正常跑完
    /*volatile*/ int number = 0;

    public void addTO60() {
        number = 60;
    }

    //加synchronized 可以保证原子性 但是太笨重
    public /*synchronized*/ void addIntPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomicInt() {
        atomicInteger.getAndIncrement();
    }
}
