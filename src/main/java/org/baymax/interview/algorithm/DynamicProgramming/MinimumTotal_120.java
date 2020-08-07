package org.baymax.interview.algorithm.DynamicProgramming;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/7 16:07
 */
public class MinimumTotal_120 {

  public int minimumTotal(List<List<Integer>> triangle) {

    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int[][] memo = new int[triangle.size()][];
    for (int i = 0; i < triangle.size(); i++) {
      memo[i] = new int [i+1];
    }

    memo[0][0] = triangle.get(0).get(0);

    for (int row = 1; row < triangle.size(); row++) {
      for (int col = 0; col < triangle.get(row).size(); col++) {

        if (col == 0) {
          memo[row][col] = memo[row - 1][col] + triangle.get(row).get(col);
          continue;
        }

        if (col > row - 1) {
          memo[row][col] = memo[row - 1][row - 1] + triangle.get(row).get(col);
          continue;
        }

        memo[row][col] = Math.min(memo[row - 1][col], memo[row - 1][col - 1]) + triangle.get(row).get(col);

      }
    }

    int lastRow = triangle.size() - 1;
    int colNum = memo[lastRow].length;
    int min = memo[lastRow][0];

    for (int j = 1; j < colNum; j++) {
      min = Math.min(min, memo[lastRow][j]);
    }
    return min;
  }


//  private int minRes = Integer.MAX_VALUE;
//  public int minimumTotal(List<List<Integer>> triangle) {
//    if (triangle == null || triangle.size() == 0) {
//      return 0;
//    }
//
//    traceBack(triangle, 0, 0, 0);
//
//    return minRes;
//  }
//
//  private void traceBack(List<List<Integer>> triangle, int row, int col, int sum) {
//    if (row == triangle.size()) {
//      minRes = Math.min(minRes, sum);
//      return;
//    }
//
//    traceBack(triangle, row + 1, col, sum + triangle.get(row).get(col) );
//    traceBack(triangle, row + 1, col + 1, sum + triangle.get(row).get(col) );
//  }

  public static void main(String[] args) {
//    [[2],[3,4],[6,5,7],[4,1,8,3]]

    List<List<Integer>> triangle = new ArrayList<>();
    List<Integer> l1 = Lists.newArrayList(2);
    List<Integer> l2 = Lists.newArrayList(3, 4);
    List<Integer> l3 = Lists.newArrayList(6, 5, 4);
    List<Integer> l4 = Lists.newArrayList(4, 1, 8, 3);

    triangle.add(l1);
    triangle.add(l2);
    triangle.add(l3);
    triangle.add(l4);

    MinimumTotal_120 demo = new MinimumTotal_120();
    System.out.println(demo.minimumTotal(triangle));
  }
}
