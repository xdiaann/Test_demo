import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.*;

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
    public void test5() throws Exception {
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
    public void test03test03() throws Exception {

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
            3, 10, 60L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(), THREAD_FACTORY);

    public static <V> Future<V> submit(Callable<V> task) {
        return FUTURE_TASK_EXECUTOR.submit(task);
    }

@Test
    public void test001() {
    UserVO userVO = new UserVO("1", 1);
    UserVO userVO1 = new UserVO("2", 2);
    UserVO userVO2 = new UserVO("2", 2);
    List<UserVO> list = new ArrayList<>();
    list.add(userVO);
    list.add(userVO1);
    list.add(userVO2);
    List<Map<String, Object>> list1 = listConvert(list);
    System.out.println(list1);
}

    public <T> List<Map<String, Object>> listConvert(List<T> list) {
        List<Map<String, Object>> list_map = new ArrayList<>(); // 定义List<Map<String, Object>>数组<br>　　　　　　　　　　// list为外部传进来的list集合
        if (CollectionUtils.isNotEmpty(list)) {
            list.forEach(item ->{// PropertyUtils.describe(Object)转换
                Map<String, Object> map = null;
                try {
                    map = PropertyUtils.describe(item);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                list_map.add(map );

            });
        }
        return list_map;
    }
    private final static String[] parsePatterns = {"yyyy-MM-dd",
            "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMdd"};
@Test
    public void test002() {
    try {
        Date date = DateUtils.parseDate("1000000", parsePatterns);
    } catch (ParseException e) {
        e.printStackTrace();
    }
}


}


