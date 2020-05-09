package 深浅克隆.深克隆;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MR.Z
 * @date 2019/12/30 22:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDesc implements Cloneable{

    // 描述
    private String desc;
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
