package iinda.validator.validAnnotations;


import iinda.validator.validImpl.IdNoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdNoValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdNo {
    String message() default "身份证格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
