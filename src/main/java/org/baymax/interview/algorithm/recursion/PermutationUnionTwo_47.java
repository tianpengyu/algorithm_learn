package org.baymax.interview.algorithm.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 画图分析 从结果 开始
 * []
 * [1]         [1]             [2]
 * [11] [12]   [11] [12]       [21] [21]
 * 112 121    112  121        211  211
 * <p>
 * 第二层 第二个 [1] 和
 * 第三层 第二个 [21]
 * 应该被剪枝，因为之前处理过相同的选值了 ，如果继续处理会导致结果有重复
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/4 12:40
 */
public class PermutationUnionTwo_47 {
  private List<List<Integer>> res;
  private boolean[] used;

  public List<List<Integer>> permuteUnique(int[] nums) {
    res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }

    used = new boolean[nums.length];

    findPermutationUnion(nums, new ArrayList<Integer>());

    return res;
  }

  private void findPermutationUnion(int[] nums, List<Integer> processed) {
    if (processed.size() == nums.length) {
      res.add(new ArrayList<>(processed));
      return;
    }

    Set<Integer> sameNumber = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {continue;}
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1] ) {
        continue;
      }
      sameNumber.add(nums[i]);
      used[i] = true;
      processed.add(nums[i]);
      findPermutationUnion(nums, processed);
      used[i] = false;
      processed.remove(processed.size() - 1);
    }

  }

  public static void main(String[] args) {
    int [] arr = {1,2,1};
    PermutationUnionTwo_47 demo = new PermutationUnionTwo_47();
    List<List<Integer>> lists = demo.permuteUnique(arr);
    System.out.println(lists);
  }
}
