package 尚硅谷面试.ReentrantLock;


public class BankSyncThreadTest {

    public static void main(String args[]) {
        Bank bank = new Bank();

        Thread tadd = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bank.addMoney(100);
                bank.lookMoney();
                System.out.println("");

            }
        });

        Thread tsub = new Thread(() -> {
            while (true) {
                bank.subMoney(100);
                bank.lookMoney();
                System.out.println("");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tsub.start();

        tadd.start();
    }

}
