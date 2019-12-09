package iinda.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsFormatValidator.class) //具体的实现
@Target( { java.lang.annotation.ElementType.METHOD,
        java.lang.annotation.ElementType.FIELD })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface IsFormat {
    String message() default "{org.hibernate.validator.constraints.NotEmpty.message}";

    int length()  ;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}