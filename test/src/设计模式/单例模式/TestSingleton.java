package 设计模式.单例模式;

import java.util.concurrent.*;

/**
 * @author MR.Z
 * @date 2020/6/22 23:53
 */
public class TestSingleton {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Singleton_EH singleton_eh = Singleton_EH.INSTANCE;
        System.out.println(singleton_eh);

        Singleton_EH singleton_eh1 = Singleton_EH.INSTANCE;
        System.out.println(singleton_eh1);

        Singleton_LH singleton_lh1 = Singleton_LH.getInstance();
        Singleton_LH singleton_lh2 = Singleton_LH.getInstance();
        System.out.println(singleton_lh1);
        System.out.println(singleton_lh2);


        Callable<Singleton_LH> callable = new Callable<Singleton_LH>() {
            @Override
            public Singleton_LH call() throws Exception {
                return Singleton_LH.getInstance();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Singleton_LH> submit = executorService.submit(callable);
        Future<Singleton_LH> submit1 = executorService.submit(callable);
        Singleton_LH singleton_lh3 = submit.get();
        Singleton_LH singleton_lh4 = submit1.get();

        System.out.println(singleton_lh3==singleton_lh1);
        System.out.println(singleton_lh4);
        System.out.println(singleton_lh1);
        executorService.shutdown();

        SingletonDemo singletonDemo = SingletonDemo.getInstance();
        SingletonDemo singletonDemo2 = SingletonDemo.getInstance();
        System.out.println(singletonDemo == singletonDemo2);

    }
}
