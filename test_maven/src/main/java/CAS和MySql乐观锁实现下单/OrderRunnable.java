package CAS和MySql乐观锁实现下单;

import java.util.concurrent.CountDownLatch;

/**
 * @author MR.Z
 * @date 2020/2/11 1:04
 */
public class OrderRunnable implements Runnable {

    private CountDownLatch latch;
    private OrderService orderService;

    public OrderRunnable(CountDownLatch latch, OrderService orderService) {
        this.latch = latch;
        this.orderService = orderService;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderService.downOrder();
    }
}
