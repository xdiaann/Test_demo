package CAS和MySql乐观锁实现下单;

/**
 * @author MR.Z
 * @date 2020/2/11 1:01
 */
public class OrderDo {
    private Integer id;

    private Integer version;

    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
