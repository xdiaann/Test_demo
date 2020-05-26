import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author MR.Z
 * @date 2020/3/23 15:52
 */
public class TimeRule {


    public static void main(String[] args) throws Exception {
//        String beginDate = "2016-07-16";//开始时间
//        String endDate = "2016-08-25";//结束时间
//
//        getDateList(beginDate, endDate);
//        String dateString = "20191010";
//        SimpleDateFormat format  = new SimpleDateFormat();
//        SimpleDateFormat formatter2  = new SimpleDateFormat("yyyyMMdd");
//        //2、调用formatter2.parse(),将"19570323"转化为date类型  输出为：Sat Mar 23 00:00:00 GMT+08:00 1957

//        String stat_time = "20191111";//格式为 20190305 需转换
//        String s = stat_time.substring(0, 4) + "-" + stat_time.substring(4, 2) + "-" + stat_time.substring(6, 2);
//        System.out.println(s);

//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//
//        System.out.println(list.toString());
//        getDateList("2019", "2033");
//        List<String> monthBetween = getMonthBetween("2019-1", "2019-11");
////        List<String> yearBetween = getYearBetween("2019", "2021");
//        System.out.println(monthBetween);
        //2019112800
        //2019112823
        //20191128 00:00:00
       /* String a = "2019021300";
        String b = "20191128 00:00:00";
        System.out.println(b.length());
        System.out.println(a.length());
        if (b.length() > 10) {
            System.out.println(b.replace(" ","").substring(0, 10));
            System.out.println(b);
        }*/
//        2020-03-25
       /* StringBuilder a = new StringBuilder("20200325 02:00:00");
        System.out.println(a.insert(4, "-").insert(7,"-"));
*/
//        List<String> list = new ArrayList<>();
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        for (String s : list) {
//            if (s != null) {
//                System.out.println(s);
//            }
//        }
//        System.out.println(list.isEmpty());

       /* String a = "2019-11-28 00:00:00";
        String b = "2019112800";
        String replace = a.replace("-", "").replace(":", "").replace(" ", "").substring(0, 10);
        System.out.println(replace);*/

//        System.out.println(a.length());
//        System.out.println(a.substring(0, 10));
        //        String substring = a.substring(0, a.length() - 2);
//        System.out.println(substring);
//        List list = new ArrayList();
//        for (int i = 0; i < 24; i++) {
//            if (i < 10) {
//                list.add(a +" 0"+ i+":00:00");
//            } else {
//                list.add(a +" "+ i+":00:00");
//            }
//
//        }
//        for (Object o : list) {
//            System.out.println(o);
//        }
//        System.out.println(strToDateFormat("19221222"));

//        int i = nDaysBetweenTwoDate("20191129", "20191230");
//        System.out.println(i);

//        List<String> factorList = Arrays.asList("w01009", "w21003", "w21011", "w21001", "w01019");
//        System.out.println(factorList.contains("w01009"));

        int[] array = {2, 1, 2, 3, 4, 5, 2, 2, 2, 2};

        // map的key存放数组中存在的数字，value存放该数字在数组中出现的次数
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int temp = map.get(array[i]);

                map.put(array[i], temp + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        System.out.println(map);

        Collection<Integer> count = map.values();
        // 找出map的value中最大的数字，也就是数组中数字出现最多的次数
        int maxCount = Collections.max(count);

        int maxNumber = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 得到value为maxCount的key，也就是数组中出现次数最多的数字
            if (maxCount == entry.getValue()) {
                maxNumber = entry.getKey();
            }
        }

        System.out.println("出现次数最多的数字为：" + maxNumber);
        System.out.println("该数字一共出现" + maxCount + "次");
      /*  Map<String,String> map=new HashMap<>();
        String value = null;
        String key="";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(value.equals(entry.getValue())){
                key=entry.getKey();
            }
        }*/

//        System.out.println(timeCompare("2019-11-02 00:00:00", "2019-12-01 00:00:00"));
        //2020-03-04 02
        //2020-03-05 14



    }

    private static List<String> getDayList(String beginDate, String endDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(beginDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList();
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

    public static boolean timeCompare(String time, String setTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date zhiding = null;
        Date panduan = null;
        try {
            zhiding = format.parse(time);
            panduan = format.parse(setTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return zhiding.before(panduan);
    }

    public static String strToDateFormat(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate = formatter.parse(date);
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(newDate);
    }

    // 计算两个日期相隔的天数
    public static int nDaysBetweenTwoDate(String firstString, String secondString) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date firstDate = null;
        Date secondDate = null;
        try {
            firstDate = df.parse(firstString);
            secondDate = df.parse(secondString);
        } catch (Exception e) {
            // 日期型字符串格式错误
            System.out.println("日期型字符串格式错误");
        }
        int nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
        return nDay;
    }

    private static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    private static List<String> getYearBetween(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        try {
            min.setTime(sdf.parse(minDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        min.set(min.get(Calendar.YEAR), 1);
        try {
            max.setTime(sdf.parse(maxDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        max.set(max.get(Calendar.YEAR), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    private static void getDateList(String beginDate, String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(beginDate));

        for (long d = cal.getTimeInMillis(); d <= sdf.parse(endDate).getTime(); d = get_D_Plaus_1(cal)) {
            System.out.println(sdf.format(d));
        }
    }

    public static long get_D_Plaus_1(Calendar c) {
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
        return c.getTimeInMillis();
    }
}
