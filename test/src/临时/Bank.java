package 临时;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lixiaoxi
 */
public class Bank {

    private int count = 0;//账户余额


    //需要声明这个锁
    private Lock lock = new ReentrantLock();

    //存钱  第一种 synchronized
    /*public  void addMoney(int money){
        synchronized (this) {
            count += money;
            System.out.println(System.currentTimeMillis() + "存进：" + money);

        }
    }*/


    // 存钱  第二种 ReentrantLock
    public void addMoney(int money) {
        lock.lock();//上锁
        try {
            count += money;
            System.out.println(System.currentTimeMillis() + "存进：" + money);

        } finally {
            lock.unlock();//解锁
        }
    }

    //取钱  第一种 synchronized
   /* public  void subMoney(int money){
        synchronized (this) {
            if (count - money < 0) {
                System.out.println("取钱: 余额不足");
                return;
            }
            count -= money;
            System.out.println(+System.currentTimeMillis() + "取出：" + money);
        }
    }*/

    // 取钱  第二种 ReentrantLock
    public void subMoney(int money) {
        lock.lock();
        try {

            if (count - money < 0) {
                System.out.println("余额不足");
                return;
            }
            count -= money;
            System.out.println(+System.currentTimeMillis() + "取出：" + money);
        } finally {
            lock.unlock();
        }
    }

    //查询
    public void lookMoney() {
        System.out.println("账户余额：" + count);
    }
}
