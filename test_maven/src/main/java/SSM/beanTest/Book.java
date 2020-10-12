package SSM.beanTest;

import lombok.Data;

/**
 * @author MR.Z
 * @date 2020/9/13 18:55
 */
@Data
public class Book {
    Integer id;
    String title;
    String author;
    double price;
    Integer sales;

    public Book() {
        System.out.println("BOOK对象创建");
    }
}
