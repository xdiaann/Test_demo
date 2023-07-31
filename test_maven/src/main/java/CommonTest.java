import CAS和MySql乐观锁实现下单.OrderDo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.facebody20191230.models.CompareFaceRequest;
import com.aliyun.facebody20191230.models.CompareFaceResponse;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import sun.misc.BASE64Encoder;
import 秒杀_未完成.Stock;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MR.Z
 * @date 2019/12/13 11:36
 */
@Slf4j
public class CommonTest {
    @Test
    public void test1() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executor.submit(() -> {
            Thread.sleep(2000);
            return "async thread";
        });
        Thread.sleep(1000);
        boolean done = stringFuture.isDone();

        System.out.println("main thread");
        System.out.println(stringFuture.get());
    }

    @Test
    public void test2() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            //....执行任务
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }, executor);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            //....执行任务
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello1";
        }, executor);
        System.out.println(future.get());
        System.out.println(future1.get());
    }

    @Test
    public void test4() throws Exception {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "任务A");
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "任务B");
        CompletableFuture<String> futureC = futureB.thenApply(b -> {
            System.out.println("执行任务C.");
            System.out.println("参数:" + b);//参数:任务B
            return "a";
        });
    }

    @Test
    public void test5() {

    }


    @Test
    public void test022() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 3, 2, 3, 1, 3, 2, 1, 1);
        Integer max = Collections.max(list);
        System.out.println(max);
    }

    @Test
    public void test03() {
        String a = "[\n" +
                "      {\n" +
                "        \"STGRD\": \"5\",\n" +
                "        \"STTYP\": \"WQ08\",\n" +
                "        \"STAT_TIME_UNIT\": \"日\",\n" +
                "        \"STCD\": \"W58\",\n" +
                "        \"STCT\": \"WQ\",\n" +
                "        \"STNM\": \"安州闸（国控）\",\n" +
                "        \"STAT_TIME\": \"20191101\",\n" +
                "        \"CREATE_TIME\": \"2020-02-21\",\n" +
                "        \"WQG\": \"3\",\n" +
                "        \"PRIMARY_POLLUTANT\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"STGRD\": \"5\",\n" +
                "        \"STTYP\": \"WQ08\",\n" +
                "        \"STAT_TIME_UNIT\": \"日\",\n" +
                "        \"STCD\": \"W58\",\n" +
                "        \"STCT\": \"WQ\",\n" +
                "        \"STNM\": \"安州闸（国控）\",\n" +
                "        \"STAT_TIME\": \"20191128\",\n" +
                "        \"CREATE_TIME\": \"2020-02-21\",\n" +
                "        \"WQG\": \"2\",\n" +
                "        \"PRIMARY_POLLUTANT\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"STGRD\": \"5\",\n" +
                "        \"STTYP\": \"WQ08\",\n" +
                "        \"STAT_TIME_UNIT\": \"日\",\n" +
                "        \"STCD\": \"W58\",\n" +
                "        \"STCT\": \"WQ\",\n" +
                "        \"STNM\": \"安州闸（国控）\",\n" +
                "        \"STAT_TIME\": \"20191101\",\n" +
                "        \"CREATE_TIME\": \"2020-02-21\",\n" +
                "        \"WQG\": \"3\",\n" +
                "        \"PRIMARY_POLLUTANT\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"STGRD\": \"5\",\n" +
                "        \"STTYP\": \"WQ08\",\n" +
                "        \"STAT_TIME_UNIT\": \"日\",\n" +
                "        \"STCD\": \"W58\",\n" +
                "        \"STCT\": \"WQ\",\n" +
                "        \"STNM\": \"安州闸（国控）\",\n" +
                "        \"STAT_TIME\": \"20191128\",\n" +
                "        \"CREATE_TIME\": \"2020-02-21\",\n" +
                "        \"WQG\": \"2\",\n" +
                "        \"PRIMARY_POLLUTANT\": \"\"\n" +
                "      }\n" +
                "    ]";
        JSONArray objects = JSON.parseArray(a);
        System.out.println(objects);
        List<Map> maps = objects.toJavaList(Map.class);
        System.out.println(maps);
//        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
    }

    @Test
    public void urlPagToExcle() throws Exception {

        FileOutputStream fileOut = null;

        //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray

        String imgUrl = "https://img2.woyaogexing.com/2019/04/17/e7370782b0484237926113770074cd81!400x400.jpeg";
        URL url = new URL(imgUrl);
        //获取文件后缀名
        String suffix = imgUrl.substring(imgUrl.lastIndexOf(".") + 1);
        BufferedImage bufferImg = ImageIO.read(url);

        //以本地的方式图片、注释上面四行有效代码
        //        BufferedImage bufferImg = null;
        //        bufferImg = ImageIO.read(new File("D:/test.jpg"));

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        //这里要注意formatName要缓存后缀名
        ImageIO.write(bufferImg, suffix, byteArrayOut);

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("test picture");
        sheet1.setDefaultColumnWidth((short) 20);
        sheet1.setDefaultRowHeight((short) 2000);
        //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
        for (int i = 0; i < 5; i++) {
            //anchor主要用于设置图片的属性
            HSSFClientAnchor anchor =
                    new HSSFClientAnchor
                            (0, //x缩放
                                    0, // y缩放
                                    1023, //最大1023
                                    255, //最大255
                                    (short) 4,  //于下下个参数进行定位 0开始
                                    i, //在第几行
                                    (short) 4, //宽度占几格 0开始
                                    i //第几列
                            );
//          anchor.setAnchorType(3);
            //插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

        }
        fileOut = new FileOutputStream("D:/测试Excel.xls");
        // 写入excel文件
        wb.write(fileOut);
        fileOut.close();
        wb.close();
        System.out.println("----Excel文件已生成------");
    }


    final static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();
        Future<Map<String, String>> future1 = null;
        Future<Integer> future2 = null;

        try {
            future1 = executor.submit(() -> rpcService.getRpcResult());
            future2 = executor.submit(() -> httpService.getHttpResult());
            //耗时10ms
            Map<String, String> result1 = future1.get(300, TimeUnit.MILLISECONDS);
            //耗时20ms
            Integer result2 = future2.get(300, TimeUnit.MILLISECONDS);
            System.out.println(result2);

            //总耗时20ms

        } catch (Exception e) {
            if (future1 != null) {
                future1.cancel(true);
            }
            if (future2 != null) {
                future2.cancel(true);
            }
            throw new RuntimeException(e);

        }

    }

    static class RpcService {

        Map<String, String> getRpcResult() throws Exception {

            //调用远程方法（远程方法耗时约10ms，可以使用Thread.sleep模拟）
            Thread.sleep(10);
            return new HashMap<>();
        }

    }

    static class HttpService {

        Integer getHttpResult() throws Exception {

            //调用远程方法（远程方法耗时约20ms，可以使用Thread.sleep模拟）
            Thread.sleep(20);
            return 2;
        }

    }

    private static final ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("task-pool-%d").build();

    private static ExecutorService FUTURE_TASK_EXECUTOR = new ThreadPoolExecutor(
            3, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), THREAD_FACTORY);

    public static <V> Future<V> submit(Callable<V> task) {
        return FUTURE_TASK_EXECUTOR.submit(task);
    }


    @Test
    public void test001() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //### 转换的类必须是public的
        OrderDo userVO = new OrderDo(1, 1, 1);
        OrderDo userVO1 = new OrderDo(2, 2, 2);
        OrderDo userVO2 = new OrderDo(3, 3, 3);
