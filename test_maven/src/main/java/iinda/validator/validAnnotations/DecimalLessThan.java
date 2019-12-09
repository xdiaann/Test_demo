package iinda.validator.validAnnotations;


import iinda.validator.validImpl.DecimalLessThanValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = DecimalLessThanValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DecimalLessThan {
    String message() default "Decimal数据不能大于{value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    double value() ;
}
