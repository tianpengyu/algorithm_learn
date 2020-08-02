package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 22:30
 */
public class BalancedBinaryTree_110 {
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (Math.abs(height(root.left) - height(root.right)) > 1) {
      return false;
    }

    return isBalanced(root.left) && isBalanced(root.right);
  }

  private int height(TreeNode root) {
    if (root == null) {
      return -1;
    }

    return 1 + Math.max(height(root.left), height(root.right));
  }
}
