package iinda.pojo;


import iinda.utils.RegexType;
import iinda.utils.RegexUtils;
import iinda.utils.Validate;

import javax.xml.bind.ValidationException;
import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public String validate() {
        try {
            valid(this);
        } catch (ValidationException e) {
            return e.getMessage();
        }
        return null;
    }


    public static void valid(Object object) throws ValidationException {
        // 获取object的类型
        Class<? extends Object> clazz = object.getClass();
        // 获取该类型声明的成员
        Field[] fields = clazz.getDeclaredFields();
        // 遍历属性
        for (Field field : fields) {
            // 对于private私有化的成员变量，通过setAccessible来修改器访问权限
            field.setAccessible(true);
            validate(field, object);
            // 重新设置会私有权限
            field.setAccessible(false);
        }
    }

    public static void validate(Field field, Object object) throws ValidationException {
        String description;
        Object value = null;
        // 获取对象的成员的注解信息
        Validate dv = field.getAnnotation(Validate.class);
        try {
            value = field.get(object);
        } catch (Exception e) {
            throw new ValidationException("解析错误");
        }
        if (dv == null)
            return;
        description = dv.description().equals("") ? field.getName() : dv
                .description();
        /************* 注解解析工作开始 ******************/
        if (!dv.nullable()) {
            if (value == null || "".equals(value.toString())) {
                throw new ValidationException(description + "不能为空");
            }
        }
        if (value != null) {
            if (value.toString().length() > dv.maxLength() && dv.maxLength() != 0) {
                throw new ValidationException(description + "长度不能超过" + dv.maxLength());
            }
            if (value.toString().length() < dv.minLength() && dv.minLength() != 0) {
                throw new ValidationException(description + "长度不能小于" + dv.minLength());
            }
            if (dv.regexType() != RegexType.NONE) {
                switch (dv.regexType()) {
                    case NONE:
                        break;
                    case SPECIALCHAR:
                        if (RegexUtils.hasSpecialChar(value.toString())) {
                            throw new ValidationException(description + "不能含有特殊字符");
                        }
                        break;
                    case CHINESE:
                        if (RegexUtils.isChinese2(value.toString())) {
                            throw new ValidationException(description + "不能含有中文字符");
                        }
                        break;
                    case EMAIL:
                        if (!RegexUtils.isEmail(value.toString())) {
                            throw new ValidationException(description + "地址格式不正确");
                        }
                        break;
                    case IP:
                        if (!RegexUtils.isIp(value.toString())) {
                            throw new ValidationException(description + "地址格式不正确");
                        }
                        break;
                    case NUMBER:
                        if (!RegexUtils.isNumber(value.toString())) {
                            throw new ValidationException(description + "不是数字");
                        }
                        break;
                    case PHONENUMBER:
                        if (!RegexUtils.isPhoneNumber(value.toString())) {
                            throw new ValidationException(description + "不是数字");
                        }
                        break;
                    default:
                        break;
                }
            }
            if (!dv.regexExpression().equals("")) {
                if (value.toString().matches(dv.regexExpression())) {
                    throw new ValidationException(description + "格式不正确");
                }
            }
        }

        /************* 注解解析工作结束 ******************/
    }


    @Override
    public String toString() {
        Class<?> c = this.getClass();
        StringBuilder sbuilder = new StringBuilder();
        Field[] fields = c.getDeclaredFields();
        sbuilder.append(c.getName() + "[");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            fields[i].getName();
            try {
                if (i == fields.length - 1) {
                    sbuilder.append(fields[i].getName() + ":" + fields[i].get(this).toString());
                } else {
                    sbuilder.append(fields[i].getName() + ":" + fields[i].get(this).toString() + ",");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sbuilder.append("]");
        return sbuilder.toString();
    }
}