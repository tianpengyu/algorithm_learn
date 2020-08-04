package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 19:05
 */
public class KthSmallest_230 {
  private Integer count = 0;
  private Integer result = 0;

  public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return result;
  }

  private void inorder(TreeNode root, int k) {
    if (root == null) {
      return;
    }

    inorder(root.left, k);
    count++;
    if (count == k) {
      result = root.val;
      return;
    }
    inorder(root.right, k);
  }
}
