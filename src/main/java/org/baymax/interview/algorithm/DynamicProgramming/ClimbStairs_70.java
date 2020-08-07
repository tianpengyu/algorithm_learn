package org.baymax.interview.algorithm.DynamicProgramming;

/**
 * 每次 可以 爬一阶 或 爬两阶
 * 所以 n 的数量 f(n) = f(n-1) + f(n-2)
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/7 15:02
 */
public class ClimbStairs_70 {

  public int climbStairs(int n) {
    if (n <= 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    int [] memo = new int[n+1];

    memo[1] = 1;
    memo[2] = 2;

    for (int i = 3; i <= n; i++) {
      memo[i] = memo[i-1] + memo[i-2];
    }

    return memo[n];
  }
}
