package org.baymax.interview.algorithm.DynamicProgramming;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/7 17:22
 */
public class MinPathSum_64 {
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int m = grid.length;
    int n = grid[0].length;

    int [][] memo = new int [m][n];

    memo[0][0] = grid[0][0];

    for (int col = 1; col < n; col++) {
      memo[0][col] = memo[0][col - 1] + grid[0][col];
    }

    for (int row = 1; row < m; row++) {
      memo[row][0] = memo[row-1][0] + grid[row][0];
    }

    for (int row = 1; row < m; row ++) {
      for (int col = 1; col < n; col ++) {
        memo[row][col] = Math.min(memo[row-1][col], memo[row][col-1]) + grid[row][col];
      }
    }

    return memo[m-1][n-1];
  }
}
