package 八大经典排序;

import java.util.Arrays;

/**
 * @author MR.Z
 * @描述:
 * @date 2019/11/26 23:52
 */
public class SelectSort {

    /**
     * 首先，找到数组中最小的那个元素，其次，将它和数组的第一
     * 个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。其次
     * ，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，
     * 直到将整个数组排序。这种方法我们称之为选择排序。
     */
    //性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序
    public static void main(String[] args) {
//        int[] a = {3, 2, 1, 12, 3, 5, 57, 6, 4, 23, 4, 2, 6, 7};
        int[] a = {3, 2, 1};
//        System.out.println(Arrays.toString(selectSort(a)));

        System.out.println(Arrays.toString(mySelectSort(a)));
    }


    private static int[] mySelectSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {//length-1 要与后一个比较
            int min = i;
            for (int j = i; j < length - 1; j++) {
                //如果当前后一个小于前一个  则记录最小的是第几个
                if (a[j] > a[j + 1]) {
                    min = a[j + 1];
                }
            }
            //交换
            int temp = a[i] = min;//将最小的数给当前要交换的位置  第一次就是给第一位
            System.out.println(min);
        }
        return a;
    }


    private static int[] selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) min = j;
            }
            //交换
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }
}

