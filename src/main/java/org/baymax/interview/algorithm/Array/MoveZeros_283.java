package org.baymax.interview.algorithm.Array;

/**
 * [0, 1, 0, 2, 3] -> [1, 2, 3, 0, 0]
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/20 10:04
 */
public class MoveZeros_283 {

  public void moveZeroes(int[] nums) {


  }

  /**
   * 解法1：
   *  简单的思想 通过不断遍历数据，每次遍历
   *  1. 找出非零 并保存在新的数组中
   *  2. 赋值回原来的数组，并把剩下的非零元素 设置为0
   * @param nums
   */
  public void solution1(int[] nums) {

  }


  /**
   * 解法2：
   *  从 正确的结果开始思考 循环不变式：
   *  1. [1,2,3,0,0] ---> [0 ... k) 是非零元素
   *  2. [k ... n - 1] 全是零
   *
   *  实现时 出现的问题：
   *  1. 非零判断写成 > 0 了，没有考虑负数的情况
   *
   *
   *  优化：
   *  1. 遍历时 直接交换 可以省调
   *     for (; firstZero <= nums.length - 1; firstZero++) {
   *       nums[firstZero] = 0;
   *     }
   *
   *  2. 交换时，如果 firstZero != cur 那么就没比较交换，相等时意味着自己和自己交换
   *
   */
  public void solution2(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int firstZero = 0;
    for (int cur = 0; cur <= nums.length - 1; cur++) {
      if (nums[cur] != 0) {
        // 特殊的测试用例
        if (firstZero != cur) {
          exchange(nums, firstZero++, cur);
        } else {
          firstZero++;
        }
      }
    }
  }

  private void exchange(int[] nums, int left, int right) {
    int helper = nums[left];
    nums[left] = nums[right];
    nums[right] = helper;
  }

}
