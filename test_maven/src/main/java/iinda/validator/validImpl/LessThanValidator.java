package iinda.validator.validImpl;


import iinda.validator.validAnnotations.LessThan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-15 16:53
 */
public class LessThanValidator implements ConstraintValidator<LessThan, Number> {

    private LessThan lessThan;

    @Override
    public void initialize(LessThan lessThan) {
        this.lessThan = lessThan;
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.doubleValue() < lessThan.value();
    }
}
