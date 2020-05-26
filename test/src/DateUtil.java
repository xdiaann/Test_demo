import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SMALL_YMDHM = "yyyy-MM-dd HH:mm";
    public static final String DATE_SMALL_YMDH = "yyyy-MM-dd HH:00";
    public static final String DATE_SMALL_YMDHH = "yyyy-MM-dd HH";
    public static final String DATE_SMALL_YMDHMS = "yyyy-MM-dd HH:00:00";
    public static final String DATE_SMALL_STR = "yyyy-MM-dd";
    public static final String DATE_SMALL_YM = "yyyy-MM";
    public static final String DATE_ALL_STR = "yyyyMMddHHmmss";

    public static void main(String[] args) {
//        List<String> dateList = getDayList("2020-03-04", "2020-04-03", "yyyy-MM-dd");
//        for (String s : dateList) {
//            System.out.println(s);
//        }
//        System.out.println("===========");
//        String yyyyMM = getLastDayM(new Date(), "yyyyMMdd");
//        System.out.println(yyyyMM);
        System.out.println(addDate("202001", 2, "yyyyMM"));
    }


    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDate(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }

    /**
     * 日期格式转换
     *
     * @return
     */
    public static String patternConvert(String date, String oldPattern, String newPattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(oldPattern);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(newPattern);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(date);
        } catch (ParseException e) {
//            throw new BusinessException("日期格式有误");
        }
        return simpleDateFormat1.format(parse);
    }

    /**
     * 日期格式转换
     *
     * @return
     */
    public static StringBuilder patternConvertWithSb(StringBuilder date, String oldPattern, String newPattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(oldPattern);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(newPattern);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String format = simpleDateFormat1.format(parse);
        return new StringBuilder(format);
    }

    /**
     * 当月最后一天
     *
     * @return
     */
    public static String getLastDayM(Date d, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
        Date theDate = calendar.getTime();
        return df.format(theDate);
    }

    /**
     * 当月最后一天(含小时),适用于年月
     *
     * @return
     */
    public static Date getLastDayMonthM(Date d, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
        Date theDate = calendar.getTime();
        return theDate;
    }

    /**
     * 当月最后一天(含小时),适用于年月日
     *
     * @return
     */
    public static Date getLastDayDayM(Date d, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        Date theDate = calendar.getTime();
        return theDate;
    }

    /**
     * 小时加减
     */
    public static String addHour(Date d, int n, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.HOUR, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    public static String addHour(String d, int n, String pattern) {
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sd.parse(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.HOUR, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    /**
     * 日期加减
     */
    public static String addDate(Date d, int n, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    public static String addDate(String d, int n, String pattern) {
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sd.parse(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DATE, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    /**
     * 月份加减
     */
    public static String addMonth(Date d, int n, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    public static String addMonth(String d, int n, String pattern) {
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sd.parse(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.MONTH, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    /**
     * 年份加减
     */
    public static String addYear(Date d, int n, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.YEAR, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    public static String addYear(String d, int n, String pattern) {
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sd.parse(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    /**
     * 分钟加减
     */
    public static String addMin(Date d, int n, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MINUTE, n);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    /**
     * 分钟加减
     */
    public static Date addYear(Date d, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.YEAR, n);
        Date datNew = cal.getTime();
        return datNew;
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }


    /**
     * 日期转换成字符串 年 月 日
     *
     * @param date
     * @return
     */
    public static String dateToStringYY(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_SMALL_STR);
        String d = format.format(date);
        d = d.substring(0, 4) + "年" + d.substring(5, 7) + "月" + d.substring(8) + "日";
        return d;
    }

    /**
     * 字符串转换日期
     *
     * @param str
     * @return
     */
    public static Date stringToDate(String str, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        if (!str.equalsIgnoreCase("") && str != null) {
            try {
                return format.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 查询当月天 列表 不包含今天
     *
     * @return ["03-01","03-02"....]
     */
    public static List<String> dangyueDayStringList() {
        List<String> list = new ArrayList<String>();
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        int count = ca.get(Calendar.DAY_OF_MONTH);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMinimum(Calendar.DAY_OF_MONTH));

        SimpleDateFormat si = new SimpleDateFormat("MM-dd");
        String time = "";
        int temp = 1;
        while (temp < count) {
            time = si.format(ca.getTime());
            list.add(time);
            ca.add(Calendar.DAY_OF_MONTH, 1);

            temp++;
        }
        return list;
    }

    /**
     * 日期第一天  20
     *
     * @param date
     * @return 2017-03-01
     */
    public static String dangyueDiyitian(Date date, String pattern) {
        SimpleDateFormat si = new SimpleDateFormat(pattern);
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONDAY), ca.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
        return si.format(ca.getTime());
    }

    /**
     * 日期第一天(含小时),只适用于年月
     *
     * @param date
     * @return 2017-03-01
     */
    public static Date dangyueDiyitianMonth(Date date, String pattern) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONDAY), ca.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
        return ca.getTime();
    }

    /**
     * 日期第一天(含小时),只适用于年月日
     *
     * @param date
     * @return 2017-03-01
     */
    public static Date dangyueDiyitianDay(Date date, String pattern) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONDAY), ca.get(Calendar.DAY_OF_MONTH), 00, 00, 00);
        return ca.getTime();
    }

    /**
     * *
     *
     * @param
     */
    public static Date addDate2(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        Date datNew = cal.getTime();
        return datNew;
    }

    @Test
    public void testgetLastDay() {
        List<String> lastDay = getLastDay(2019, 1);
        System.out.println(lastDay);
    }

    //获取某年某月第一天和最后一天
    public static List<String> getLastDay(int year, int month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取Calendar类的实例
        Calendar c = Calendar.getInstance();
        //设置年份
        c.set(Calendar.YEAR, year);
        //设置月份，因为月份从0开始，所以用month - 1
        c.set(Calendar.MONTH, month - 1);
        //获取当前时间下，该月的最大日期的数字
        int actualMinimum = c.getActualMinimum(Calendar.DAY_OF_MONTH);
        int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        //将获取的最大日期数设置为Calendar实例的日期数
        List<String> list = new ArrayList<>();
        c.set(Calendar.DAY_OF_MONTH, actualMinimum);
        list.add(sdf.format(c.getTime()));
        c.set(Calendar.DAY_OF_MONTH, lastDay);
        list.add(sdf.format(c.getTime()));


        return list;
    }

    /**
     * 获取年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取年份2
     *
     * @param date
     * @return
     */
    public static int getYear(String date) {
        Date d = stringToDate(date, DATE_ALL_STR);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取天数
     *
     * @param date
     * @return
     */
    public static int getDAY_OF_YEAR(String date, String pattern) {
        Date d = stringToDate(date, pattern);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    /**
     * 获取月份
     *
     * @param date
     * @return
     */
    public static int getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * 获取一年起始时间
     *
     * @param date
     * @return
     */
    public static Date getFirstDay_Year(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, firstDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static String getFirstDay_Year(Date date, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, firstDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    /**
     * 获取一年结束时间
     *
     * @param date
     * @return
     */
    public static Date getFinalyDay_Year(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int finalDat = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, finalDat);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }


    @Test
    public void testgetFinalyDay_Year() {
        String yyyyMMdd = getFinalyDay_Year(new Date(), "yyyyMMdd");
        System.out.println(yyyyMMdd);
    }

    public static String getFinalyDay_Year(Date date, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int finalDat = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, finalDat);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date datNew = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(datNew);
    }

    public static String getFirstDay_Month(String date, String pattern, String pattern2) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat(pattern).parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int firstDat = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDat);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        return new SimpleDateFormat(pattern2).format(cal.getTime());
    }

    @Test
    public void testgetFinalyDay_Month() {
        String yyyyMMdd = getFinalyDay_Month("20190401", "yyyyMMdd", "yyyyMMdd");
        System.out.println(yyyyMMdd);
    }

    //获取一月的最后一天
    public static String getFinalyDay_Month(String date, String pattern, String pattern2) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat(pattern).parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int finalDat = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, finalDat);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return new SimpleDateFormat(pattern2).format(cal.getTime());
    }

    public static int nDaysBetweenTwoDate(String firstString, String secondString, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date firstDate = null;
        Date secondDate = null;
        try {
            firstDate = df.parse(firstString);
            secondDate = df.parse(secondString);
        } catch (Exception e) {
            // 日期型字符串格式错误
//            throw new BusinessException("日期型字符串格式错误");
        }
        int nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
        return nDay;
    }


    public static List<String> getDateList(String beginDate, String endDate, String type) {
        if (beginDate.length() >= 8 && !"小时".equals(type) && !beginDate.contains("-")) {
            beginDate = strToDateFormat(beginDate);//将20201020转为2020-10-20
            endDate = strToDateFormat(endDate);
        }

        if ("日".equalsIgnoreCase(type)) {
            return getDayList(beginDate, endDate, "yyyy-MM-dd");
        } else if ("月".equalsIgnoreCase(type)) {
            return getMonthBetween(beginDate, endDate);
        } else if ("年".equalsIgnoreCase(type)) {
            return getYearList(beginDate, endDate);
        } else if ("小时".equalsIgnoreCase(type)) { //该逻辑是生成一天的24小时
            return getHourList(beginDate, endDate);
        } else {
//            throw new BusinessException("暂不支持的日期格式");
            return null;
        }

    }

//    public static boolean timeCompare(String time, String setTime) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date zhiding;
//        Date panduan;
//        try {
//            zhiding = format.parse(time);
//            panduan = format.parse(setTime);
//        } catch (ParseException e) {
////            throw new BusinessException("时间格式有误 应为yyyy-MM-dd HH:mm:ss");
//        }
//        return zhiding.before(panduan);
//    }

    private static List<String> getHourList(String beginDate, String endDate) {
        //2020030400
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH");
        Date parse = null;
        Date parse1 = null;
        try {
            parse = sdf.parse(beginDate);
            parse1 = sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        beginDate = sdf1.format(parse);
        endDate = sdf1.format(parse1);
        String stHH = beginDate.substring(11, 13);//02
        List<String> list = new ArrayList<>();
        int stx = 24 - Integer.parseInt(stHH);//22
        String styyyyMMdd = beginDate.substring(0, 10);
        int stIntHH = Integer.parseInt(stHH);
        for (int i = 0; i < stx; i++) {
            if (stIntHH < 10) {
                list.add(styyyyMMdd + " 0" + stIntHH + ":00:00");
            } else {
                list.add(styyyyMMdd + " " + stIntHH + ":00:00");
            }
            stIntHH++;
        }
        String enHH = endDate.substring(11, 13);//23
        int enx = Integer.parseInt(enHH);//2
        String enyyyyMMdd = endDate.substring(0, 10);
        int enIntHH = Integer.parseInt(enHH);//23


        List<String> dateList = getDayList(beginDate, endDate, "yyyy-MM-dd");
        for (String s : dateList) {
            if (s.equalsIgnoreCase(styyyyMMdd)) {
                continue;
            }
            if (s.equalsIgnoreCase(enyyyyMMdd)) {
                continue;
            }
            for (int i = 0; i < 24; i++) {
                if (i < 10) {
                    list.add(s + " 0" + i + ":00:00");
                } else {
                    list.add(s + " " + i + ":00:00");
                }
            }
        }
        if (styyyyMMdd.equalsIgnoreCase(enyyyyMMdd)) {
            return list;
        }

        for (int i = 0; i < enIntHH + 1; i++) {
            if (i < 10) {
                list.add(enyyyyMMdd + " 0" + i + ":00:00");
            } else {
                list.add(enyyyyMMdd + " " + i + ":00:00");
            }

        }
        return list;
    }


    private static List<String> getYearList(String beginDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(beginDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        long time = 0;
        try {
            time = sdf.parse(endDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (long d = cal.getTimeInMillis(); d <= time; d = get_Y_Plaus_1(cal)) {
            String format = sdf.format(d);
            list.add(format);
        }
        return list;
    }

    public static long get_Y_Plaus_1(Calendar c) {
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
        return c.getTimeInMillis();
    }

    public static List<String> getDayList(String beginDate, String endDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(beginDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        long time = 0;
        try {
            time = sdf.parse(endDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (long d = cal.getTimeInMillis(); d <= time; d = get_D_Plaus_1(cal)) {
            String format = sdf.format(d);
            list.add(format);
        }
        return list;
    }

    private static List<String> getMonthBetween(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<>();
        if (minDate.length() == 6) {
            minDate = new StringBuffer(minDate).insert(4, "-").toString();
        }
        if (maxDate.length() == 6) {
            maxDate = new StringBuffer(maxDate).insert(4, "-").toString();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        try {
            min.setTime(sdf.parse(minDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        try {
            max.setTime(sdf.parse(maxDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    public static long get_D_Plaus_1(Calendar c) {
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
        return c.getTimeInMillis();
    }

    public static String strToDateFormat(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate = null;
        try {
            if (date.length() > 8) {
                date = date.substring(0, 8);
            }
            newDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(newDate);
    }

    /**
     * @param
     * @return String
     * @throws
     * @Description: 获取上个月环比日期
     * @author
     * @createtime
     */
    public static String getHbDate(String currentDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        String monthFormat;
        try {
            date = sdf.parse(currentDate + "-" + "01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        int month = c.get(Calendar.MONTH) + 1;
        if (month <= 9) {
            monthFormat = "0" + month;
        } else {
            monthFormat = String.valueOf(month);
        }
        String hbDate = c.get(Calendar.YEAR) + "-"
                + monthFormat + "-01";
        return hbDate;
    }

    /**
     * @param
     * @return String
     * @throws
     * @Description: 获取去年同比日期
     * @author
     * @createtime
     */
    public static String getTbDate(String currentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        String monthFormat;
        try {
            date = sdf.parse(currentDate + "-" + "01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, -1);
        int month = c.get(Calendar.MONTH) + 1;
        if (month <= 9) {
            monthFormat = "0" + month;
        } else {
            monthFormat = String.valueOf(month);
        }
        String tbDate = c.get(Calendar.YEAR) + "-"
                + monthFormat + "-01";
        return tbDate;
    }
}
