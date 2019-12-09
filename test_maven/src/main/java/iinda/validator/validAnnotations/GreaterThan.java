package iinda.validator.validAnnotations;


import iinda.validator.validImpl.GreaterThanValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GreaterThanValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GreaterThan {
    String message() default "int数据不能小于{value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    long value();

}
