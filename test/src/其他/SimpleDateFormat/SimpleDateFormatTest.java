package 其他.SimpleDateFormat;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleDateFormatTest {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date) {
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }

    public static void main(String[] args) throws ParseException {
/*        System.out.println(sdf.format(new Date()));
        String s = formatDate(new Date());
        System.out.println(s);
        Date parse = parse(s);
        System.out.println(parse);*/
//
//        List<String> lastDay = getLastDay(2019, 2);
//        System.out.println(lastDay);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH");
        Date parse = sdf.parse("2020030400");
        String format = sdf1.format(parse);
        System.out.println(format);
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
