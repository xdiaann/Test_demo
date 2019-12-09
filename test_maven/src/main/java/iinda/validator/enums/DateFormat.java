package iinda.validator.enums;

import lombok.Getter;

@Getter
public enum DateFormat {
    //时间格式
    YYYY("yyyy", "\\d{4}"),
    YYYYMM("yyyyMM", "\\d{6}"),
    YYYYMMDD("yyyyMMdd", "\\d{8}"),
    YYYY_MM_DD("yyyy-MM-dd", "\\d{4}-\\d{2}-\\d{2}"),
    YYYY_MM("yyyy-MM", "\\d{4}-\\d{2}"),
    YYYYMMDDHHMMSS("yyyyMMddHHmmss", "\\d{14}"),
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss", "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"),
    HH_MM_SS("HH:mm:ss", "\\d{2}:\\d{2}:\\d{2}");

    private String format;
    private String reg;

    DateFormat(String format, String reg) {
        this.format = format;
        this.reg = reg;
    }
}
