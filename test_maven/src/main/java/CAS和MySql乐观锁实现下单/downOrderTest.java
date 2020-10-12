package CAS和MySql乐观锁实现下单;

import org.junit.Test;

/**
 * @author MR.Z
 * @date 2020/2/11 1:04
 */
public class downOrderTest {



    @Test
    public void downOrderTest() throws InterruptedException {
        OrderService orderService=new OrderService();
        orderService.downOrder();
//        CountDownLatch latch = new CountDownLatch(1);
//        for (int i=0; i < 50; i++){
//            Thread t = new Thread(new OrderRunnable(latch, orderService));
//            t.start();
//        }
//        latch.countDown();
//        Thread.sleep(10000);
    }
}
