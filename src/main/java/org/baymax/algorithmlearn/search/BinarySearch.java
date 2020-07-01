package org.baymax.algorithmlearn.search;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * data[low ... high] 左闭右闭 查找 targer
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/1 10:53
 */
public class BinarySearch {
  public static int search(int[] data, int target) {
    if (Objects.isNull(data) || data.length == 0) {
      return -1;
    }

    int low = 0;
    int high = data.length - 1;
    int mid = 0;
    // 1. 退出条件 要注意 不是 low < high
    while (low <= high) {
      // 2. 二分搜索的 经典 bug 和 low, high 的 更新
      mid = low + ((high - low) >> 1);
      if (target == data[mid]) {
        return mid;
      } else if (target > data[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  /**
   * 应用1 - 求算数平方根，精度 小数点后 6 位
   *
   * @param
   */
  public static double sqrt(double input) {
    if (input < 0) {
      throw new RuntimeException("不可输入负数, 精度必须是正数");
    }
    if (input == 0) {
      return 0;
    }

    if (input == 1) {
      return 1;
    }

    // 1. 区分 大于1 和 小于1 时的 初始化情况
    double low = getLow(input);
    double high = genHigh(input);
    double mid = high;
    do {
      mid = low + ((high - low) / 2);
      double midMid = mid * mid;
      if (equal(input, midMid)) {
        BigDecimal bigDecimal = new BigDecimal(mid).setScale(6, BigDecimal.ROUND_HALF_DOWN);
        return bigDecimal.doubleValue();
      } else if (less(input, midMid)) {
        high = mid - 0.000001;
      } else {
        low = mid + 0.000001;
      }
    } while (true);

  }

  /**
   * 变形：存在重复元素时
   * 二分查找变形 1：
   * 查找第一个值等于给定值
   *
   * @return
   */
  public static int searchFirst(int[] data, int target) {
    if (Objects.isNull(data) || data.length == 0) {
      return -1;
    }
    int low = 0;
    int high = data.length - 1;
    int mid = 0;
    while (low <= high) {
      mid = low + ((high - low) >> 1);
      if (data[mid] == target) {
        if (isFirst(data, mid, target)) {
          return mid;
        } else {
          high = mid - 1;
        }
      } else if (data[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 变形：存在重复元素时
   * 二分查找变形 1：
   * 查找最后个值等于给定值
   *
   * @return
   */
  public static int searchLast(int[] data, int target) {
    if (Objects.isNull(data) || data.length == 0) {
      return -1;
    }
    int low = 0;
    int high = data.length - 1;
    int mid = 0;
    while (low <= high) {
      mid = low + ((high - low) >> 1);
      if (data[mid] == target) {
        if (isLast(data, mid, target)) {
          return mid;
        } else {
          low = mid + 1;
        }
      } else if (data[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 查找第一个大于等于指定值
   *
   * @param data
   * @param target
   * @return index
   */
  public static int searchFirstGt(int[] data, int target) {
    if (Objects.isNull(data) || data.length == 0) {
      return -1;
    }

    if (data[0] >= target) {
      return 0;
    }
    if (data[data.length - 1] < target) {
      return -1;
    }

    int low = 0;
    int high = data.length - 1;
    int mid = 0;
    while (low <= high) {
      mid = low + ((high - low) >> 1);
      if (data[mid] < target) {
        if(isFirstGtForLess(data, mid, target)) {
          return mid + 1; // 注意 要 + 1
        } else {
          low = mid + 1;
        }
      } else {
        if (isFirstGtForGe(data, mid, target)) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }

  private static boolean isFirstGtForGe(int[] data, int mid, int target) {
    if (mid - 1 < 0) {
      return true;
    }
    return data[mid - 1] < target;
  }

  private static boolean isFirstGtForLess(int[] data, int mid, int target) {
    if (mid + 1 > data.length - 1) {
      return false;
    }
    return data[mid + 1] >= target;
  }

  private static boolean isLast(int[] data, int mid, int target) {
    if (mid + 1 > data.length - 1) {
      return true;
    }
    return data[mid + 1] != target;
  }

  private static boolean isFirst(int[] data, int mid, int target) {
    if (mid - 1 < 0) {
      return true;
    }
    return data[mid - 1] != target;
  }


  private static double genHigh(double input) {
    if (input < 1) {
      return 1;
    }
    return input;
  }

  private static double getLow(double input) {
    if (input < 1) {
      return 0;
    } else {
      return 1;
    }
  }

  private static boolean less(double input, double midMid) {
    return input + 0.000001 < midMid;
  }

  private static boolean equal(double input, double midMid) {
    return (midMid > input - 0.000001) && (midMid < input + 0.000001);
  }

  public static void main(String[] args) {
//   test();
    testSearchFirst();
    testSearchLast();
    testSearchFirstGt();
  }

  private static void testSearchFirstGt() {
    int[] data = {1, 1, 3, 3, 3, 3, 3, 5,5,6};
//    int index = BinarySearch.searchFirstGt(data, 4);
//    System.out.println(index == 7);
    int index2 = BinarySearch.searchFirstGt(data, 2);
    System.out.println(index2 == 2);
  }

  private static void testSearchLast() {
    int[] data = {1, 2, 3, 3, 3, 3, 3, 4, 4, 5};
    int index = BinarySearch.searchLast(data, 3);
    System.out.println(index == 6);
  }

  private static void testSearchFirst() {
    int[] data = {1, 2, 3, 3, 3, 3, 3, 4, 4, 5};
    int index = BinarySearch.searchFirst(data, 3);
    System.out.println(index == 2);
  }

  private static void test() {
    int[] data = {1, 2, 3, 4, 4, 5};
    int index = BinarySearch.search(data, 4);
    System.out.println("index:" + index);
    double input = 2;
    double result = sqrt(input);
    System.out.println(result);
  }
}
