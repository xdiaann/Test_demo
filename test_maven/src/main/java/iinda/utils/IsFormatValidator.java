package iinda.utils;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * @description: 自定义注解验证不能为空和长度
 * @author: Mr.Z
 * @create: 2019-04-16 00:32
 */
public class IsFormatValidator implements ConstraintValidator<IsFormat, Object>{

    private int valueLength;
    @Override
    public boolean isValid(Object IdNumber, ConstraintValidatorContext constraintValidatorContext) {
        String message=constraintValidatorContext.getDefaultConstraintMessageTemplate();
        if(IdNumber==null||IdNumber.toString().equals("")){
            constraintValidatorContext.disableDefaultConstraintViolation();//禁用默认的message的值
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(message+"不能为空").addConstraintViolation();
            return false;
        }
        if(IdNumber.toString().length()>valueLength){
            constraintValidatorContext.disableDefaultConstraintViolation();//禁用默认的message的值
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(message+"长度不能超过"+valueLength+"位").addConstraintViolation();
            return false;
        }
        return true;
    }


    @Override
    public void initialize(IsFormat constraintAnnotation) {
        valueLength=constraintAnnotation.length();
    }


}
