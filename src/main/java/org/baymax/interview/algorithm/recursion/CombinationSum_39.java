package org.baymax.interview.algorithm.recursion;

import java.util.*;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/4 14:13
 */
public class CombinationSum_39 {
  private List<List<Integer>> res;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0 || target <= 0) {
      return new ArrayList<>();
    }

    res = new ArrayList<>();

    Arrays.sort(candidates);

    Deque<Integer> processed = new ArrayDeque<>();

    findCombinationSums(candidates, target, processed, 0);

    return res;
  }

  private void findCombinationSums(int[] candidates, int target, Deque<Integer> processed, int sum) {
    if (sum == target) {
      System.out.println("已经找到一个解: " + processed);
      res.add(new ArrayList<>(processed));
      return;
    }
    int upperBound = target - sum;

    for (int i = 0; i < candidates.length && candidates[i] <= upperBound; i++) {
      int curNum = candidates[i];
      if (!processed.isEmpty() && curNum < processed.peekLast()) {
        continue;
      }
      int newSum = sum + curNum;
      if (newSum > target) {
        continue;
      }
      processed.addLast(curNum);
      findCombinationSums(candidates, target, processed, newSum);
      processed.removeLast();
    }
  }

  public static void main(String[] args) {
    int [] arr = {2,3,6,7};
    int target = 7;
    CombinationSum_39 demo = new CombinationSum_39();
    System.out.println(demo.combinationSum(arr, target));
  }
}
