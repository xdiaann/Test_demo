package iinda.validator.validImpl;


import iinda.validator.validAnnotations.In;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-16 01:48
 */
public class InValidator implements ConstraintValidator<In, Object[]> {

    private In in;

    @Override
    public void initialize(In in) {
        this.in = in;
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        for (Object o : value) {
            if (!in.value().contains(o.toString())) {
              return false;
            }
        }
        return true;
    }
}
