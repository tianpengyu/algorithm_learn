package org.baymax.interview.algorithm.DynamicProgramming;

/**
 * 考虑 从[0 ... n-1] 偷房子🏠
 * nums[0] + [2 ... n-1]
 * num[1] + [3 ... n-1]
 * ...
 * nums[n-1] + []
 * <p>
 * 取最大值即可
 * <p>
 * 以前的一纬 都是 dp[n-1 是结果
 * <p>
 * 这样的定义时 应该是 dp[0] 是结果，那么初始化时应该从 dp[n-1] 开始
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/9 15:49
 */
public class Rob_198 {

  /**
   * 换一种
   * 状态定义：
   * 考虑 从 [0 ... i] 中偷
   *
   * @param nums
   * @return
   */
  public int rob2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int n = nums.length - 1;
    int[] dp = new int[n+1];

    dp[0] = nums[0];

    for (int i = 1; i <= n; i++) {
      int max = 0;
      for (int j = i; j >= 0; j--) {
        max = Math.max(max, nums[j] + (j - 2 >= 0 ? dp[j - 2] : 0));
      }
      dp[i] = max;
    }

    return dp[n];
  }


  /**
   * 用第一种状态定义
   * 考虑从 [i ... n-1] 房子偷
   *
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int n = nums.length - 1;

    // dp[i]: 表示 从 [0 ... i] 房子 偷取 时，偷取最大的价值
    // 0, 1, 2, ... n ( length - 1 )
    int[] dp = new int[nums.length];

    dp[n] = nums[n];

    for (int i = n - 1; i >= 0; i--) {
      int max = 0;
      for (int j = i; j <= n; j++) {
        max = Math.max(max, nums[j] + (j + 2 <= n ? dp[j + 2] : 0));
      }
      dp[i] = max;
    }

    return dp[0];
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 1};
    Rob_198 demo = new Rob_198();

    System.out.println(demo.rob2(nums));
  }
}
