package leetcode;


/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class 最大子数组和 {

    //on3
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        int length = nums.length;
        //思路 如果长度为1 则直接返回
        if (length == 1) {
            return nums[0];
        }
        //[5,4,-1,-2]
        // 5  5+4  5+4-1 5+4-1-2
        // 4  4-1  4-1-2
        // -1 -1-2
        // -2
        //暴力算法  遍历3次
        // 第一次循环控制总次数  以数组长度为准
        // 第二次循环控制当前循环的长度 如leng=4  i=1  那么第二次就循环3次
        //外
        //中
        //内: i1j1k1
        //中
        //内: i1j2k1
        //内: i1j2k2
        //中
        //内: i1j3k1
        //内: i1j3k2
        //内: i1j3k3
        // 第三次循环控制控制内部每个元素相加的结果 如注释0
        for (int i = 0; i < length; i++) {
//         0  int i = nums[0];
//            int i1 = nums[0] + nums[1];
//            int i2 = nums[0] + nums[1] + nums[2];
//            int i3 = nums[0] + nums[1] + nums[2] + nums[3];

            System.out.println("外");
            for (int j = i; j < length; j++) {
                System.out.println("中");
                int a = 0;
                //1 因为k<=j 所以循环为 i0j0k0 i0j1k0 i0j1k1 i0j2k0 i0j2k1 i0j2k2 i0j3k0 i0j3k1 i0j3k2 i0j3k3 i1j1k1 i1j2k1...
                //内循环
                for (int k = i; k <= j; k++) {
                    System.out.println("内: i" + i + "j" + j + "k" + k);
                    //2 这一步是为了把 当前循环累加 如i0j3k0 i0j3k1 i0j3k2 i0j3k3
                    a = a + nums[k];
//                    System.out.println("nums[k]: "+nums[k]);
//                    System.out.println("当前内最大: "+a);
                }
                //3 累加完了 就和之前的每一次数组比较  第0步的注释
                max = Math.max(a, max);
//                System.out.println("中: "+max);
            }
        }
        System.out.println(max);
        return max;
    }


    //on2  推荐 自己写的 更合理
    //第一次循环  内循环4次
    //第二次循环  内循环3次 以此类推 每次内循环的时候累加比较 如第一次内循环4次 i0j0 i0j1 i0j2 i0j3 每次内循环就拿当前累加后的数和最大值比
    //因为每次内循环都会pre += nums[j]; 即 第一次 i0j0 是5  第二次 i0j1 就是 即5+4
    static int maxSubArray2(int[] nums) {
        //[5,4,-1,-2]
        // 5  5+4  5+4-1 5+4-1-2
        // 4  4-1  4-1-2
        // -1 -1-2
        // -2
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            System.out.println("外");
            int pre = 0;
            for (int j = i; j < length; j++) {

                pre += nums[j];
                if (max < pre) {
                    max = pre;
                }
                System.out.println("内: i" + i + "j" + j);
            }

        }
        return max;
    }

    //动态规划? 有点东西 还需要强化思路
    public static int maxSubArray3(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                //2 sum>0 sun=9
                //3 sun>0 sun=8
                //4 sun>0 sun=6
                sum += num;
                //当前sum值小于0，不管num是正数还是负数，sum+num都会减小，所以sum<0时，更新sum=num使sum更大
                //如果数组都是负数 那么每次都会刷新该值 然后max比较 所以也没问题
            } else {
                //1. sun<0 sun=5
                sum = num;
            }
            // 1.1 ans =5  2.1 ans=9  3.1 =9 4.1 =9
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {-5, 6, -9,66, -2};
        int i = maxSubArray3(nums);
        System.out.println(i);
    }
}
