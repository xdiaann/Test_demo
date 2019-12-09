import org.junit.Assert;
import org.junit.Test;
import stream.Person;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-06 16:02
 */
public class CommonTest {

    @Test
    public void test1() {
        int i = 1;
        System.out.println("before change, i = " + i);
        change(i);
        System.out.println("after change, i = " + i);
    }

    public static void change(int i) {
        i = 5;
        System.out.println(i);
    }

    @Test
    public void test2() {
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("before change, sb is " + sb.toString());
        change1(sb);
        System.out.println("after change, sb is " + sb.toString());
    }

    public static void change1(StringBuffer stringBuffer) {
        stringBuffer.append("world !");
    }

    @Test
    public void test3() {
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("before change, sb is " + sb.toString());
        change2(sb);
        System.out.println("after change, sb is " + sb.toString());
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
        String pathFile = "D:\\IDEAproject\\gaio-apis/static/upload/highMeter/1575526415606.jpg" +","+
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

    @Test
    public void test022() {

    }
}




