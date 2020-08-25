package iinda.pojo;

import iinda.utils.RegexType;
import iinda.utils.Validate;
import lombok.Data;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-16 00:25
 */
@Data
public class Person extends BaseDto{
    @Validate(regexType=RegexType.EMAIL)
    private String email;
    @Validate(maxLength=10,minLength=10)
    private String name;
    @Validate(regexType=RegexType.PHONENUMBER)
    private String phone;
    @Validate(nullable=false)
    private String address;


}
