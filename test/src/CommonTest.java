import com.sun.deploy.util.StringUtils;
import org.junit.Before;
import org.junit.Test;
import 深浅克隆.浅克隆.Person;

import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-06 16:02
 */
public class CommonTest {

    //传值
    @Test
    public void testChangeInt() {
        int i = 1;
        System.out.println("before change, i = " + i);//1
        changeInt(i);
        System.out.println("after  change, i = " + i);//1
    }

    public static void changeInt(int i) {
        i = 5;
        System.out.println("in the change, i = " + i);//5
    }

    @Test
    public void testChangeString() {
        String i = "Hello";
        System.out.println("before change, i = " + i);//1
        changeString(i);
        System.out.println("after  change, i = " + i);//1
    }

    public static void changeString(String i) {
        i += "World";
        System.out.println("in the change, i = " + i);//5
    }

    @Test
    public void testChangeStringBuffer() {
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("before change, sb is " + sb.toString());//Hello
        changeStringBuffer(sb);
        System.out.println("after change, sb is " + sb.toString());//Hello world !
    }

    public static void changeStringBuffer(StringBuffer stringBuffer) {
        stringBuffer.append("world !");
        System.out.println("in the change, stringBuffer = " + stringBuffer);//Hello  world !
    }

    //此处待研究  初步考虑 sb开始指向方法一的new的想 传参后至方法二 指向了新new的对象  但是该方法完毕后 对象回收 从新指向方法一的对象
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
        System.out.println("in the change, stringBuffer = " + stringBuffer);//Hi world !
    }

    @Test
    public void test4() {
        String a = "1.0.1";
        String b = "1.0.3";
        int i = a.compareTo(b);
        System.out.println(i);
    }

    //为什么会得到这样的一个结果呢？我们一步一步的分析。
    //
    // 第一、str5.equals(str3)这个结果为true，不用太多的解释，因为字符串的值的内容相同。
    // 第二、str5 == str3对比的是引用的地址是否相同，由于str5采用new String方式定义的，所以地址引用一定不相等。所以结果为false。
    // 第三、当str5调用intern的时候，会检查字符串池中是否含有该字符串。由于之前定义的str3已经进入字符串池中，所以会得到相同的引用。
    // 第四，当str4 = str1 + str2后，str4的值也为”ab”，但是为什么这个结果会是false呢？
    @Test
    public void test4_1() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));//true
        System.out.println(str5 == str3);//false
        System.out.println(str5.intern() == str3);//true
        System.out.println(str5.intern() == str4);//false
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
//        System.out.println(list);
        for (Integer i = -1; i < list.size(); i++) {
            System.out.println(i);
//            System.out.println(list.get(i+1));
        }
        list = new LinkedList(list);
