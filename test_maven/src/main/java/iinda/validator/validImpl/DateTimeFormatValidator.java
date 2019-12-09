package iinda.validator.validImpl;

import iinda.validator.enums.DateFormat;
import iinda.validator.validAnnotations.DateTimeFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-15 21:46
 */
public class DateTimeFormatValidator implements ConstraintValidator<DateTimeFormat,String> {
    private DateTimeFormat dateTimeFormat;

    @Override
    public void initialize(DateTimeFormat dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null ||value.length()==0) {
            return true;
        }
        DateFormat dateFormat = dateTimeFormat.DATE_FORMAT();

        if (value.length() != dateFormat.getFormat().length()) {
            return false;
        }
        String reg = dateFormat.getReg();
        boolean valid = value.matches(reg);
        if (valid) {
            SimpleDateFormat dateFormat1 = new SimpleDateFormat(dateFormat.getFormat());
            dateFormat1.setLenient(false);
            try {
                dateFormat1.parse(value);
            } catch (ParseException e) {
               return false;
            }
            return true;
        }
        return false;
    }
}
