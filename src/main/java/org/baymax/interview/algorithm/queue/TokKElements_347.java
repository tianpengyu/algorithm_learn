package org.baymax.interview.algorithm.queue;

import java.util.*;

/**
 * 优先队列
 * n * log( n - k)
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/1 17:12
 */
public class TokKElements_347 {

  public static int[] topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    Map<Integer, Integer> count = new HashMap<>();
    for (Integer number : nums) {
      Integer freq = count.get(number);
      if (freq == null) {
        count.put(number, 1);
      } else {
        count.put(number, freq + 1);
      }
    }

    if (k > count.size()) {
      return nums;
    }

    // poll 最小的
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> count.get(o1) - count.get(o2));

    for (Integer value : count.keySet()) {
      queue.add(value);
      if (queue.size() > k) {
        queue.poll();
      }
    }

    int[] result = new int[k];

    for (int i = k - 1; i >= 0; i--) {
      result[i] = queue.poll();
    }
    return result;
  }


  public static void main(String[] args) {
   int [] nums = {-1, -1};
   int k =1;
    int [] result = TokKElements_347.topKFrequent(nums, k);
    System.out.println(Arrays.asList(result));

  }
}

