package org.baymax.interview.algorithm.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/4 13:27
 */
public class Combinations_77 {
  private List<List<Integer>> res;
  public List<List<Integer>> combine(int n, int k) {
    if (n < 1) {
      return new ArrayList<>();
    }

    res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>(k);

    findCombinations(n, k, 1, 0, path);
    return res;
  }

  /**
   *
   * @param n
   * @param k
   * @param start 当前可以 取的第一个值
   * @param processedNum 已经处理了多少个
   */
  private void findCombinations(int n, int k, int start, int processedNum, Deque<Integer> path) {
    if (processedNum == k) {
      res.add(new ArrayList<>(path));
      return;
    }

    // 剪枝优化 一个优化 从 50% -》 97%
    // 一共 需要 k 个， 已经处理好了 path.size() , 也就是 c 个， 那么还剩 k - c 个空位
    // 等价于 在 [i ... n]  左闭右闭空间中 找到 k - c 的不同的数，那么 要求 i  最大是 n - ( k - c ) + 1 时开可以
    // 举个例子：
    // k - c = 1 时， i 最大可以是 n 此时在 [n ... n] 中选 1 个树，这是可以满足的
    // k - c = 2 时， i 最大可以是 n - 1 ， 此时 在 [n-1, ..., n] 中可以找到 2个数，此时如果 再让 i 等于 n 时 由于 在 [n ... n] 中找不到 两个数了 所以没必要走一遍 i = n 的循环
    int max = n - (k - path.size()) + 1;
    for (int i = start; i <= max; i++) {
      path.addLast(i);
      findCombinations(n, k, i + 1, processedNum + 1, path);
      path.removeLast();
    }
  }

  public static void main(String[] args) {
    int n =4;
    int k =2;
    Combinations_77 demo = new Combinations_77();
    List<List<Integer>> combine = demo.combine(n, k);
    System.out.println(combine);
  }
}
