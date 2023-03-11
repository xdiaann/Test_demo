package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 */
public class 重复元素 {
    //n2
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i] == nums[i1]) {
                    return true;
                }
            }
        }
        return false;
    }
    //nlogn
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
    //n
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            //出现相同的返回ture set不重复的特性 当add到重复的 则返回flase 取反 返回ture 进入if
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 273, 274, 275, 276, 277};
        boolean b = containsDuplicate1(nums);
        System.out.println(b);

    }

}
