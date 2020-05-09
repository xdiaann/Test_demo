package 深浅克隆.直接赋值;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MR.Z
 * @date 2019/12/30 16:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 邮件
    private String email;
    // 描述
    private String desc;

}
