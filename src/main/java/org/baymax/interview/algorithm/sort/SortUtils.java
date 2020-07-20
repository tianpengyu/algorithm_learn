package org.baymax.interview.algorithm.sort;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/6/30 17:48
 */
public class SortUtils {
  private static final int NEED_INSERT_LIMIT = 2;

  public static boolean smallerEnough(int left, int right) {
    return (right - left) <= NEED_INSERT_LIMIT;
  }
}
