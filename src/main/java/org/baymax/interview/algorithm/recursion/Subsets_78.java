package org.baymax.interview.algorithm.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/6 14:02
 */
public class Subsets_78 {
  private List<List<Integer>> res;
  public List<List<Integer>> subsets(int[] nums) {
    res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }

    Deque<Integer> processed = new ArrayDeque<>();

    findSubsets(nums, processed, 0);

    res.add(new ArrayList<>());
    return res;
  }

  private void findSubsets(int[] nums, Deque<Integer> processed, int beginIndex) {
    if (!processed.isEmpty() && processed.size() <= nums.length) {
      res.add(new ArrayList<>(processed));
    }

    for (int i = beginIndex; i < nums.length; i++) {
      if (!processed.isEmpty() && nums[i] == processed.peekLast()) {
        break;
      }
      processed.addLast(nums[i]);
      findSubsets(nums, processed, i + 1);
      processed.removeLast();
    }
  }

  public static void main(String[] args) {
    int [] nums = {1,2,3};
    Subsets_78 demo = new Subsets_78();
    System.out.println(demo.subsets(nums));
  }
}
