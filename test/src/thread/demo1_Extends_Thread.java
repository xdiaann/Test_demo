package thread;

public class demo1_Extends_Thread {
    public static void main(String[] args) {
        Myjob myjob = new Myjob();
        //注意run和starter的区别
        myjob.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:"+i);
        }
    }
}

class Myjob extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("myjob:"+i);
        }
    }
}
