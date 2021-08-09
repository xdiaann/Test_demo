package 尚硅谷面试;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 给定一个整数数级nums和一个目标值 target，
// 请你在该数组中找出和为目标值的那两个整数，
// 并返回他们的数组下标。你可以假设每种输入只
// 会对应一个答案。但是，数组中同一个元素不能
// 重复出现。
//*示例:
//给定nums = [2，7，11，15], target = 9米
//因为nums[ o] + nums[ 1] =2 +7 = 9*
//*所以返回[o，1]*/
public class TwoNumberSums {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3}; //2+7=9
        int target = 6;

        int[] ints = twoSum1(nums, target);
        System.out.println(Arrays.toString(ints));
        int[] ints2 = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints2));
    }

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);

        }
        return null;
    }
}