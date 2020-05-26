package thread;

public class Test {
    public static void main(String[] args) {
        Add add = new Add();
//        ThreadFun thread1 = new ThreadFun(add);
//        ThreadFun thread2 = new ThreadFun(add);
//        ThreadFun thread3 = new ThreadFun(add);
//        thread1.start();
//        thread2.start();
//        thread3.start();

        for (int i = 0; i < 10; i++) {
            ThreadFun thread = new ThreadFun(add);
            thread.run();
        }
    }
}

class ThreadFun extends Thread {
    private final Add add;

    ThreadFun(Add add) {
        this.add = add;
    }

    public void run() {
//        synchronized (add) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            add.add();
//        }
    }
}

class Add {
    int num1;
    private int num2;

    void add() {
        num1 += 3;
        num2 += 3;
        System.out.println(num1 + " " + num2);
    }
}
