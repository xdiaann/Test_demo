package CAS和MySql乐观锁实现下单;

import lombok.Data;

/**
 * @author MR.Z
 * @date 2020/2/11 1:01
 */
@Data
public class OrderDo {
    private Integer id;

    private Integer version;

    private Integer stock;
}
