package List.ab;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-01 14:29
 */
public class test {
    public static void main(String[] args) {
        B b = new B();
        b.setA("a");
        b.setB("b");
        System.out.println(b);  //  B{a='a', b='b'}

        A a = new A();
        List<B> bList =new LinkedList<B>();
        bList.add(b);
        System.out.println(bList); //  [B{a='a', b='b'}]

        a.setbList(bList);
        System.out.println(a.getbList());//  [B{a='a', b='b'}]

        

    }
}
