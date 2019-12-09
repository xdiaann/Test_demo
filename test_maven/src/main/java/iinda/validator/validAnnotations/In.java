package iinda.validator.validAnnotations;


import iinda.validator.validImpl.InValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface In {

    String message() default "数据必须为[{value}]中的一个或多个";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}