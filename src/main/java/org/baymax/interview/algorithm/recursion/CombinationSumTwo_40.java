package org.baymax.interview.algorithm.recursion;

import java.util.*;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/5 19:29
 */
public class CombinationSumTwo_40 {
  private List<List<Integer>> res;
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0 || target <= 0) {
      return new ArrayList<>();
    }
    res = new ArrayList<>();
    Arrays.sort(candidates);

    Deque<Integer> processed = new ArrayDeque<Integer>();

    findCombinationSum2(candidates, target, processed, 0, 0);

    return res;
  }

  private void findCombinationSum2(int[] candidates, int target, Deque<Integer> processed, int sum, int index) {
    if (sum == target) {
      res.add(new ArrayList<>(processed));
      return;
    }

    int upperBound = target - sum;
    for (int i = index; i < candidates.length && candidates[i] <= upperBound; i++) {
      if (i > 0 && candidates[i] == candidates[i-1]) {
        continue;
      }
      if (!processed.isEmpty() && processed.peekLast() > candidates[i]) {
        continue;
      }
      processed.addLast(candidates[i]);
      findCombinationSum2(candidates, target, processed, sum + candidates[i], index + 1);
      processed.removeLast();

    }
  }

  public static void main(String[] args) {
    int [] arr = {10,1,2,7,6,1,5};
    int target = 9;

    CombinationSumTwo_40 demo = new CombinationSumTwo_40();
    System.out.println(demo.combinationSum2(arr, target));


  }
}
