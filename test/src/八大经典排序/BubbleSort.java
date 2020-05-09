package 八大经典排序;

import java.util.Arrays;

/**
 * @author MR.Z
 * @描述:
 * @date 2019/11/25 0:20
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrays = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        System.out.println("初始:" + Arrays.toString(arrays));

        bubble(arrays);
//        bubble2(arrays);

    }

    /**
     * 把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置….
     * 我们对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样一趟比较交换下来之后，排在最右的元素就会是最大的数。
     * 除去最右的元素，我们对剩余的元素做同样的工作，如此重复下去，直到排序完成。.
     * 1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序
     */
    private static void bubble(int[] arrays) {
        int a = 0;
        //总共要循环数组长度-1次
        //这里采用倒序的的原因是 好用于确定每次内循环的位置i<j(为什么是小于 因为从0开始) 比如第一次循环到j次 第二次循环到j-1次
        for (int j = arrays.length - 1; j > 0; j--) {
            System.out.println("第" + (++a) + "次");
            for (int i = 0; i < j; i++) {
                int current = arrays[i];
                int next = arrays[i + 1];
                if (current > next) {
                    arrays[i] = next;
                    arrays[i + 1] = current;
                    System.out.println(Arrays.toString(arrays));
                }
            }
        }
    }

    private static void bubble2(int[] arrays) {
        for (int j = 0; j < arrays.length - 1; j++) {
            System.out.println("第" + (j + 1) + "次");
            for (int i = 0; i < arrays.length - 1; i++) {
                int current = arrays[i];
                int next = arrays[i + 1];
                if (current > next) {
                    arrays[i] = next;
                    arrays[i + 1] = current;
                    System.out.println(Arrays.toString(arrays));
                }
            }
        }
    }


}
