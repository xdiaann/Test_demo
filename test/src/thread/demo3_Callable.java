package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class demo3_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        Thread.State state = thread.getState();
        System.out.println(state);
        thread.start();
        state = thread.getState();
        System.out.println(state);
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            count += i;
        }
        return count;
    }
}