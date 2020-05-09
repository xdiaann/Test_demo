package gson_fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-22 14:48
 */
@Slf4j
public class TestGson_FastJson {

    @Test
    public void testGson() {
        Gson gson = new Gson();
        Student student = getStudent();
        //把Java的Class对象使用Gson转换成Json字符串
        String jsonStr = gson.toJson(student);
        System.out.println(jsonStr);
        //Json字符串使用Gson转换成Student对象
        Student studentG = gson.fromJson(jsonStr, Student.class);
        System.out.println(studentG);


    }

    @Test
    public void testFastJson() {
        Student student = getStudent();
        //转json字符串
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);//{"age":22,"books":["数学","语文","英语"],"booksMap":{"1":"数学","2":"语文","3":"英语"},"email":"965266509@qq.com","id":1,"nickName":"乔晓松"}

        //转对象
        Student parseObject = JSON.parseObject(jsonString, Student.class);
        System.out.println(parseObject);//Student(id=1, nickName=乔晓松, age=22, email=965266509@qq.com, books=[数学, 语文, 英语], booksMap={1=数学, 2=语文, 3=英语})

    }

    private Student getStudent() {
        Student student = new Student();
        student.setId(1);
        student.setNickName("乔晓松");
        student.setAge(22);
        student.setEmail("965266509@qq.com");
        ArrayList<String> books = new ArrayList<String>();
//        books.add("数学");
//        books.add("语文");
//        books.add("英语");
        student.setBooks(books);
        HashMap<String, String> booksMap = new HashMap<String, String>();
        booksMap.put("1", "数学");
        booksMap.put("2", "语文");
        booksMap.put("3", "英语");
        student.setBooksMap(booksMap);
//        System.out.println(student);
        return student;
    }

    @Test
    public void test3() {
        Student student = getStudent();
        ArrayList<String> books = student.getBooks();
        System.out.println(books);
    }

}
