package org.baymax.interview.algorithm.Array;

/**
 * 找出 两个 数之和 等于目标值
 * 条件：数组已经有序
 *
 * 解法1： 暴力法 O(n^2) 没有利用条件：有序
 * 解法2： 第二层遍历用二分搜索 （因为是有序的 所以可以用二分搜索）；时间复杂度：O(n * logn)
 *
 * 思维闪光点：
 * 1. 两个数字和 ， 意味着 两个索引
 *
 * 主要解法：对撞指针的思维
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/20 11:34
 */
public class TwoSum2_167 {

  /**
   * 题目已经告诉 可以假设 一定有解
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum(int[] numbers, int target) {
    int l = 0;
    int r = numbers.length - 1;
    int [] result = new int[2];

    while (l < r) { // 不可以用重复的

      if(numbers[l] + numbers[r] == target) {
        result[0] = l;
        result[1] = r;
        return result;
      }else if(numbers[l] + numbers[r] > target) {
        r--;
      } else {
        l++;
      }
    }

    return result;
  }

}
