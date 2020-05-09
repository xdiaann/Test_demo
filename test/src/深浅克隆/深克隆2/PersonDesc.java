package 深浅克隆.深克隆2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author MR.Z
 * @date 2019/12/30 22:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDesc implements Serializable {

    private static final long serialVersionUID = 872390113109L;
    // 描述
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
