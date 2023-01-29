package redis分布式锁;

public class DistributedLock_test_threadA extends Thread {
    private DistributedLock_test distributedLock_test;

    public DistributedLock_test_threadA(DistributedLock_test distributedLock_test) {
        this.distributedLock_test = distributedLock_test;
    }

    @Override
    public void run() {
        distributedLock_test.seckill();
    }
}

 class Test {
    public static void main(String[] args) {
        DistributedLock_test distributedLock_test = new DistributedLock_test();
        for (int i = 0; i < 50; i++) {
            DistributedLock_test_threadA threadA = new DistributedLock_test_threadA(distributedLock_test);
            threadA.start();
        }
    }
}
