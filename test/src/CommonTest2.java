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

    }

    @Test
    public void test07() {

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
    public void test09() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String eTime = sdf.format(new Date());
        String sTime = DateUtil.addMin(sdf.parse(eTime), -30, "yyyy-MM-dd HH:mm:ss");
        System.out.println(sTime+" "    +eTime);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date parse = sdf1.parse("2020/02/02 3:00:00");
        System.out.println(parse);

    }


}