//        Map map = PropertyUtils.describe(userVO2);
//        System.out.println(map);
        List<OrderDo> list = new ArrayList<>();
        list.add(userVO);
        list.add(userVO1);
        list.add(userVO2);
        List<Map<String, Object>> list1 = listConvert(list);
        System.out.println(list1);
    }

    //list对象转listMap
    public <T> List<Map<String, Object>> listConvert(List<T> list) {
        List<Map<String, Object>> list_map = new ArrayList<>(); // 定义List<Map<String, Object>>数组<br>　　　　　　　　　　// list为外部传进来的list集合
        if (CollectionUtils.isNotEmpty(list)) {
            list.forEach(item -> {// PropertyUtils.describe(Object)转换
                Map<String, Object> map = null;
                try {
                    map = PropertyUtils.describe(item);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                list_map.add(map);

            });
        }
        return list_map;
    }


    @Test
    public void test002() {


    }

    @Test
    public void test003() {
        String a = "1234";
        String content = "   {\"model\":\"gpt-3.5-turbo-0613\",\"max_tokens\":2000,\"temperature\":0.5,\"messages\":[{\"role\":\"assistant\",\"name\":\"get_content_and_cycle\",\"content\": \""+ a+"\"}],\"function_call\":\"auto\",\"functions\":[{\"name\":\"get_content_and_cycle\",\"description\":\"Get content and cycle\",\"parameters\":{\"type\":\"object\",\"properties\":{\"code\":{\"type\":\"integer\",\"description\":\"值为1或者-1,如果判断不了时间日期则返回-1否则返回1\"},\"content\":{\"type\":\"string\",\"description\":\"获取content里面的主要内容,忽略时间信息\"},\"reminderFrequency\":{\"type\":\"integer\",\"description\":\"根据content判断提醒频率,总共分为0-5共计6种状态,分别为 0：一次(有具体的时间则视为0一次) 1：每天 2：每周 3：每月 4: 每季度 5: 每年\"},\"reminderDay\":{\"type\":\"string\",\"description\":\"根据content获取提醒日期,提醒频率为 0一次 格式为yyyy-MM-dd 比如content里面是明天 则dd天数+1,1每天 该字段为空,2每周(1代表周1),3每月 1代表1号,4每季度 格式为yyyy-MM-dd yyyy可以为任意年份,5每年 格式为yyyy-MM-dd yyyy可以为任意年份\"},\"reminderTime\":{\"type\":\"string\",\"description\":\"提醒时间 格式 HH:mm:ss\"},\"name\":{\"type\":\"string\",\"description\":\"获取content里面人物名称,以逗号隔开\"}},\"required\":[\"code\",\"content\",\"reminderFrequency\",\"reminderDay\",\"reminderTime\",\"name\"]}}]}";

        JSONObject jsonObject = JSONObject.parseObject(content);
        System.out.println(jsonObject);

        String b = "{\"code\":1,\"show\":0,\"msg\":\"success\",\"data\":{\"code\":1,\"content\":\"明天11点提醒我要张三李四去吃药\",\"reminderFrequency\":0,\"reminderDay\":\"\",\"reminderTime\":\"11:00:00\",\"name\":\"张三,李四\"}}";
        JSONObject jsonObject1 = JSONObject.parseObject(b);
        Object code = jsonObject1.get("code");
        System.out.println(code);
    }

    @Test
    public void test004() {
        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 计算明天的日期


        // 定义日期格式化模式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String format = today.plusDays(1).format(formatter);
        // 将明天的日期格式化为字符串


        System.out.println(today.plusDays(1).format(formatter));  // 打印明天的日期字符串
    }


    @Test
    public void test005() throws Exception {
        File file = new File("D:\\userStudy.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        //总列数
        int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println(coloumNum);
        //总行数
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println(physicalNumberOfRows);
        String[] titles = {"name", "loginId", "courseName", "class", "trainLevelName", "category", "type", "teacherName", "teacherStaffId", "trainType", "trainCategory", "trainMethod", "startTime", "endTime", "hour", "score", "examScore", "incentiveRecord", "isPass", "certificateName", "cNum", "free", "address"};
        XSSFRow row;
        XSSFCell cell;
        for (int j = 0; j < physicalNumberOfRows; j++) {
            row = sheet.getRow(j);
            if (j == 0) {
                for (int c = 0; c < coloumNum; c++) {
                    cell = null == row.getCell(c) ? row.createCell(c) : row.getCell(c);
                }
                continue;
            }
            boolean flag = null != row && null != row.getCell(0) && StringUtils.isBlank(row.getCell(0).toString().trim()) ? true : false;
            if (row == null || j == 1 || j == 2 || flag) {
                continue;//过滤空行
            }
            boolean exp = false;
            boolean exp1 = false;
            String cellValue0 = "";//姓名
            String cellValue1 = "";//账号
            String cellValue2 = "";//课程名称

        }
    }


    @Test
    public void test007() {
        Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}");
        String answerStr1 = "医疗器械使用单位之间转让在用医疗器械，转让方应当确保所转让的医疗器械安全、有效，｛不得转让过期｝、失效、淘汰以及｛检验不合格的｝医疗器械。\n";
        Matcher matcher = pattern.matcher(answerStr1);
        String answerStr = "";
        while (matcher.find()) {
            String t = matcher.group(1);
            answerStr += t + "|";
        }
        String cellValue = answerStr.substring(0, answerStr.length() - 1);
        String s = answerStr1.replaceAll("\\{[^}]*\\}", "()");
        System.out.println(s);
//        String substring = answerStr.substring(0, answerStr.length() - 1);
//        System.out.println(substring);
    }
    @Test
    public void test008() {
        List<String> chatWxid = Arrays.asList("1", "2");
        String text = JSON.toJSONString(chatWxid);
        JSONObject jsonObject1 = JSONObject.parseObject(text);
        JSONObject jsonObject = JSON.parseObject(text);
    }


    public static String encodeImageToBase64(File file) throws Exception {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
//        loggerger.info("图片的路径为:" + file.getAbsolutePath());
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("图片上传失败,请联系客服!");
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = encoder.encode(data);
        return base64;//返回Base64编码过的字节数组字符串
    }
}


