import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-06 16:02
 */
public class CommonTest {

    @Test
    public void test1() {
        int i = 1;
        System.out.println("before change, i = " + i);//1
        change(i);
        System.out.println("after  change, i = " + i);//1
    }

    public static void change(int i) {
        i = 5;
        System.out.println("in the change, i = " + i);//5
    }

    @Test
    public void test1_1() {
        String i = "Hello";
        System.out.println("before change, i = " + i);//1
        change1_1(i);
        System.out.println("after  change, i = " + i);//1
    }

    public static void change1_1(String i) {
        i += "World";
        System.out.println("in the change, i = " + i);//5
    }

    @Test
    public void test2() {
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("before change, sb is " + sb.toString());//Hello
        change1(sb);
        System.out.println("after change, sb is " + sb.toString());//Hello world !
    }

    public static void change1(StringBuffer stringBuffer) {
        stringBuffer.append("world !");
    }

    @Test
    public void test3() {
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("before change, sb is " + sb.toString());//Hello
        change2(sb);
        System.out.println("after change, sb is " + sb.toString());//Hello
    }

    public static void change2(StringBuffer stringBuffer) {
        stringBuffer = new StringBuffer("Hi ");
        stringBuffer.append("world !");
    }

    @Test
    public void test4() {
        String a = "1.0.1";
        String b = "1.0.3";
        int i = a.compareTo(b);
        System.out.println(i);
    }

    @Test
    public void test5() {
        String a = "99";
        if (Integer.valueOf(a) > 9 || Integer.valueOf(a) < 1 && Integer.valueOf(a) != 99) {
            System.out.println("错误");
        } else {
            System.out.println("正确");
        }
    }

    @Test
    public void test6() {
        readFile("qwe.txt");
        System.out.println("123");
    }

    public static void readFile(String fileName) {
        if (!fileName.endsWith(".txt")) {
            throw new BusinessException("文件的后缀名不对");
        }
        System.out.println("路径没有问题，读取文件");
    }

    public static class BusinessException extends RuntimeException {
        public BusinessException() {
            super();
        }

        public BusinessException(String message) {
            super(message);
        }

    }

