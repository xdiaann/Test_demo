package iinda.validator.validAnnotations;


import iinda.validator.validImpl.LessThanValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LessThanValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LessThan {
    String message() default "int数据不能大于{value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    long value();
}
