package org.baymax.interview.algorithm.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定点 list 返回 与 i 举例相同的 j , k 的个数
 *
 *     Map<Integer, Integer> countMapByDistant = new HashMap<>();从 for 移出来 就提升了很多速度，看来 for 里 new 对象很耗时
 *
 *     提升了 70 毫秒
 *
 * 使用查找表
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/24 11:12
 */
public class NumberOfBoomerangs_447 {
  public int numberOfBoomerangs(int[][] points) {

    int result = 0;
    Map<Integer, Integer> countMapByDistant = new HashMap<>();

    for (int i = 0; i <= points.length - 1; i++) {


      int[] curPoint = points[i];

      for (int j = 0; j <= points.length - 1; j++) {

        if (j == i) {
          continue;
        }

        Integer distant = calDistance(curPoint, points[j]);
        Integer count = countMapByDistant.computeIfAbsent(distant, k -> new Integer(0));
        countMapByDistant.put(distant, ++count);

      }

      for (Map.Entry<Integer, Integer> entry : countMapByDistant.entrySet()) {
        result += entry.getValue() * (entry.getValue() - 1);
      }

      countMapByDistant.clear();
    }

    return result;

  }

  private Integer calDistance(int[] curPoint, int[] targetPoint) {
    return (int)Math.pow(curPoint[0] - targetPoint[0], 2) + (int)Math.pow(curPoint[1] - targetPoint[1], 2);
  }

  public static void main(String[] args) {
    int[][] points = {{0,0},{1,0},{2,0}};

    NumberOfBoomerangs_447 demo = new NumberOfBoomerangs_447();
    int result = demo.numberOfBoomerangs(points);
    System.out.println(result);
  }
}
