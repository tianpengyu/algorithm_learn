package org.baymax.interview.algorithm.Array;

/**
 * 条件：
 *  1. 都是正数
 *
 * 目标是找到 子数组，并且子数组满足一定条件
 * 形式上来看是： arr[i ... j]  为了要找到这个可以用暴力搜索法
 * 那么几重循环呢？ 两重 一个 是 i 一个是 j ，用两次遍历分别找到 i 和 j
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/20 13:20
 */
public class MinimumSizeSubarraySum_209 {

  /**
   * 计算 nums[l ... r] 这个子数组的 和 sum 看 sum 和 s 的关系
   * 因为都是正数所以逻辑简单一点
   * @param s
   * @param nums
   * @return
   */
  public int minSubArrayLen(int s, int[] nums) {

    int l = 0;
    int r = -1;
    int size = nums.length + 1;
    int sum = 0;

    while ( l < nums.length - 1) {
// TODO tianpengyu 2020/7/20 : 这里可以优化一下
      if ( r+1 < nums.length &&  sum < s) {
        sum += nums[++r];
      } else {
        sum -= nums[l++]; // ++ l 不越界在 while 中 保证了; 这里要先减去值 然后在移动下标
      }

      if (sum >= s) {
        size = Math.min(size, r - l + 1);
      }

    }

    if (size == nums.length + 1) {
      return 0;
    }

    return size;
  }
}
