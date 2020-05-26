package CAS和MySql乐观锁实现下单;

import org.springframework.data.repository.query.Param;

/**
 * @author MR.Z
 * @date 2020/2/11 1:02
 */
public interface OrderDoMapper {

    OrderDo selectByPrimaryKey(Integer id);

    int desStockByCas(@Param("orderId") int orderId,
                      @Param("oldStock") int oldStock, @Param("desStock") int desStock);

    int desStockByOptimistic(@Param("orderId") int orderId, @Param("oldVersion") int oldVersion,
                             @Param("desStock") int desStock);

    int desStockByLarge(@Param("orderId") int orderId,@Param("desStock") int desStock);

}
