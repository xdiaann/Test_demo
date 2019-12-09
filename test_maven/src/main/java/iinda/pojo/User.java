package iinda.pojo;

import iinda.validator.enums.DateFormat;
import iinda.validator.validAnnotations.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-15 21:51
 */
@Data
public class User {

    @NotNull(message = "名字不能为空")
    @Length(min = 4, max = 10, message = "name 长度必须在 {min} - {max} 之间")
    private String name;

    @DateTimeFormat(DATE_FORMAT =DateFormat.YYYY_MM_DD_HH_MM_SS )
    private String birthday;

    @Phone
    private Long phone;

    @GreaterThan(value = 3)
    private int greaterThan;

    @LessThan(value = 3)
    private int lessThan;

    @DecimalGreaterThan(value = 3)
    private BigDecimal decimalGreaterThan;

    @DecimalLessThan(value = 3)
    private BigDecimal decimalLessThan;

    @In(value = "1,s,sdf,qe,32qwe,fd,21.221,你好")
    private Object[] abc;

    @IdNo
    private String idCard;
}
