package org.baymax.interview.algorithm.recursion;

/**
 * 上 右 下 左
 * <p>
 * maxY
 * /\
 * |
 * |
 * |
 * (0,0) -------> maxX
 *
 * 小结：
 * 1. 根据输入 定义 x 和 y 以及 上下左右
 * 2. 明确递归函数的 含义：1) 退出条件：应该是在最后一位字符的判断 而不是 进来任意位置 就判断：2） 利用递归返回值 构造递归逻辑： 本次匹配失败直接返回 false 如果后续递归返回 true 本次才可以返回 true 否在会退出 for 并返回 false
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/6 17:00
 */
public class WordSearch_79 {
  // x,y 根据题中的输入 定义
  private int[][] directions = {
      {-1, 0},
      {0, 1},
      {1, 0},
      {0, -1}
  };

  private int maxX;
  private int maxY;

  private boolean[][] visited;

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0) {
      return false;
    }

    maxX = board.length;
    maxY = board[0].length;

    visited = new boolean[maxX][maxY];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (searchWord(board, word, i, j, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * 从 board[x][y] 开始 寻找 word
   *
   * @param board
   * @param word
   * @param x
   * @param y
   * @param index
   * @return
   */
  private boolean searchWord(char[][] board, String word, int x, int y, int index) {
    if (index == word.length() - 1) {
      return board[x][y] == word.charAt(index);
    }

    if (board[x][y] == word.charAt(index)) {

      visited[x][y] = true;

      for (int i = 0; i < 4; i++) {
        int newX = x + directions[i][0];
        int newY = y + directions[i][1];

        if (inArea(newX, newY) && !visited[newX][newY] && searchWord(board, word, newX, newY, index + 1)) {
          // 本次 search word 成功 向父级返回
          return true;
        }
      }

      visited[x][y] = false;
    }

    return false;
  }

  private boolean inArea(int nextX, int nextY) {
    return nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY;
  }

  public static void main(String[] args) {
    char[] [] cs = {
        {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
    };
    String word = "ABCCED";

    WordSearch_79 demo = new WordSearch_79();

    System.out.println(demo.exist(cs, word));

  }
}
