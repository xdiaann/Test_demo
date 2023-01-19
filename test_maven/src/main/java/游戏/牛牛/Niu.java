package 游戏.牛牛;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：luoxiang
 * @description：
 * @date ：2020/5/18 11:43
 */
@Data
@ToString
public class Niu extends Model<Niu> {
    Integer id;
    Integer userId;
    Integer userName;
    List<String> list;
    String niu;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
