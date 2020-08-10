package org.baymax.interview.algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * 经典的 0 - 1 背包问题
 *
 * 1. 经典递归
 * 2. 记忆化搜索
 * 3. 动态规划
 * 4. 动态规划 的 空间优化 1
 * 5. 动态规划 的 空间优化 2 ： 只用一行 memo : 新的一行 从右向左刷新这一行的值 ： dp 2
 *
 * 画表格时，当前行只依赖上一行的数据，理论上只保存 两行数据即可
 *
 * 别的地方不变，因为只有两行，根据奇偶 映射以下即可：
 *
 * i ==> i % 2
 * 行 ==> 行 % 2
 *
 * 0 - 1背包变种：
 * 1。完全背包：物品可以无限使用，转为有限使用；二进制妈表示每个数
 * 2。多重背包，个数有限
 * 3。多维费用，体积容量和重量容量
 * 4。物品之间有排斥约束 或 物品之间有依赖约束
 *
 * leetcode 上 面试过程中 0-1背包问题如何考察：
 *
 * 416
 *
 *
 *
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/10 10:17
 */
public class ZeroOneBackpack {

  private final int initValue = -1;

  private int [][] memo;

  public int solution_1_recursion(int [] weights, int [] values, int capacity) {

    if (weights == null || weights.length == 0) {
      return 0;
    }

    if (values == null || values.length == 0) {
      return 0;
    }

    if (capacity <= 0) {
      return 0;
    }


    int n = weights.length;

    memo = new int [2][capacity + 1]; // x * (capacity+1)
    for (int row = 0; row < memo.length; row++) {
      Arrays.fill(memo[row], initValue);
    }

    return recursion(weights, values, n-1, capacity);
  }


  private int dp2 (int [] weights, int[] values, int capacity) {
    if (weights == null || weights.length == 0) {
      return 0;
    }

    if (values == null || values.length == 0) {
      return 0;
    }

    if (capacity <= 0) {
      return 0;
    }

    if (weights.length != values.length) {
      return 0;
    }

    int n = weights.length;

    int [] dp = new int [capacity + 1];

    for (int i = 1; i <= capacity; i++) {
      if (weights[0] <= capacity) {
        dp[i] = values[0];
      }
    }

    for (int i = 1; i < n; i++) {

      for (int j = capacity; j >= weights[i] || j >= 0; j--) {
        dp[j] = Math.max(
            dp[j],
            dp[j - weights[i]] + values[i]
        );
      }

    }

    return dp[capacity];
  }


  private int dp(int[] weights, int[] values, int index, int capacity) {
    if (index < 0 || capacity <= 0) {
      return 0;
    }

    memo = new int [2][capacity + 1];

    for (int col = 1; col <= capacity; col++) {
      if (col >= weights[0]) {
        memo[0][col] = values[0];
      } else {
        memo[0][col] = 0;
      }
    }

    for (int row = 1; row <= index; row++) {

      for (int col = 1; col <= capacity; col++) {
        int max = 0;
        if (col - weights[row] >= 0) {
          max = memo[(row - 1) % 2][col - weights[row]] + values[row];
        }
        max = Math.max(
            max,
            memo[(row-1) % 2][col]
        );

        memo[row % 2][col] = max;
      }

    }

    return memo[index % 2][capacity];
  }

  /**
   * 考虑 从 (索引) [0 ... index] 的物品中 拿出来最大的价值
   *
   * 递归结构应该是：
   * 1. 不考虑 index, [0 ... index - 1], capacity
   * 2. 考虑 index, [0 ... index - 1] + values[index], capacity - weights[index] ; 注意背包能否放入 index 的物品
   *
   * 从 1 和 2 中选取一个最大值
   *
   * capacity 和 index 构成了数据对，这样的数据对在求解过程中，同样的数据对可能求解多次 所以 可以用记忆化搜索的方式进行优化
   *
   * 加入 memo [][] = new int [n][capacity + 1]
   * 1. 初始化 memo
   * 2. 如果当前 (index, capacity)数据对 计算过了 那么直接返回
   * 3. 没有计算则计算，然后保存一下
   *
   * ｜ id  |  0   |   1   |   2   |
   *  weight|   1  |   2   |   3   |
   *  value |   6  |   10  |   12  |
   *
   *
   *
   * @param weights 物品重量
   * @param values 物品价值
   * @param index 物品在 weights（values）中的索引
   * @param capacity 被容容量 对应 物品重量
   * @return 最大价值
   */
  private int recursion(int[] weights, int[] values, int index, int capacity) {

    if (capacity <= 0 || index < 0) {
      return 0;
    }

    if (memo[index][capacity] != initValue) {
      return memo[index][capacity];
    }

    // 1. 不考虑 index 处的 物品
    int max = recursion(weights, values, index - 1, capacity);

    if (capacity >= weights[index]) {
      max = Math.max(
          max,
          recursion(weights, values, index - 1, capacity - weights[index]) + values[index]
      );
    }

    memo[index][capacity] = max;
    return max;
  }


  public static void main(String[] args) {
    int  [][] m = new int [2][3];
    for (int row = 0; row < m.length; row++) {
      Arrays.fill(m[row], -1);

    }
    System.out.println("end");
  }




}
