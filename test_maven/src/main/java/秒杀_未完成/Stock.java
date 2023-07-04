package 秒杀_未完成;

import java.io.Serializable;

/**
 * (Stock)实体类
 *
 * @author makejava
 * @since 2020-05-06 17:46:50
 */
public class Stock implements Serializable {
    private static final long serialVersionUID = 851309432704821560L;
    
    private Object id;
    /**
    * 名称
    */
    private String name;
    /**
    * 库存
    */
    private Integer count;
    /**
    * 已售
    */
    private Integer sale;
    /**
    * 乐观锁，版本号
    */
    private Integer version;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
