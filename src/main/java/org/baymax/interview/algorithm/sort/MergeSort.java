package org.baymax.interview.algorithm.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 1. 小数据量时，数组近乎有序。对于近乎有序的数组， insert sort 可以达到 O(n) 的时间复杂度
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/6/30 14:19
 */
public class MergeSort {

  private static final int NEED_INSERT_LIMIT = 2;

  public static void sort(int[] data) {
    if (Objects.isNull(data) || data.length <= 1) {
      return;
    }
    mergeSort(data, 0, data.length - 1);
  }

  /**
   * 对 data[left ... right] 左闭右闭 进行排序
   *
   * @param data
   * @param left
   * @param right
   */
  private static void mergeSort(int[] data, int left, int right) {
    if (SortUtils.smallerEnough(left, right)) {
      InsertSort.sort(data, left, right);
      return;
    }


    int rightIndex = data.length - 1;
    int mid = left + ((rightIndex - left) / 2); // binarySearch bug

    mergeSort(data, left, mid);
    mergeSort(data, mid + 1, rightIndex);
    merge(data, left, mid, rightIndex);
  }

  /**
   * 对 data[l ... mid] 和 data[r ... right] 进行 merge
   * 当前要比较的 是 data[l] 和 data[r]
   *
   * @param data
   * @param left
   * @param mid
   * @param right
   */
  private static void merge(int[] data, int left, int mid, int right) {
    if (left >= right) {
      return;
    }
    int l = left;
    int r = mid + 1;

    int length = right - left + 1;
    int[] aux = new int[length];
    int cur = 0;

    // 注意⚠️ 当时卡在 这三个 while 的执行顺序了 ： 把这三个 while 放在一个 for 里了，导致总会越界
    while (l <= mid && r <= right) {
      if (data[l] <= data[r]) {
        aux[cur++] = data[l++];
      } else {
        aux[cur++] = data[r++];
      }
    }

    while(l > mid && r <= right) {
      aux[cur++] = data[r++];
    }

    while(r > right && l <= mid) {
      aux[cur++] = data[l++];
    }

    for (int i = 0; i <= aux.length - 1; i++) {
      data[left + i] = aux[i];
    }
  }

  public static void main(String[] args) {
    int[] data = {5, 2, 1, 8, 1, 0};
    System.out.println("before:" + Arrays.toString(data));
    sort(data);
    System.out.println("after:" + Arrays.toString(data));

  }
}
