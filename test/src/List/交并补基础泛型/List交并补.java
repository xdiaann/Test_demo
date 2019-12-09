package List.交并补基础泛型;

import java.util.ArrayList;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-03 09:32
 */
public class List交并补 {

    public static void main(String[] args) {
        ArrayList<Integer> list123 = new ArrayList<Integer>();
        ArrayList<Integer> list34 = new ArrayList<Integer>();
        list123.add(1);list123.add(2);list123.add(3);
        list34.add(3);list34.add(4);
        list123.retainAll(list34);
        //3
        System.out.println("list123∩list34="+list123);

        ArrayList<Integer> listRemove123 = new ArrayList<Integer>();
        ArrayList<Integer> listRemove34 = new ArrayList<Integer>();
        listRemove123.add(1);listRemove123.add(2);listRemove123.add(3);
        listRemove34.add(3);listRemove34.add(4);
        listRemove123.removeAll(listRemove34);
        //1  2
        System.out.println("┐listRemove34（对于listRemove123）="+listRemove123);

        ArrayList<Integer> listBing123 = new ArrayList<Integer>();
        ArrayList<Integer> listBing34 = new ArrayList<Integer>();
        listBing123.add(1);listBing123.add(2);listBing123.add(3);
        listBing34.add(3);listBing34.add(4);
        //[1, 2, 3, 4, 5]
        System.out.println("listBing123∪listBing34="+new ArraylistCalculate().integerArrayListUnion(listBing123, listBing34));
    }
}
