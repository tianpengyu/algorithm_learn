package org.baymax.interview.algorithm.recursion;/**
 * @author tianpengyu
 * @date 2020/8/4 12:21
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation_46 {
  private List<List<Integer>> res;
  private boolean [] used;
  public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }


    used = new boolean[nums.length];

    findPermutation(nums, 0, new ArrayList<>());
    return res;
  }

  private void findPermutation(int[] nums, int index, List<Integer> processed) {
    if(index == nums.length) {
      // 因为是 同一个对象，所以 需要复制内容，如果存对象的引用那么后续的也会更改 res 里的数据
      res.add(new ArrayList<>(processed));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      processed.add(nums[i]);
      findPermutation(nums, index + 1, processed);
      processed.remove(processed.size() - 1);
      used[i] = false;
    }
  }

}
