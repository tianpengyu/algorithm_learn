package org.baymax.algorithmlearn.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;


/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/6/30 17:42
 */
public class QuickSort {
  private static final Random random = new Random();
  public static void sort(int[] data) {
    if (Objects.isNull(data) || data.length <= 1) {
      return;
    }
    quickSort(data, 0, data.length-1);
  }

  /**
   * 循环不变式
   * 1. data[left ... l)  < e
   * 2. data[r ... right] > e
   * 3. data[l ... m] == e
   * 4. data[i] 正在处理，i = m + 1
   * @param data
   * @param left
   * @param right
   * @return
   */
  private static void quickSort(int[] data, int left, int right) {
    if (SortUtils.smallerEnough(left, right)) {
      InsertSort.sort(data, left, right);
      return;
    }

    // partition
    // 1. random
    int pivotIndex = random.nextInt(right - left) + left;
    exchange(data, left , pivotIndex);

    int l = left;
    int r = right + 1;
    int e = data[left];
    int m = l;
    int cur = left + 1;

    // 2. 3-ways quickSort
    while (cur < r) {
      if (data[cur] == e) {
        cur++;
        m++;
      } else if (data[cur] < e) {
        exchange(data, ++l, cur++);
        m++;
      } else {
        exchange(data, cur, --r);
      }
    }
    // don't forget this ， 注意 l 含义
    exchange(data, left, l);

    quickSort(data, left, l - 1);
    quickSort(data, r, right);
  }

  private static void exchange(int[] data, int left, int right) {
    int value = data[left];
    data[left] = data[right];
    data[right] = value;
  }

  public static void main(String[] args) {
    int[] data = {5, 2, 1, 8, 1, 0};
    System.out.println("before:" + Arrays.toString(data));
    sort(data);
    System.out.println("after:" + Arrays.toString(data));
  }
}
