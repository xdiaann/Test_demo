package iinda.validator.validImpl;


import iinda.validator.validAnnotations.DecimalLessThan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-16 01:40
 */
public class DecimalLessThanValidator implements ConstraintValidator<DecimalLessThan, BigDecimal> {
    private DecimalLessThan decimalLessThan;

    @Override
    public void initialize(DecimalLessThan decimalLessThan) {
        this.decimalLessThan =decimalLessThan;
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if (value == null ) {
            return true;
        }
        return value.compareTo(new BigDecimal(decimalLessThan.value())) < 0;

    }
}