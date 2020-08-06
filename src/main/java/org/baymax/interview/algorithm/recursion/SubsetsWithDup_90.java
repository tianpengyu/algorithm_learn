package org.baymax.interview.algorithm.recursion;

import java.util.*;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/6 14:41
 */
public class SubsetsWithDup_90 {
  private List<List<Integer>> res;
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    res = new ArrayList<>();

    Deque<Integer> processed = new ArrayDeque<>();

    Arrays.sort(nums);

    findSubsetsWithDup(nums, processed, 0);

    res.add(new ArrayList<>());
    return res;
  }

  private void findSubsetsWithDup(int[] nums, Deque<Integer> processed, int begin) {


    for (int i = begin; i < nums.length; i++) {

      if (i > begin && nums[i] == nums[i-1]) {
        continue;
      }

      processed.addLast(nums[i]);
      res.add(new ArrayList<>(processed));
      findSubsetsWithDup(nums, processed, i + 1);
      processed.removeLast();
    }

  }

  public static void main(String[] args) {
    int [] nums = {1, 2, 2};
    SubsetsWithDup_90 demo = new SubsetsWithDup_90();
    System.out.println(demo.subsetsWithDup(nums));
  }
}
