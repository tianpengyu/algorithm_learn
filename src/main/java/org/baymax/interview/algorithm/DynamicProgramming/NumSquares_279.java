package org.baymax.interview.algorithm.DynamicProgramming;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/8 12:03
 */
public class NumSquares_279 {
  public int numSquares(int n) {

    int[] memo = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      int min = i;
      for (int j = 1; i - j * j >= 0; j++) {
        min = Math.min(min, memo[i - j * j] + 1);
      }
      memo[i] = min;
    }

    return memo[n];
  }

  public static void main(String[] args) {
    int n = 12;
    NumSquares_279 demo = new NumSquares_279() ;
    System.out.println(demo.numSquares(n));
  }
}
