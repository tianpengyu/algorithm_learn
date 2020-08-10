package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 22:24
 */
public class CountCompleteTreeNodes_222 {
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return countNodes(root.left) + countNodes(root.right);
  }
}
