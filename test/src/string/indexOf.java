package string;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-16 15:01
 */
public class indexOf {
    public static void main(String[] args) {
        String test = "This,is,test,for string";
        System.out.println(test.contains("This"));
        System.out.println(test.contains("Is"));
        System.out.println(test.contains("test"));
        System.out.println(test.indexOf("for")); //13
        System.out.println(test.indexOf("for string       "));//-1

        if (test.indexOf("This") != -1) {
            //"只要test.indexOf('This')返回的值不是-1说明test字符串中包含字符串'This',相反如果包含返回的值必定是-1"
            System.out.println("存在包含关系，因为返回的值不等于-1");
        } else {
            System.out.println("不存在包含关系，因为返回的值等于-1");
        }

        if (test.indexOf("this") != -1) {
            //"只要test.indexOf('this')返回的值不是-1说明test字符串中包含字符串'this',相反如果包含返回的值必定是-1"
            System.out.println("存在包含关系，因为返回的值不等于-1");
        } else {
            System.out.println("不存在包含关系，因为返回的值等于-1");
        }
    }
}
