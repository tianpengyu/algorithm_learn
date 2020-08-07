package org.baymax.interview.algorithm.recursion;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/7 10:02
 */
public class NumIslands_200 {

  private int[][] directions = {
      {-1, 0},
      {0, 1},
      {1, 0},
      {0, -1}
  };

  private boolean[][] visited;
  private int maxX;
  private int maxY;

  private final char water = '0';

  private int res;


  public int numIslands(char[][] grid) {

    res = 0;

    if (grid == null || grid.length == 0) {
      return res;
    }

    maxX = grid.length;
    maxY = grid[0].length;

    visited = new boolean[maxX][maxY];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] != water && !visited[i][j]) {
          res++;
          bloodFill(grid, i, j);
        }
      }
    }

    return res;
  }

  /**
   * 第一次写的时候 卡在 什么时候 统计岛数！！！
   * <p>
   * 在 [x, y]  处开始 bloodFill,
   *
   * @param grid
   * @param x
   * @param y
   * @return
   */
  private void bloodFill(char[][] grid, int x, int y) {
    if (grid[x][y] == water) {
      return;
    }

    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {

      int newX = x + directions[i][0];
      int newY = y + directions[i][1];

      if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] != water) {
        bloodFill(grid, newX, newY);
      }

    }

  }

  private boolean inArea(int newX, int newY) {
    return newX >= 0 && newX < maxX && newY >= 0 && newY < maxY;
  }


  public static void main(String[] args) {
    char [][] grids = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

    NumIslands_200 demo = new NumIslands_200();
    System.out.println(demo.numIslands(grids));
  }


}
