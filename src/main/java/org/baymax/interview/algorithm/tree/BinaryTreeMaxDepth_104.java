package org.baymax.interview.algorithm.tree;


/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 12:03
 */
public class BinaryTreeMaxDepth_104 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = maxDepth(root.left) + 1;
    int rightHeight = maxDepth(root.right) + 1;
    return Math.max(leftHeight, rightHeight);
  }
}
