package org.baymax.interview.algorithm.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 循环不变式：data[0 ... cur -1] 已经排好序
 * 需要将 data[cur] 插入到 [0 ... cur -1] 中的某个位置
 * @author tianpengyu
 * @version 1.0
 * @date 2020/6/30 13:32
 */
public class InsertSort {
  public static void sort(int[] data) {
    if (Objects.isNull(data) || data.length <= 1) {
      return;
    }
    sort(data, 0, data.length - 1);
  }

  /**
   * 仅对 data[left ... right] 左闭右闭 进行排序，
   * 同样此时的循环不变式：data[left ... cur -1] 已经有序
   * @param data
   * @param left
   * @param right
   */
  public static void sort(int[] data, int left, int right) {
    if (Objects.isNull(data) || data.length <= 1) {
      return;
    }
    if (right <= left) {
      return;
    }

    for (int cur = left + 1; cur <= right; cur++) {
      int value = data[cur];

      int targetIndex = findTargetIndex(data, cur, value, left);

      // insert value into targetIndex
      data[targetIndex] = value;
    }
  }


  /**
   * 从 当前要处理的位置开始，【向前】遍历，目的是 寻找到需要插入的位置
   * @param data 数据
   * @param cur 当前要处理的数据 index
   * @param value data[cur]
   * @return
   */
  private static int findTargetIndex(int[] data, int cur, int value, int left) {
    int targetIndex = cur - 1;
    for (; targetIndex >= left; targetIndex-- ) {
      if (value >= data[targetIndex]) {
        break;
      }
      data[targetIndex + 1] = data[targetIndex]; // 注意⚠️ 当时这里写成：data[cur] = data[targetIndex]
    }
    // 这里 需要注意下，因为实现时，退出 上面的 for-loop 的条件是 不满足大小：
    // 也就是 targetIndex 处的数据 已经小于等于 value 了，不需要在向前遍历了，那么 target + 1 才是真正要插入 value 的位置
    return targetIndex + 1;
  }

  public static void main(String[] args) {
    test();
    test2();
    test3();

  }

  private static void test3() {
    int[] data = {1,2,4,3,1};
    System.out.println("before3: " + Arrays.toString(data));
    InsertSort.sort(data,2, 3);
    System.out.println("after3: " + Arrays.toString(data));
  }

  private static void test2() {
    int[] data = {1,2,3,4,5};
    System.out.println("before: " + Arrays.toString(data));
    InsertSort.sort(data);
    System.out.println("after: " + Arrays.toString(data));

  }

  private static void test() {
    int[] data = {1,2,4,3,5};
    System.out.println("before: " + Arrays.toString(data));
    InsertSort.sort(data);
    System.out.println("after: " + Arrays.toString(data));
  }
}
