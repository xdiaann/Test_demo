package SSM.beanTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MR.Z
 * @date 2020/9/13 18:58
 */
public class SpringTest {

//    创建ioc容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("springmvc.xml");

    @Test
    public void test() {
        Book book = (Book)ioc.getBean("book");
        Book book2 = (Book)ioc.getBean("book");

        System.out.println(book==book2);
    }
}
