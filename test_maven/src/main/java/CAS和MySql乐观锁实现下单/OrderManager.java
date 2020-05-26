package CAS和MySql乐观锁实现下单;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MR.Z
 * @date 2020/2/11 1:03
 */
@Component(value = "orderManager")
public class OrderManager {
    @Autowired
    private OrderDoMapper orderDoMapper;

    public OrderDoMapper getDao(){
        return this.orderDoMapper;
    }


    public int desStockByCas(int orderId, int oldStock, int desStock){
        return orderDoMapper.desStockByCas(orderId,oldStock, desStock);
    }


    public int desStockByOptimistic(int orderId, int oldVersion, int desStock){
        return orderDoMapper.desStockByOptimistic(orderId, oldVersion, desStock);
    }


    public int desStockByLarge(int orderId, int desStock){
        return orderDoMapper.desStockByLarge(orderId, desStock);
    }

}
