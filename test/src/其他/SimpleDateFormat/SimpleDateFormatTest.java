package 其他.SimpleDateFormat;

import lombok.SneakyThrows;
import org.junit.Test;
import sun.util.resources.LocaleData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleDateFormatTest {
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date) {
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @SneakyThrows
    public static void main(String[] args) throws ParseException {
/*        System.out.println(sdf.format(new Date()));
        String s = formatDate(new Date());
        System.out.println(s);
        Date parse = parse(s);
        System.out.println(parse);*/
//
//        List<String> lastDay = getLastDay(2019, 2);
//        System.out.println(lastDay);


//        Date parse = sdf.parse("2020030400");
//        String format = sdf1.format(parse);
//        System.out.println(format);

        //频率为周  reminderDay会传入周几  判断如果时间小于当前9分钟 则放入下周 否则 计算时间
        //1 先算出周的时间日期
        //2 得到当前的日期
        //3 用当前的日期-周的日期  如果时间小于9分钟 则 用周的时间加一周 (7天)
        Calendar end = Calendar.getInstance();
        String reminderDay = "4";
//        extracted(end, reminderDay);
        end.set(Calendar.DAY_OF_WEEK, Integer.parseInt(reminderDay) + 1);
        //时分秒
        Date reminderTime = sdf1.parse("2023-07-13 19:22:00");
        Calendar reminderTimeC = Calendar.getInstance();
        reminderTimeC.setTime(reminderTime);
        int hours = reminderTimeC.get(Calendar.HOUR_OF_DAY);
        int minutes = reminderTimeC.get(Calendar.MINUTE);
        int seconds = reminderTimeC.get(Calendar.SECOND);
        Calendar nextRemindTime = Calendar.getInstance();
        nextRemindTime.setTime(end.getTime());
        nextRemindTime.set(Calendar.HOUR_OF_DAY, hours);
        nextRemindTime.set(Calendar.MINUTE, minutes);
        nextRemindTime.set(Calendar.SECOND, seconds);
        Calendar now = Calendar.getInstance();
        int minute = (int) ((nextRemindTime.getTime().getTime() - now.getTime().getTime()) / (60 * 1000));
        if (minute < 9) {
            nextRemindTime.add(Calendar.WEEK_OF_MONTH, 1);
        }
        System.out.println(nextRemindTime.getTime());
        nextRemindTime.add(Calendar.WEEK_OF_YEAR, 3);
        System.out.println(nextRemindTime.getTime());
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 9);
        Calendar nowTime1 = Calendar.getInstance();
        nowTime1.add(Calendar.MINUTE, 9);
        if (nowTime1.before(nowTime.getTime())) {
            throw new RuntimeException("设置时间必须大于当前时间9分钟");
        }
        System.out.println("成功");
        LocalDateTime localDateTime = calcNextRemindTime(0, "1900-01-01", LocalTime.now());
        System.out.println(localDateTime);
    }


    public static LocalDateTime calcNextRemindTime(Integer remindFrequency, String remindDay, LocalTime remindTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime remindDateTime = null;

        switch (remindFrequency) {
            case 0: // 一次性提醒
                LocalDate remindDate = LocalDate.parse(remindDay);
                remindDateTime = LocalDateTime.of(remindDate, remindTime);

                if (currentDateTime.isAfter(remindDateTime)) {
                    return null; // 如果提醒时间已经过去，则返回null
                }
                break;

            case 1: // 每天提醒
                remindDateTime = LocalDateTime.of(currentDateTime.toLocalDate(), remindTime);

                if (currentDateTime.isAfter(remindDateTime)) {
                    remindDateTime = remindDateTime.plusDays(1);
                }
                break;

            case 2: // 每周提醒
                int dayOfWeekValue = Integer.parseInt(remindDay);
                DayOfWeek dayOfWeek = DayOfWeek.of(dayOfWeekValue);
                LocalDate nextOccurrence = currentDateTime.toLocalDate().with(TemporalAdjusters.nextOrSame(dayOfWeek));
                remindDateTime = LocalDateTime.of(nextOccurrence, remindTime);

                if (currentDateTime.isAfter(remindDateTime)) {
                    remindDateTime = remindDateTime.plusWeeks(1);
                }
                break;

            case 3: // 每月提醒
                int dayOfMonth = Integer.parseInt(remindDay);
                LocalDate currentMonth = currentDateTime.toLocalDate().withDayOfMonth(1);
                LocalDate nextOccurrenceOfMonth = currentMonth.withDayOfMonth(dayOfMonth);
                remindDateTime = LocalDateTime.of(nextOccurrenceOfMonth, remindTime);

                if (currentDateTime.isAfter(remindDateTime)) {
                    remindDateTime = remindDateTime.plusMonths(1);
                }
                break;

            default:
                return null;
        }

        return remindDateTime;
    }

    @SneakyThrows
    @Test
    public void test03() {
        int reminderDay = 7; // 假设reminderDay为7，表示星期日

        LocalDate currentDate = LocalDate.now();
        LocalDate nextReminderDate = currentDate.with(DayOfWeek.of(reminderDay));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = nextReminderDate.format(dateFormatter);
        System.out.println(formattedDate);
    }

    @SneakyThrows
    @Test
    public void test01() {
        Calendar end = Calendar.getInstance();
        String reminderDay = "7";
//        end.setFirstDayOfWeek(Calendar.MONDAY);
//        extracted(end, reminderDay);
        end.set(Calendar.DAY_OF_WEEK, Integer.parseInt(reminderDay) +1);
        System.out.println(end.getTime());
        String s1 = String.format("%tY年%<tm月%<td日",end);
        System.out.println(s1);
//        end.set(Calendar.MONTH,8);
        // 获取当前月份的最大日期
        int maxDayOfMonth = end.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 如果提醒日期大于最大日期，则将其设置为最大日期
        if (Integer.parseInt(reminderDay) > maxDayOfMonth) {
            reminderDay = String.valueOf(maxDayOfMonth);
        }
        end.set(Calendar.DAY_OF_MONTH, Integer.parseInt(reminderDay)  );
        //时分秒
        Date reminderTime = sdf1.parse("2023-07-13 19:22:00");

        Calendar calendar = Calendar.getInstance();




        Calendar reminderTimeC = Calendar.getInstance();
        reminderTimeC.setTime(reminderTime);
        int hours = reminderTimeC.get(Calendar.HOUR_OF_DAY);
        int minutes = reminderTimeC.get(Calendar.MINUTE);
        int seconds = reminderTimeC.get(Calendar.SECOND);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(end.toInstant(), ZoneOffset.systemDefault());
        LocalDateTime of = LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime());
        System.out.println(of);
        LocalDateTime localDateTime1 = of.plusWeeks(1);
        long seconds1 = Math.abs(of.until(localDateTime, ChronoUnit.SECONDS));
        System.out.println(seconds1);
        Calendar nextRemindTime = Calendar.getInstance();
        nextRemindTime.setTime(end.getTime());
        nextRemindTime.set(Calendar.HOUR_OF_DAY, hours);
        nextRemindTime.set(Calendar.MINUTE, minutes);
        nextRemindTime.set(Calendar.SECOND, seconds);
        Calendar now = Calendar.getInstance();
        int minute = (int) ((nextRemindTime.getTime().getTime() - now.getTime().getTime()) / (60 * 1000));
        System.out.println(minute);
    }
    @SneakyThrows
    @Test
    public void test02() {
        LocalDateTime endTime = LocalDateTime.parse("2023-07-13 23:38:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime beginTime = LocalDateTime.now();

        long seconds = Math.abs(endTime.until(beginTime, ChronoUnit.HOURS));
        System.out.println(seconds);
    }

    public static boolean compTime(String s1, String s2) {
        try {
            if (!s1.contains(":") || !s2.contains(":")) {
                System.out.println("格式不正确");
            } else {
                String[] array1 = s1.split(":");
                int total1 = Integer.valueOf(array1[0]) * 3600 + Integer.valueOf(array1[1]) * 60 + Integer.valueOf(array1[2]);
                String[] array2 = s2.split(":");
                int total2 = Integer.valueOf(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60 + Integer.valueOf(array2[2]);
                return total1 - total2 > 0 ? true : false;
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            return true;
        }
        return false;

    }

    public static List<String> getLastDay(int year, int month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取Calendar类的实例
        Calendar c = Calendar.getInstance();
        //设置年份
        c.set(Calendar.YEAR, year);
        //设置月份，因为月份从0开始，所以用month - 1
        c.set(Calendar.MONTH, month - 1);
        //获取当前时间下，该月的最大日期的数字
        int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int actualMinimum = c.getActualMinimum(Calendar.DAY_OF_MONTH);
        //将获取的最大日期数设置为Calendar实例的日期数
        List<String> list = new ArrayList<>();
        c.set(Calendar.DAY_OF_MONTH, actualMinimum);
        System.out.println(sdf.format(c.getTime()));
        list.add(sdf.format(c.getTime()));
        c.set(Calendar.DAY_OF_MONTH, lastDay);
        System.out.println(sdf.format(c.getTime()));
        list.add(sdf.format(c.getTime()));


        return list;
    }


    @Test
    public void test() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            service.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(parse("2018-01-02 09:45:59"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 等待上述的线程执行完
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }
}
