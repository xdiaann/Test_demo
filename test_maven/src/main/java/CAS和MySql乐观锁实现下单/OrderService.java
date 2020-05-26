package CAS和MySql乐观锁实现下单;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MR.Z
 * @date 2020/2/11 1:04
 */
@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderManager orderManager;

    @Transactional
    public void downOrder(){

        int orderId = 1;
        int desStock = 1;
        OrderDo orderDo = orderManager.getDao().selectByPrimaryKey(orderId);
        if (orderDo.getStock() <=0 ){
            LOGGER.info(Thread.currentThread().getName()+" :无库存.....");
            return;
        }

        //CAS
        int result = orderManager.desStockByCas(orderId, orderDo.getStock(), desStock);
        //乐观锁
//        int result = orderManager.desStockByOptimistic(orderId, orderDo.getVersion(), desStock);
//
//      //大于
//        int result = orderManager.desStockByLarge(orderId, desStock);
        if (result > 0){
            LOGGER.info(Thread.currentThread().getName()+ " 下单成功...");
        }else {
            LOGGER.info(Thread.currentThread().getName()+ " 下单失败...");
        }

    }
}
