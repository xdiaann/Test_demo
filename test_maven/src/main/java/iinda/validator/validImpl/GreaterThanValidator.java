package iinda.validator.validImpl;


import iinda.validator.validAnnotations.GreaterThan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-15 16:53
 */
public class GreaterThanValidator implements ConstraintValidator<GreaterThan, Number> {

    private GreaterThan greaterThan;

    @Override
    public void initialize(GreaterThan greaterThan) {
        this.greaterThan=greaterThan;
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if (value == null ) {
            return true;
        }
        return value.doubleValue() > greaterThan.value();
    }
}
