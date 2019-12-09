package iinda.validator.validAnnotations;


import iinda.validator.enums.DateFormat;
import iinda.validator.validImpl.DateTimeFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeFormatValidator.class)
public @interface DateTimeFormat {

    String message() default "日期格式错误，正确格式为{DATE_FORMAT}";

    DateFormat DATE_FORMAT() ;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


