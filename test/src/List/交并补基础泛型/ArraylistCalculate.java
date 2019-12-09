package List.交并补基础泛型;

import java.util.*;

class ArraylistCalculate{
    // 两个整数集求并集
    ArrayList<Integer> integerArrayListUnion(
            ArrayList<Integer> arraylist1, ArrayList<Integer> arraylist2) {
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        arraylist.addAll(arraylist1);
        arraylist.addAll(arraylist2);
        arraylist = new ArrayList<Integer>(new HashSet<Integer>(arraylist));
        return arraylist;
    }

}

