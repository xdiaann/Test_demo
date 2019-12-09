package gson_fastJson;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-22 14:48
 */
@Data
public class Student {
    private int id;
    private String nickName;
    private int age;
    private String email;

    private ArrayList<String> books;
    private HashMap<String, String> booksMap;

}