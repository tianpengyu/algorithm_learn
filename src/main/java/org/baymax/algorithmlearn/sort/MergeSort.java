package org.baymax.algorithmlearn.sort;

import java.util.Objects;

/**
 * 1. 小数据量时，数组近乎有序。对于近乎有序的数组， insert sort 可以达到 O(n) 的时间复杂度
 * @author tianpengyu
 * @version 1.0
 * @date 2020/6/30 14:19
 */
public class MergeSort {
  public static void sort(int[] data) {
    if (Objects.isNull(data) || data.length <= 1) {
      return;
    }
    int length = data.length;
    int mid = (length - 0) / 2;
    mergeSort(data, 0, mid);
    mergeSort(data, mid + 1, length);
    merge(data, 0, mid, length);
  }
  private static void mergeSort(int[] data, int left, int right) {
    if (smallerEnough(left, right)) {
      InsertSort.sort(data, left, right);
    }
  }

  private static boolean smallerEnough(int left, int right) {
    return (right - left) <= 16;
  }

  private static void merge(int[] data, int i, int mid, int length) {
  }


}
