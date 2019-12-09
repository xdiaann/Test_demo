package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author MR.Z
 * @Date 2019/10/31 1:13
 */
public class LinkedListAndArrayList {
    private static final int N = 50000;

    private static long timeList(List list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++)
            list.add(0, o);
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList耗时：" + timeList(new ArrayList()));
        System.out.println("LinkedList耗时：" + timeList(new LinkedList()));
    }


}
