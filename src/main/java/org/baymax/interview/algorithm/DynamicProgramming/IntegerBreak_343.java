package org.baymax.interview.algorithm.DynamicProgramming;

/**
 *
 * 没有头绪的时候，此时：
 *  暴力解法
 *
 *  枚举分割方案，但是由于分割成几分是未知，所以很难用循环的方式解决，因为不知道要用几重循环，遇到这种情况 通常要使用递归的方式
 *
 *  回溯的方法进行暴力遍历（O(2^n)）
 *
 *  在 距离暴力 回溯遍历时，如果发现了 重叠子问题 说明可以使用 记忆化搜索 和 动态规划的方式解决
 *
 *  新的概念： 最优子结构
 *
 *   通过 求子问题的最优解，可以获得原问题的最优解 （最优化问题）
 *
 *  知道了子问题的最优解，就能知道 原问题的最优解。
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/7 18:10
 */
public class IntegerBreak_343 {
  public int integerBreak(int n) {

    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 1;
    }

    // n >= 2
    int [] memo = new int [n+1];
    memo[1] = 1;
    memo[2] = 1;
    memo[3] = 2;

    for (int i = 4; i <= n; i++) {
      int max = 0;
      for (int j = 1; j <= i-1; j++) {
        int help = Math.max(j * (i - j), j * memo[i - j]);
        max = Math.max(max, help);
      }
      memo[i] = max;
    }

    return memo[n];
  }

  public static void main(String[] args) {
    int num = 10;
    IntegerBreak_343 demo = new IntegerBreak_343();
    System.out.println(demo.integerBreak(num));
  }
}