    @Test
    public void test7() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        String time = sdf.format(date);
        System.out.println(time);
    }

    @Test
    public void test8() {
        addElement(2);
    }

    public static void addElement(int e) {
        List<Integer> sSorted = new LinkedList<>();
        int i;
        for (i = 0; i < sSorted.size(); ++i) {
            if (e <= sSorted.get(i)) {
                break;
            }
        }
        sSorted.add(i, e);
    }

    @Test
    public void test9() {
        int a = 0b0001_1001;
        System.out.println("a is :" + a);
    }


    @Test
    public void test14() {

        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2);//true

        Integer i3 = new Integer(100);
        Integer i4 = new Integer(100);
        System.out.println(i3 == i4);//false


    }

    private boolean flag = false;
    int i = 5;
    int j = 5;

    void read() {
        i = 10;
        j = 20;
        flag = true;
    }

    void write() {
        while (flag) {
            int temp = i * j;
        }
    }

    @Test
    public void test015() {
        int fuc = fuc(2012, 2102);
//        System.out.println(fuc);
    }

    int fuc(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return fuc(n, m % n);
        }
    }

    @Test
    public void test016() {
        int i = 0;
        int j = 9;
        do {
            if (i++ > --j) {
                break;
            }
        } while (i < 4);
        System.out.println(i + " " + j);
    }


    @Test
    public void test017() {
        List list = new ArrayList();
        list.add(1);
        list.add("a");
        list.add(11);
        System.out.println(list);
        list = new LinkedList(list);
        System.out.println(list);

        ArrayList<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<>();
        list1.trimToSize();
//        list2.trimToSize();//报错
    }


    @Test
    public void test019() {
        String pathFile = "D:\\IDEAproject\\gaio-apis/static/upload/highMeter/1575526415606.jpg" + "," +
                "D:\\IDEAproject\\gaio-apis/static/upload/highMeter/1575526415616.jpg";
        String[] pathFileSq = pathFile.split(",");
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("status", 1);
//        List<FileDataEntity> attachList = new ArrayList<>();
        String hmUploadPath = "D:\\IDEAproject\\gaio-apis/static/" + "upload/highMeter/";////D:\IDEAproject\gaio-apis/static/upload/highMeter/
        File file = new File(hmUploadPath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
        List<File> fileList = new ArrayList<>();
        List<String> filePath = new ArrayList<>();
//        String pathZipFile = null;
        for (int i = 0; i < pathFileSq.length; i++) {
            File file1 = new File(pathFileSq[i]);
            if (!file1.exists() && !file1.isDirectory()) {
                file1.mkdirs();
            }
            pathFile = pathFileSq[i];
            filePath.add(pathFile);
            fileList.add(new File(pathFile));
        }
    }

    @Test
    public void test020() {
        String pathFile = "D:\\IDEAproject\\gaio-apis/static/upload/highMeter";
        File file = new File(pathFile);
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }

    @Test
    public void test021() {

    }

    public static void main(String[] args) {
//        String resident = "[[\"00\",null,null,null,null,null,null,null,null,null,null],[\"SFHM\",\"XM\",\"X
//        B\",\"MZ\",\"CSRQ\",\"ZZXZ\",\"HH\",\"HLX\",\"GLZT\",\"FWCS\",\"SSPCSJGDM\"]]";
        String resident = "[[\"00\",null,null,null,null,null,null,null,null,null,null],[\"SFHM\",\"XM\",\"XB\"" +
                ",\"MZ\",\"CSRQ\",\"ZZXZ\",\"HH\",\"HLX\",\"GLZT\",\"FWCS\",\"SSPCSJGDM\"],[\"432502199303162318\",\"王琦\",\"1\",\"01\",\"19930316\",\"长沙市芙蓉区芙蓉社区人民东路189号芙蓉区人才交流中心\",\"4301021516735897\",\"3\",\"1\",\"43010201156474\",\"430102450000\"]]";
        String[] split = resident.split("]");
        System.out.println(split.length - 2);
        //方法1；定义并初始化arr
        int[][] arr = new int[3][4];
        arr[0][1] = 1;
        arr[0][2] = 2;
        arr[1][2] = 3;
        arr[1][1] = 4;
        arr[2][3] = 8;
        //遍历arr
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("arr[" + i + "][" + j + "]=" + arr[i][j]);
            }
        }
        System.out.println("====================================");
        //方法二: 定义并初始化str ；
        String[][] str1 = new String[][]{{"a", "b", "c",}, {"d", "e", "f",}, {"g", "h", "i"}};
        //方法三: 定义并初始化str ；
        String[][] str = {{"a", "b", "c",}, {"d", "e", "f",}, {"g", "h", "i"}};

        //遍历str方法1:利用两层for循环。
        for (int i = 0; i < str.length; i++) {//i控制一维数组。
            for (int j = 0; j < str[i].length; j++) {//j遍历每个一维数组的元素
                System.out.println(" str[" + i + "][" + j + "]=" + str[i][j]);
            }
        }

        //遍历str方法2:利用foreach循环。
        //for each不能自动处理二维数组的每一个元素，它是按照行处理。就是按照一维数组处理的。所以要访问二维数组
        //必须使用两个嵌套的循环。
        for (String[] row : str) {
            for (String s : row) {
                System.out.println(s);
            }
        }
        //遍历str方法3:想要快速地打印一个二维数组的数据元素列表，可以直接调用
        System.out.println(Arrays.deepToString(str));
    }


    @Test
    public void test022() {
//                String resident = "[[\"00\",null,null,null,null,null,null,null,null,null,null],[\"SFHM\",\"XM\",\"XB\",\"MZ\",\"CSRQ\",\"ZZXZ\",\"HH\",\"HLX\",\"GLZT\",\"FWCS\",\"SSPCSJGDM\"]]";
        String resident = "[[\"00\",null,null,null,null,null,null,null,null,null,null],[\"SFHM\",\"XM\",\"XB\"" +
                ",\"MZ\",\"CSRQ\",\"ZZXZ\",\"HH\",\"HLX\",\"GLZT\",\"FWCS\",\"SSPCSJGDM\"],[\"432502199303162318\",\"王琦\",\"1\",\"01\",\"19930316\",\"长沙市芙蓉区芙蓉社区人民东路189号芙蓉区人才交流中心\",\"4301021516735897\",\"3\",\"1\",\"43010201156474\",\"430102450000\"]]";
        String[] split = resident.split("]");
        System.out.println("分几组: " + split.length);
//        for (String s : split) {
//            System.out.println("每组的数组分别是: "+s);
//        }

        for (int i1 = 0; i1 < split.length; i1++) {
            if (i1 == 0) {
                String substring = split[i1].substring(1, split[i1].length());
                System.out.println(substring);
                String s = substring + "]";
                System.out.println(s);
            }
        }
    }


    @Test
    public void test023() {
        System.out.println("我在活着。。。。");
        System.gc();
        System.out.println("我要aa了。。。。");
    }

    static Map<String, String> first = new HashMap();

    @Test
    public void test024() {
        CommonTest t = new CommonTest();
        int i = 128;
        first.put("count", "127");
        int f = Integer.valueOf(first.get("count"));
        int ff = f + 1;
        first.put("count", ff + "");
        t.testNum(i);
    }

    //如果改为形参改为int 则为true
    public void testNum(Integer num) {
        System.out.println(first.get("count") + "//" + num);//128//128
        System.out.println(Integer.valueOf(first.get("count")) == num);//  false

    }

    //递归 阶乘 如5!  5*4*3*2*1
    @Test
    public void test025() throws UnsupportedEncodingException {
        System.out.println(diGui(5));

    }

    int diGui(int i) {
        if (i == 1) {
            return 1;
        }
        return i * diGui(i - 1);
    }

    @Test
    public void test026() throws UnsupportedEncodingException {
        String hbDate = getHbDate("1989-07-11");
        System.out.println(hbDate);
        String tbDate = getTbDate("1989-02-28");
        System.out.println(tbDate);
    }

    //排序
    @Test
    public void test027() {
        {
            Map<String, Integer> map = new HashMap<>();
            map.put("王二", 8);
            map.put("沈吴", 2);
            map.put("小菜", -3);
            map.put("菜菜", null);
            map.put("大鸟", 1);
            map.put("小鸟", -1);
            map.put("二鸟", 3);
            map.put("三鸟", -2);
            map.put("四鸟", null);
            map.put("五鸟", 0);

            Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
            System.out.println(entrySet);
            for (Map.Entry s : entrySet) {
                System.out.println(s.getKey() + "-->" + s.getValue());
            }

            System.out.println("============排序后============");

            //////借助list实现hashMap排序//////
            //注意 ArrayList<>() 括号里要传入map.entrySet()
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            System.out.println(list + "list");
            list.sort(Map.Entry.comparingByValue((o1, o2) -> {
                if (o1 == null ) {
                    o1 = -999;
                }
                if ( o2 == null) {
                    o2 = -999;
                }
                int i = o2.compareTo(o1);
                System.out.println("o2 : "+o2);
                System.out.println("o1 : "+o1);
                System.out.println(i);
                return i;
            }));

            //注意这里遍历的是list，也就是我们将map.Entry放进了list，排序后的集合
            for (Map.Entry s : list) {
                System.out.println(s.getKey() + "-->" + s.getValue());
            }

        }
    }

    /**
     * @param
     * @return String
     * @throws
     * @Description: 获取上个月环比日期
     * @author
     * @createtime
     */
    public String getHbDate(String currentDate) {

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
    public String getTbDate(String currentDate) {
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

    //一只青蛙可以一次跳 1 级台阶或一次跳 2 级台阶,例如:
    //跳上第 1 级台阶只有一种跳法：直接跳 1 级即可。
    //跳上第 2 级台阶  有两种跳法：每次跳 1 级，跳两次；或者一次跳 2 级。
    //问要跳上第 n 级台阶有多少种跳法？
    //解题思路  3 111 12 21  4 1111 121 21 b1 112 228523
    @Test
    public void test028() {
        System.out.println(tiao(3));
    }

    public int tiao(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return tiao(n - 1) + tiao(n - 2);
    }


    @Test
    public void test029() throws UnsupportedEncodingException {
        String decodeStr = URLDecoder.decode("%E6%B0%A8%E6%B0%AE%2C%E6%B0%B4%E6%B8%A9", "utf-8");
        System.out.println("解码:" + decodeStr);
    }

    @Test
    public void test030() {
        double a = (double) 1 / 2;
        System.out.println(a);

        System.out.println(sciCalFive((double) 2 / 3, 0));
    }

    /**
     * @param value
     * @param digit
     * @return double    返回类型
     * @throws
     * @Title: sciCalFive
     * @Description: 四舍五入
     */
    public static String sciCalFive(Double value, int digit) {
        if (value == null) {
            return null;
        }
        if (digit == 0) { // 修约小数位为0时  转整数
            return String.valueOf(new BigDecimal(value)
                    .setScale(digit, BigDecimal.ROUND_HALF_UP).intValue());
        }
        return String.valueOf(new BigDecimal(value)
                .setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue());
    }


    @Test
    public void test031() {
        Map<String, String> m1 = new HashMap<String, String>();
        Map<String, String> m2 = new HashMap<String, String>();

        for (Map.Entry<String, String> entry1 : m1.entrySet()) {
            String m1value = entry1.getValue() == null ? "" : entry1.getValue();
            String m2value = m2.get(entry1.getKey()) == null ? "" : m2.get(entry1.getKey());
            if (!m1value.equals(m2value)) {//若两个map中相同key对应的value不相等
                //其他操作...
            }
        }
    }

    @Test
    public void test032() {
        Map<String, Object> m1 = new HashMap<String, Object>();
        m1.put("a", "abc");
        m1.put("b", "123");
        m1.put("c", "123");
        m1.put("d", "123");

        Map<String, Object> m2 = new HashMap<String, Object>();
        m2.put("c", "123");
        m2.put("a", "abc");
        m2.put("b", "123");
        m2.put("d", "123");

        Map<String, Object> m3 = new HashMap<String, Object>();
        m3.put("a", "abc");
        m3.put("b", "123");
        m3.put("c", "123");
        m3.put("d", "123");

        Map<String, Object> m4 = new HashMap<String, Object>();
        m4.put("b", "123");
        m4.put("a", "abc");
        m4.put("c", "123");
        m4.put("d", "123");

        List<Map<String, Object>> a = new ArrayList<>();
        a.add(m1);
        a.add(m2);

        List<Map<String, Object>> b = new ArrayList<>();
        b.add(m3);
        b.add(m4);

        boolean c = isEqualCollection(a, b);
        System.out.println(c);
    }

    private static final Integer INTEGER_ONE = 1;

    // 判断并返回结果 true和false
    public static boolean isEqualCollection(Collection a, Collection b) {
        if (a.size() != b.size()) { // size是最简单的相等条件
            return false;
        }
        Map mapa = getCardinalityMap(a);
        System.out.println(mapa);
        Map mapb = getCardinalityMap(b);
        System.out.println(mapb);

        // 转换map后，能去掉重复的，这时候size就是非重复项，也是先决条件
        if (mapa.size() != mapb.size()) {
            System.out.println("存储的map数据不一致！");
            return false;
        } else {
            System.out.println("转换map后，能去掉重复的，这时候size就是非重复项后，存储的map数据一致！");
        }
        Iterator it = mapa.keySet().iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            // 查询同一个obj，首先两边都要有，而且还要校验重复个数，就是map.value
            if (getFreq(obj, mapa) != getFreq(obj, mapb)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 以obj为key，可以防止重复，如果重复就value++ 这样实际上记录了元素以及出现的次数
     */
    public static Map getCardinalityMap(Collection coll) {
        Map count = new HashMap();
        for (Iterator it = coll.iterator(); it.hasNext(); ) {
            Object obj = it.next();
            Integer c = (Integer) count.get(obj);
            if (c == null)
                count.put(obj, INTEGER_ONE);
            else {
                count.put(obj, new Integer(c.intValue() + 1));
            }
        }
        return count;
    }

    private static final int getFreq(Object obj, Map freqMap) {
        Integer count = (Integer) freqMap.get(obj);
        if (count != null) {
            return count.intValue();
        }
        return 0;
    }

    @Test
    public void test033() {
        Double a = 0.0 / 0;
        if (a.isNaN()) {
            System.out.println(true);
        }
        System.out.println(a);
    }

    @Test
    public void test034() {
        String a = "2020年3月31日";
        String substring = a.substring(7);
        System.out.println(substring);
    }

    @Test
    public void test035() {
        Map<String, Integer> map = new HashMap();
        map.put("1", 2);
        map.put("2", 3);
        map.put("3", 4);
        Collection<Integer> values = map.values();
        int a = 0;
        for (Integer value : values) {
            a += value;
        }
        System.out.println(values);
        System.out.println(a);
    }

    @Test
    public void test036() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "p");
        map1.put("cj", "5");
        map1.put("1", "3");
        map1.put("2", "4");
        System.out.println(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "h");
        map2.put("cj", "12");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "f");
        map3.put("cj", "31");
        list.add(map1);
        list.add(map3);
        list.add(map2);
        //排序前
        for (Map<String, Object> map : list) {
            System.out.println(map.get("cj"));
        }
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer name1 = Integer.valueOf(o1.get("cj").toString());//name1是从你list里面拿出来的一个
                Integer name2 = Integer.valueOf(o2.get("cj").toString()); //name1是从你list里面拿出来的第二个name
                return name1.compareTo(name2);
            }
        });
        //List<Map>排序后
        System.out.println("List<Map>排序后-------------------");
        for (Map<String, Object> map : list) {
            System.out.println(map.get("cj"));
        }
        //数组的用Arrays.sort
        List<Map> listArray = new ArrayList<Map>();
        listArray.add(map1);
        listArray.add(map3);
        listArray.add(map2);
        Map[] maps = new Map[listArray.size()];
        listArray.toArray(maps);
        Arrays.sort(maps, new Comparator<Map>() {
            public int compare(Map o1, Map o2) {
                Integer name1 = Integer.valueOf(o1.get("cj").toString());//name1是从你list里面拿出来的一个
                Integer name2 = Integer.valueOf(o2.get("cj").toString()); //name2是从你list里面拿出来的第二个name
                return name1.compareTo(name2);
            }
        });
        //lambda表达式
        Arrays.sort(maps, (o1, o2) -> {
            Integer name1 = Integer.valueOf(o1.get("cj").toString());
            //name1是从你list里面拿出来的一个
            Integer name2 = Integer.valueOf(o2.get("cj").toString());
            //name2是从你list里面拿出来的第二个name
            return name1.compareTo(name2);
        });
        //数组排序后
        System.out.println("数组排序后-------------------");
        for (Map<String, Object> map : list) {
            System.out.println(map.get("cj"));
        }
    }

    @Test
    public void test037() throws ParseException {
//        double a = 2;
//        double b = 1.5;
//        DecimalFormat df = new DecimalFormat("0.00%");
//        String format = df.format((a - b) / b);
//        System.out.println(format);

        String str = "34.2%";//字符串类型的百分数
        NumberFormat nf = NumberFormat.getPercentInstance();//NumberFormat是一个工厂，可以直接getXXX创建，而getPercentInstance() 是返回当前默认语言环境的百分比格式。
        Number m = nf.parse(str);//提供了带有 ParsePosition 和 FieldPosition 的 parse 和 format 方法的形式，parse(xx)表示解析给定字符串开头的文本，生成一个数值。逐步地解析字符串的各部分
        System.out.println(m);//打印数值  0.342

        nf.setMaximumFractionDigits(3);
        System.out.println(nf.format(0.343));//  34.3%

    }


}




