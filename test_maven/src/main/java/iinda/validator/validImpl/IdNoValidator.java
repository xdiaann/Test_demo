package iinda.validator.validImpl;


import iinda.validator.validAnnotations.IdNo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author fugq
 */
public class IdNoValidator implements ConstraintValidator<IdNo, String> {

    private static final String REGEX_ID_CARD_EXACT = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    @Override
    public void initialize(IdNo idNo) {
    }

    @Override
    public boolean isValid(String idNo, ConstraintValidatorContext ctx) {
        if (idNo == null || idNo.length() == 0) {
            return true;
        }
        boolean matches = idNo.matches(REGEX_ID_CARD_EXACT);
        //判断第18位校验值
        if (matches) {
            if (idNo.length() == 18) {
                try {
                    char[] charArray = idNo.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        System.err.println("身份证格式错误，校验位错误，idNo=idNo");
                        return false;
                    }
                } catch (Exception e) {
                    System.err.println("身份证格式错误，idNo= idNo");
                    return false;
                }
            }
        }
        return matches;
    }
}
