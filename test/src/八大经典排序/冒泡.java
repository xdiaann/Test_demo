package 八大经典排序;

import java.util.Arrays;

/**
 * @author MR.Z
 * @描述:
 * @date 2019/11/25 0:20
 */
public class 冒泡 {
    public static void main(String[] args) {
        int[] arrays = {6, 5, 1, 3, 4};
        int length = arrays.length;
        int temp;
        for (int i = 0; i < arrays.length; i++) {
            if (i == length-1) {
                break;
            }
            int arrayI1 = arrays[i + 1];
            int arrayI = arrays[i];
            if (arrayI > arrayI1) {
                arrays[i] = arrayI1;
                arrays[i + 1] = arrayI;
                System.out.println(Arrays.toString(arrays));
            }
        }
    }
}
