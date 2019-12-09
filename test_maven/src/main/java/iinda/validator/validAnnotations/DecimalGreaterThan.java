package iinda.validator.validAnnotations;


import iinda.validator.validImpl.DecimalGreaterThanValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DecimalGreaterThanValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DecimalGreaterThan {
    String message() default "Decimal数据不能小于{value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    double value() ;
}
