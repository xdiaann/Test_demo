package Lock;

public class demo {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread thread = new Thread(() -> {
            synchronized (o) {
            }
        });

        synchronized (o) {
            thread.start();
//            Thread.sleep(500);
            System.out.println(thread.getState());
            Thread.sleep(500);
            System.out.println(thread.getState());
        }
        System.out.println(11);
    }
}
