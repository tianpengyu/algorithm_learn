package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 18:38
 */
public class SortedArrayToBST_108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    return sortedArrayToBST(nums, 0, nums.length - 1);

  }

  private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    if (start > end) {
      return null;
    }

    int mid = (end - start) / 2 + start;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(nums, start, mid - 1);
    root.right = sortedArrayToBST(nums, mid + 1, end);
    return root;
  }

  public static void main(String[] args) {
    int [] arr = {-10,-3,0,5,9};
    SortedArrayToBST_108 demo = new SortedArrayToBST_108();
    TreeNode result = demo.sortedArrayToBST(arr);
    System.out.println("end");

  }
}
