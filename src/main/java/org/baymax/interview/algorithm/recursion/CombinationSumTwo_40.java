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

  /**
   *
   * @param candidates
   * @param target
   * @param processed
   * @param sum
   * @param begin 从 candidates 的 begin 下标开始搜索， for 中的 i 就是当前正在处理的 那么 i + 1 才是 下一个 要考虑的下表 而不是 begin + 1
   */
  private void findCombinationSum2(int[] candidates, int target, Deque<Integer> processed, int sum, int begin) {
    if (sum == target) {
      res.add(new ArrayList<>(processed));
      return;
    }

    int upperBound = target - sum;
    for (int i = begin; i < candidates.length ; i++) {
      System.out.println("当前 index:" + begin + "，当前 i:" + i + ", 当前 已经处理：" + processed + ", candidate[" + i + "]:" + candidates[i]);
      // 大剪枝：添加最小的都已经超过 target 了 后续都没必要添加了
      if (candidates[i] > upperBound) {
        System.out.println("大剪枝 - 后续都不需要再考虑了");
        break;
      }

      // 小剪枝：当前处理的和上一个处理的值一样，那么当前不需要处理，因为当前要处理的情况在上一次都处理过了
      if (i > begin && candidates[i] == candidates[i-1]) {
        System.out.println("小剪枝 - 不考虑 candidate[" + i + "]=" + candidates[i] + ", 将会考虑 i + 1");
        continue;
      }

      processed.addLast(candidates[i]);
      // 这里 第一次 写的 使用 写成 index + 1 应该是 i + 1  ， index + 1 会有 [1, 2, 2] 的情况产生 ， 当前的下一个 是 i + 1, 因为 i 是当前下表 不是 index + 1
      findCombinationSum2(candidates, target, processed, sum + candidates[i], i + 1);
      processed.removeLast();

    }
  }

  public static void main(String[] args) {
    int [] arr = {10,1,2,7,6,1,5};
    int target = 8;

    CombinationSumTwo_40 demo = new CombinationSumTwo_40();
    System.out.println(demo.combinationSum2(arr, target));


  }
}
