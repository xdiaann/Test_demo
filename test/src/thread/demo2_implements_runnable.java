package thread;

public class demo2_implements_runnable {
    public static void main(String[] args) {
        //这种方式要好一些 毕竟java是单继承
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main"+i);
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable"+i);
        }
    }
}
