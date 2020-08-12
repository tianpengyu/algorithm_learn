package org.baymax.interview.algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * 思路 还是 要先转换到 198 问题上
 *
 * n 个房子的编号：1，2，3，。。。。，n
 *
 * 由于存在循环，也就是，偷了 1号 不可以偷 n ，反之, 偷了 n 也不可以偷1
 * 转换一下
 * 1 到 n 分成2排
 * 第一排：1 ..... n - 1 ;
 * 第二排：  2 ...... n ;
 *
 * 对于第一排： n 号房子 绝对不偷
 * 对于第二排： 1 号房子 绝对不偷
 *
 * 这样 取两种结果的最大值 就可以了 ， 1 和 n 都不偷的情况 肯定是 小于等于 其中的 某一种
 *
 * 那么 本题的解答就迎刃而解了
 * 1. 拆分
 * 2. 分别用 198 的方法解答
 * 3. 取最大值
 *
 *
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/9 16:56
 */
public class Rob2_213 {
  public int rob(int[] nums) {
   if (nums == null || nums.length == 0) {
     return 0;
   }
   if (nums.length == 1) {
     return nums[0];
   }

   return Math.max(
       robForNoCircle(Arrays.copyOfRange(nums, 0, nums.length-1)),
       robForNoCircle(Arrays.copyOfRange(nums, 1, nums.length))
   );
  }

  private int robForNoCircle(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int [] dp = new int [nums.length];

    dp[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int max = 0;

      for (int j = i; j >= 0; j--) {
        max = Math.max(max, nums[j] + (j - 2 >= 0 ? dp[j-2] : 0) );
      }

      dp[i] = max;
    }

    return dp[nums.length-1];
  }

  public static void main(String[] args) {
    int [] nums = {2,3,2};

    Rob2_213 demo = new Rob2_213();
    System.out.println(demo.rob(nums));

  }
}
