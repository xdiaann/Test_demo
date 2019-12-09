package iinda.validator.validImpl;


import iinda.validator.validAnnotations.DecimalGreaterThan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-15 16:53
 */
public class DecimalGreaterThanValidator implements ConstraintValidator<DecimalGreaterThan, BigDecimal> {

    private DecimalGreaterThan decimalGreaterThan;

    @Override
    public void initialize(DecimalGreaterThan decimalGreaterThan) {
        this.decimalGreaterThan=decimalGreaterThan;
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if (value == null ) {
            return true;
        }
        return value.compareTo(new BigDecimal(decimalGreaterThan.value())) > 0;

    }
}
