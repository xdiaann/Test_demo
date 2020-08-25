import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author MR.Z
 * @date 2020/5/7 9:23
 */
public class CommonTest2 {

    @Test
    public void test01() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        SimpleDateFormat sdfF = new SimpleDateFormat("yyyy-MM-dd HH");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, -1);
        String t = sdf.format(c.getTime());
        System.out.println(t);
    }

    @Test
    public void test02() {
        List<List<Integer>> DataList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        DataList.add(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        DataList.add(list2);

        System.out.println(DataList);
    }

    @Test
    public void test03() {
        String a = "sdfsdfs\raaa";
        String b = "sdfsdfs\naaa";
        String c = "sdfsdfs\r\naaa";
        System.out.println(a);
        System.out.println("====");
        System.out.println(b);
        System.out.println("====");
        System.out.println(c);
    }

    @Test
    public void test04() {
        System.out.println(1 << 8);
        System.out.println(32 >>> 2);
        System.out.println(32 >> 2);
    }

    @Test
    public void test05() {

        // ^ (h >>> 16)
        int h;
        int i = "1".hashCode();
        System.out.println(i);
    }

    @Test
    public void test06() {

        getDateList("日", "202001", "202003");

    }

    private void getDateList(String timeType, String startTime, String endTime) {
        SimpleDateFormat sdfD = null;
        if (timeType.equals("小时")) {
            sdfD = new SimpleDateFormat("yyyy-MM-dd HH");
        }
        Calendar c = Calendar.getInstance();
        List<String> xAils = new ArrayList<>();
        try {
            Date sd = sdfD.parse(startTime);
            Date ed = sdfD.parse(endTime);
            c.setTime(sd);
            while (c.getTime().before(ed) || c.getTime().equals(ed)) {
                String format = sdfD.format(c.getTime());

                if (timeType.equals("yyyyMMddHH") || timeType.equals("yyyy-MM-dd HH")) {
                    c.add(Calendar.HOUR_OF_DAY, 1);
                } else if (timeType.equals("yyyyMMdd") || timeType.equals("yyyy-MM-dd")) {
                    c.add(Calendar.DAY_OF_MONTH, 1);
                } else if (timeType.equals("yyyyMM") || timeType.equals("yyyy-MM")) {
                    c.add(Calendar.MONTH, 1);
                } else if (timeType.equals("yyyy")) {
                    c.add(Calendar.MONTH, 1);
                } else {
                    throw new RuntimeException("暂不支持的时间格式");
                }
                xAils.add(format);
            }
        } catch (ParseException e) {
            throw new RuntimeException("日期格式解析错误");
        }
        System.out.println(xAils);
    }

    @Test
    public void test07() {
        System.out.println(16*22.5);
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            list.add(i * 22.5);
        }
        System.out.println(list);
    }

    @Test
    public void test08() {
        Object o = new Object();
        List list = new ArrayList();
        list.add("1");
        List list1 = new ArrayList();
        list1.add("1");
        o = list1;
        boolean equals = o.equals(list);
        System.out.println(equals);
    }

    @Test
    public void test09() {

    }

    @Test
    public void test10()  {
        Object a = null;
        String s = (String) (a);
        System.out.println(s);
//        Double aDouble = Double.valueOf(s);

        Object b = 1.2;
        Object c = 0.5;
        double v = (Double) b / (Double) c;
        System.out.println(v);


    }
    @Test
    public void test11()  {
        Date date = new Date();
        String s = date.toString();
        System.out.println(date);
        System.out.println(s);
    }

    @Test
    public void test12()  {
        int i = 1;
        i = i++;  //i-> 1
        int j = i++; //i->2  j=1
        int k = i + ++i * i++;//2+3*3
        System.out.println(i);//4
        System.out.println(j);//1
        System.out.println(k);//8

    }
    @Test
    public void test13()  {
        int i = 1;
        int j = i + ++i * i++;//1+2*2
        System.out.println(i);
        System.out.println(j);

    }
    @Test
    public void test14()  {
        int a = 9;
        int b = 8;
        int c = 8;
        int d = 9;
        System.out.println(a%b);
        System.out.println(a&b);

        System.out.println(c%d);
        System.out.println(c&d);
    }



    @Test
    public void test15()  {

    }
    @Test
    public void test16()  {

    }
    @Test
    public void test17()  {

    }


}
