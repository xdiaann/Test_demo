package 游戏.牛牛;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author MR.Z
 * @date 2020/5/18 17:21
 */
@Data
@AllArgsConstructor
public class ResultEntity {
    int code; // 结果代码
    String message; // 消息提示
    Object content; // 具体结果内容

}

