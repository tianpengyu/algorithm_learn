package org.baymax.interview.algorithm.search;

import java.util.HashSet;
import java.util.Set;

/**
 * nums [l ... r] 是
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/27 10:41
 */
public class ContainDuplicate2_219 {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (null == nums || nums.length <= 1 || k <= 1) {
      return false;
    }

    Set<Integer> records = new HashSet<>();

    for (int i = 0; i <= nums.length - 1; i++) {
      if (records.contains(nums[i])) {
        return true;
      }

      records.add(nums[i]);

      // keep k numbers in search table
      if (records.size() == k + 1) {
        records.remove(nums[i - k]);
      }

    }

    return false;
  }
}
