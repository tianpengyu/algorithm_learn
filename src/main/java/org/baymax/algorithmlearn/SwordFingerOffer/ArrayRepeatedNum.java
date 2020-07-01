package org.baymax.algorithmlearn.SwordFingerOffer;

import java.util.*;

/**
 * 数组中 重复的数字
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/1 18:53
 */
public class ArrayRepeatedNum {
  public static Set<Integer> solution(int[] data){
    if (Objects.isNull(data) || data. length <= 1) {
      return Collections.emptySet();
    }

    // 1. 要先检查， 否则可能后面未检查的数据非法，会导致运行时报错
    check(data);

    Set<Integer> result = new HashSet<>();

    for(int cur = 0; cur <= data.length - 1; cur++) {
      while (data[cur] != cur) {
        // 这里是核心，需要多思考一下 这里的处理思想
        if (data[cur] == data[data[cur]]) {
          result.add(data[cur]);
          break;
        }
        exchange(data, cur, data[cur]);
      }
    }
    return result;
  }

  private static void check(int[] data) {
    for(int i = 0; i < data.length - 1; i++) {
      if (data[i] < 0 || data[i] >= data.length) {
        throw new RuntimeException("输入的数据中的每个数据都不可大于数据长度, data[" + i +"]=" + data[i]);
      }
    }
  }

  private static void exchange(int[] data, int cur, int datum) {
    int v = data[cur];
    data[cur] = data[datum];
    data[datum] = v;
  }

  public static void main(String[] args) {
    int[] data = {0,1,2,2,4,5,6,7,7,5};
    Set<Integer> set = solution(data);
    System.out.println(set);
    int[] data2 = {0,1};
    Set<Integer> set2 = solution(data2);
    System.out.println(set2);

  }
}