//        System.out.println(list);

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
    public void test021() throws Exception {
        /** 注意：泛型和集合都只能支持引用数据类型。若要存储基本数据类型的数据，应该选择用包装类。 */
        // List<int> lists = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();
        lists.add(12);
//        lists.add(true);
        // Java是一个很优美严谨的语言

        /** 使用反射技术强制性加入一个新的其他类型的元素进去
         *  暴力的在运行时加入一个其他类型的元素。
         */
        Class<?> clazz = lists.getClass();
        // 定位添加元素的add方法
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(lists, true);
        add.invoke(lists, 99.9);
        add.invoke(lists, "Java");
        System.out.println(lists);
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
            map.put(null, 0);
            map.put(null, 1);//覆盖之前的null
            System.out.println(map);
            System.out.println("================");
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
                if (o1 == null) {
                    o1 = -999;
                }
                if (o2 == null) {
                    o2 = -999;
                }
                int i = o2.compareTo(o1);
                System.out.println("o2 : " + o2);
                System.out.println("o1 : " + o1);
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
        System.out.println("排序前");
        for (Map<String, Object> map : list) {
            System.out.println(map.get("cj"));
        }

        list.sort(Comparator.comparing(o -> (Integer.valueOf (o.get("cj").toString()))));
        System.out.println(list);
        for (Map<String, Object> map : list) {
            System.out.println(map.get("cj"));
        }
        Collections.sort(list, (o1, o2) -> {
            Integer name1 = Integer.valueOf(o1.get("cj").toString());//name1是从你list里面拿出来的一个
            Integer name2 = Integer.valueOf(o2.get("cj").toString()); //name1是从你list里面拿出来的第二个name
            return name1.compareTo(name2);
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
        Arrays.sort(maps, (o1, o2) -> {
            Integer name1 = Integer.valueOf(o1.get("cj").toString());//name1是从你list里面拿出来的一个
            Integer name2 = Integer.valueOf(o2.get("cj").toString()); //name2是从你list里面拿出来的第二个name
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

    @Test
    public void test038() throws ParseException, IOException {
        //通过StringBuilder来构建要输出的内容
        StringBuilder sb = new StringBuilder();
        sb.append("Java 运行时环境版本:"+System.getProperty("java.version")+"\n");
        sb.append("Java 运行时环境供应商:"+System.getProperty("java.vendor")+"\n");
        sb.append("Java 供应商的URL:"+System.getProperty("java.vendor.url")+"\n");
        sb.append("Java 安装目录:"+System.getProperty("java.home")+"\n");
        sb.append("Java 虚拟机规范版本:"+System.getProperty("java.vm.specification.version")+"\n");
        sb.append("Java 类格式版本号:"+System.getProperty("java.class.version")+"\n");
        sb.append("Java类路径："+System.getProperty("java.class.path")+"\n");
        sb.append("加载库时搜索的路径列表:"+System.getProperty("java.library.path")+"\n");
        sb.append("默认的临时文件路径:"+System.getProperty("java.io.tmpdir")+"\n");
        sb.append("要使用的 JIT 编译器的名称:"+System.getProperty("java.compiler")+"\n");
        sb.append("一个或多个扩展目录的路径:"+System.getProperty("java.ext.dirs")+"\n");
        sb.append("操作系统的名称:"+System.getProperty("os.name")+"\n");
        sb.append("操作系统的架构:"+System.getProperty("os.arch")+"\n");
        sb.append("操作系统的版本:"+System.getProperty("os.version")+"\n");
        sb.append("文件分隔符（在 UNIX 系统中是“/”）:"+System.getProperty("file.separator")+"\n");
        sb.append("路径分隔符（在 UNIX 系统中是“:”）:"+System.getProperty("path.separator")+"\n");
        sb.append("行分隔符（在 UNIX 系统中是“/n”）:"+System.getProperty("line.separator")+"\n");
        sb.append("用户的账户名称:"+System.getProperty("user.name")+"\n");
        sb.append("用户的主目录:"+System.getProperty("user.home")+"\n");
        sb.append("用户的当前工作目录:"+System.getProperty("user.dir")+"\n");

        //新建一个文件，如果该文件不存在则创建一个
        File file = new File("c:\\t.txt");
        if( !file.exists()){
            file.createNewFile();
        }
        OutputStream ous = new FileOutputStream(file);

        //获取系统的属性
        Properties ps = System.getProperties();
        //获得系统属性中的键值
        Set<String> set = ps.stringPropertyNames();
        for(String name: set){
            sb.append(name + " : " +ps.getProperty(name) + "\n");
            System.out.println(name + " : " +ps.getProperty(name) );
        }
        ous.write(sb.toString().getBytes());
        ous.close();

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println("Java运行时环境版本:"+System.getProperty("java.version"));
        System.out.println("Java 运行时环境供应商:"+System.getProperty("java.vendor"));
        System.out.println("Java 供应商的URL:"+System.getProperty("java.vendor.url"));
        System.out.println("Java 安装目录:"+System.getProperty("java.home"));
        System.out.println("Java 虚拟机规范版本:"+System.getProperty("java.vm.specification.version"));
        System.out.println("Java 类格式版本号:"+System.getProperty("java.class.version"));
        System.out.println("Java 类路径："+System.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表:"+System.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径:"+System.getProperty("java.io.tmpdir"));
        System.out.println("要使用的 JIT 编译器的名称:"+System.getProperty("java.compiler"));
        System.out.println("一个或多个扩展目录的路径:"+System.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称:"+System.getProperty("os.name"));
        System.out.println("操作系统的架构:"+System.getProperty("os.arch"));
        System.out.println("操作系统的版本:"+System.getProperty("os.version"));
        System.out.println("文件分隔符（在 UNIX 系统中是“/”）:"+System.getProperty("file.separator"));
        System.out.println("路径分隔符（在 UNIX 系统中是“:”）:"+System.getProperty("path.separator"));
        System.out.println("行分隔符（在 UNIX 系统中是“/n”）:"+System.getProperty("line.separator"));
        System.out.println("用户的账户名称:"+System.getProperty("user.name"));
        System.out.println("用户的主目录:"+System.getProperty("user.home"));
        System.out.println("用户的当前工作目录: "+System.getProperty("user.dir"));

        InetAddress netAddress = getInetAddress();
        System.out.println("host ip:" + getHostIp(netAddress));
        System.out.println("host name:" + getHostName(netAddress));
    }
    /**
     * 获取本地主机
     * @return
     */
    public static InetAddress getInetAddress() throws UnknownHostException {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("unknown host!");
        }
        return null;
    }

    /**
     * 通过InetAddress获取本地Ip
     * @param netAddress
     * @return
     */
    public static String getHostIp(InetAddress netAddress) {
        if (null == netAddress) {
            return null;
        }
        String ip = netAddress.getHostAddress();
        return ip;
    }

    /**
     * 通过InetAddress获取本地主机的名字
     * @param netAddress
     * @return
     */
    public static String getHostName(InetAddress netAddress) {
        if (null == netAddress) {
            return null;
        }
        String name = netAddress.getHostName();
        return name;
    }




    @Test
    public void test039()  {
        String str1 = new String("abc");
        String str2 = "abc";
        System.out.println(str1 == str2);//false

        String str3 = "abc";
        String str4 = "abc";
        System.out.println(str3==str4); //true
        //  可以看出str1和str2是指向同一个对象的。

        String str5 =new String ("abc");
        String str6 =new String ("abc");
        System.out.println(str5==str6); // false
        //  用new的方式是生成不同的对象。每一次生成一个。
    }
    @Test
    public void test040()  {


    }
    @Test
    public void test041()  {
        double a = 0.1;
        double b = 0.2;
        System.out.println(a+b);

//        boolean b1 = 3 * 0.1 == 0.3;
//        if (b1) {
//            System.out.println(1);
//        }

    }
    @Test
    public void test042()  {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("baseUrl", "http://www.aipeixun360.com:8888");
        dataMap.put("baseAppUrl", "http://www.aipeixun360.com:8092");
        String templateStr = "<p><a href=\"#baseAppUrl#/#/Course/#id#?close=true\" target=\"_blank\" style=\"background-color: rgb(255, 255, 255);\">您好，学习平台发布了#name#课程，欢迎参与学习！</a></p>";
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String replaceKey = String.format("#%s#", entry.getKey());
            if(Objects.nonNull(entry.getValue())){
                templateStr = templateStr.replaceAll(replaceKey, entry.getValue());
                System.out.println(templateStr);
            }
        }
    }
    @Test
    public void test043() throws ParseException {
        String a = "2021-06-30 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse(a);
        boolean before = new Date().before(parse);
        System.out.println(before);
//
//        List list = new ArrayList();
//        list.get(0);
//        System.out.println(null==list);
        long l = new BigDecimal(1).add(new BigDecimal(1)).longValue();
        long l1 = new BigDecimal(1).add(BigDecimal.valueOf(1)).longValue();
        System.out.println(l);
        System.out.println(l1);

    }
    @Test
    public void test044() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date parse = simpleDateFormat.parse("20210730");
        System.out.println(parse);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date yesterday = calendar.getTime();
        System.out.println(yesterday);
        Calendar ca = Calendar.getInstance();

        ca.setTime(parse);

        ca.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println(ca.getTime());
    }
    @Test
    public void test045()  {
        int i = new BigDecimal(0).compareTo(BigDecimal.ONE);
        System.out.println(i);
    }
    @Test
    public void test046()  {
        Integer a = null;
        if (a > 0) {
            System.out.println(1);
        }
    }
    @Test
    public void test047()  {
        BigDecimal a =new BigDecimal(0.1);
        BigDecimal b =new BigDecimal(0.2);
        int result = a.compareTo(b);
//        result = -1;//表示a小于b
//        result = 0;//表示a等于b;
//        result = 1;//表示a大于b;
        System.out.println(result);
    }
    @Test
    public void test048()  {
        String format = new SimpleDateFormat().format(new Date());
        System.out.println(format);
        String str1 = null;
        String str2 = null;
        boolean b = str1 == null ? str2 == null : str1.equals(str2);
        System.out.println(b);

    }





}






