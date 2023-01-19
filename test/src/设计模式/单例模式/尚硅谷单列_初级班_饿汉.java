package 设计模式.单例模式;

import java.util.concurrent.*;

public class 尚硅谷单列_初级班_饿汉 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Bank> callable = Bank::getInstance;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Bank> submit = executorService.submit(callable);
        Future<Bank> submit1 = executorService.submit(callable);
        Future<Bank> submit2 = executorService.submit(callable);
        Bank singleton_lh3 = submit.get();
        Bank singleton_lh4 = submit1.get();
        Bank singleton_lh5 = submit2.get();
        System.out.println(singleton_lh3 == singleton_lh4);
        System.out.println(singleton_lh3 == singleton_lh5);
        executorService.shutdown();
    }

}


class Bank {
    //1 私有化构造器  不能 bank bank = new bank()
    private Bank() {

    }

    //2 内部
    private static Bank instance = new Bank();

    public static Bank getInstance() {
        return instance;
    }
}