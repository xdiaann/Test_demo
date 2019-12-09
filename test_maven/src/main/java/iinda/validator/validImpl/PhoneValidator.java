package iinda.validator.validImpl;


import iinda.validator.validAnnotations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author fugq
 */
public class PhoneValidator implements ConstraintValidator<Phone, Long> {

    private static final String REGEX_MOBILE_EXACT = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147)|(19[0-9]))\\d{8}$";

    @Override
    public void initialize(Phone paramA) {
    }

    @Override
    public boolean isValid(Long phone, ConstraintValidatorContext ctx) {
        if (phone == null) {
            return true;
        }
        String phoneStr = String.valueOf(phone);
        return phoneStr.matches(REGEX_MOBILE_EXACT);
    }
}
