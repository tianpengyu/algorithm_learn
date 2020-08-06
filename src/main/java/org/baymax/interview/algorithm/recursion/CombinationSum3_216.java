package org.baymax.interview.algorithm.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/6 11:42
 */
public class CombinationSum3_216 {
  private List<List<Integer>> res;
  public List<List<Integer>> combinationSum3(int k, int n) {
    res = new ArrayList<>();

    if (n <= 0 || k <= 0 || k > n) {
      return res;
    }

    if (n%9 != 0 && k <= n/9) {
      return res;
    }

    Deque<Integer> processed = new ArrayDeque<>(k);

    findCombinationSum3(k, n, processed, 0, 1);

    return res;
  }

  private void findCombinationSum3(int k, int targetSum, Deque<Integer> processed, int sum, int begin) {
    if (processed.size() == k ) {
      if (sum == targetSum) {
        System.out.println("找到一个解：" + processed);
        res.add(new ArrayList<>(processed));
      }
      return;
    }

    int upperBound = targetSum - sum;

    int lastNum = 0;
    if (!processed.isEmpty()) {
      lastNum = processed.peekLast();
    }

    // TODO tianpengyu 2020/8/6 : 不可以有重复的数字
    for (int curNum = begin; curNum <= 9; curNum++) {
      System.out.println("curNum:" + curNum + ", processed:" + processed + ", sum:" + sum);
      if (curNum > upperBound) {
        break;
      }

      processed.addLast(curNum);
      findCombinationSum3(k, targetSum, processed, sum + curNum, curNum + 1);
      processed.removeLast();
    }

  }

  public static void main(String[] args) {
    int k = 3;
    int target = 7;
    CombinationSum3_216 demo = new CombinationSum3_216();
    System.out.println(demo.combinationSum3(k, target));
  }
}
