import lombok.Builder;
import lombok.Data;

/**
 * @author MR.Z
 * @date 2020/1/15 16:15
 */
@Data
@Builder
public class UserVO {
    private String name;
    private long id;
}
