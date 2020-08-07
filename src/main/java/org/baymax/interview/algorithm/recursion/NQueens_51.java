package org.baymax.interview.algorithm.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * [x, y]
 * [ 0,0  0,1  0,2  0,3  0,4  0,5 ]
 * [ 1,0  1,1  1,2  1,3  1,4  1,5 ]
 * [ 2,0  2,1  2,2  2,3  2,4  2,5 ]
 * [ 3,0  3,1  3,2  3,3  3,4  3,5 ]
 * [ 4,0  4,1  4,2  4,3  4,4  4,5 ]
 * [ 5,0  5,1  5,2  5,3  5,4  5,5 ]
 * <p>
 * n = 6
 * 同一行 row: x == row
 * 同一列 col: y == col
 * 左上-右下 对角线 i : x - y ⍷ {i | -5, -4, ..., 5 } 因为要用下标 所以 改成非负数 0, 1, ..., 2 * ( n - 1)  (整体 + n - 1)
 * 右上-左下 对角线 j : x + y ⍷ {i | 0 , 1, ..., 2 * ( n - 1 ) }
 * <p>
 * rows[n]
 * cols[n]
 * left2RightDiagonals[2 * n - 1]
 * right2LeftDiagonals[2 * n - 1]
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/7 12:14
 */
public class NQueens_51 {
  private List<List<String>> res;

  private boolean[] cols;
  private boolean[] left2RightDiagonals;
  private boolean[] right2LeftDiagonals;

  private String template;

  private String queen = "Q";


  public List<List<String>> solveNQueens(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      sb.append(".");
    }

    template = sb.toString();

    res = new ArrayList<>();

    cols = new boolean[n];
    left2RightDiagonals = new boolean[2 * n - 1];
    right2LeftDiagonals = new boolean[2 * n - 1];


    Deque<Integer> processed = new ArrayDeque<>();

    putQueens(n, processed, 0);

    return res;
  }

  /**
   * 在 n 皇后问题中，尝试在 第 row 行 摆放 一个 皇后，使得在当前行摆放后，满足规则
   *
   * @param n
   * @param processed
   * @param row
   */
  private void putQueens(int n, Deque<Integer> processed, int row) {
    if (row == n) {
      res.add(generate(new ArrayList<>(processed)));
      return;
    }

    for (int col = 0; col < n; col++) {
      if (otherPositionHasAQueen(row, col, n)) {
        continue;
      }

      cols[col] = true;
      left2RightDiagonals[row - col + n - 1] = true;
      right2LeftDiagonals[row + col] = true;

      processed.addLast(col);

      putQueens(n, processed, row + 1);

      processed.removeLast();

      right2LeftDiagonals[row + col] = false;
      left2RightDiagonals[row - col + n - 1] = false;
      cols[col] = false;
    }
  }

  private boolean otherPositionHasAQueen(int row, int col, int n) {
    return cols[col] || left2RightDiagonals[row - col + n - 1] || right2LeftDiagonals[row + col];
  }

  private List<String> generate(ArrayList<Integer> processed) {
    List<String> oneSolution = new ArrayList<>(processed.size());
    for (int row = 0; row < processed.size(); row++) {
      StringBuilder sb = new StringBuilder(template);
      oneSolution.add(sb.replace(processed.get(row), processed.get(row) + 1, queen).toString());
    }
    return oneSolution;
  }

//  public static void main(String[] args) {
//    int num = 4;
//    NQueens demo = new NQueens();
//    System.out.println(demo.solveNQueens(num));
//  }


}
