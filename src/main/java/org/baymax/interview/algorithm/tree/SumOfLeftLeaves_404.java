package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 23:11
 */
public class SumOfLeftLeaves_404 {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 0;
    }

    return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);

  }

  private int sumOfLeftLeaves(TreeNode root, boolean leftChild) {
    if (root == null) {
      return 0;
    }

    if (leftChild && root.left == null && root.right == null) {
      return root.val;
    }

    return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
  }
}
