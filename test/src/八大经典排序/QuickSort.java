package 八大经典排序;

/**
 * @author MR.Z
 * @date 2020/3/15 21:30
 */
public class QuickSort {
    /**
     * 从数组中选择一个元素，把这个元素称之为中轴元素，然后把数组中所有小于中轴元素的元素放在其左边，
     * 所有大于或等于中轴元素的元素放在其右边，显然，此时中轴元素所处的位置的是有序的。也就是说，我们无需再移动中轴元素的位置。
     *
     * 从中轴元素那里开始把大的数组切割成两个小的数组(两个数组都不包含中轴元素)，接着我们通过递归的方式，
     * 让中轴元素左边的数组和右边的数组也重复同样的操作，直到数组的大小为1，此时每个元素都处于有序的位置。
     *
     * 性质：1、时间复杂度：O(nlogn) 2、空间复杂度：O(logn) 3、非稳定排序 4、原地排序
     */
    private static int count;

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        System.out.println(arrayToString(num, "排序前"));
        quickSort(num, 0, num.length - 1);
        System.out.println(arrayToString(num, "排序后"));
        System.out.println("数组个数：" + num.length);
        System.out.println("循环次数：" + count);
    }

    private static int[] myQuickSort( int[] num ) {
        int left = 0;
        int right = num.length-1;
        if (left == right) {
            return num;
        }
        for (int i : num) {

        }

        return null;
    }





































    /**
     * 快速排序
     *
     * @param num   排序的数组
     * @param left  数组的前针
     * @param right 数组后针
     */
    private static void quickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;
        count++;
        quickSort(num, left, i - 1);
        quickSort(num, i + 1, right);
    }

    /**
     * 将一个int类型数组转化为字符串
     *
     * @param arr
     * @param flag
     * @return
     */
    private static String arrayToString(int[] arr, String flag) {
        String str = "数组为(" + flag + ")：";
        for (int a : arr) {
            str += a + "\t";
        }
        return str;
    }

}
