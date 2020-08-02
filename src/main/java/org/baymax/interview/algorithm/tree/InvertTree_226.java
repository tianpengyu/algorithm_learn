package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 21:54
 */
public class InvertTree_226 {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    TreeNode newLeft = invertTree(root.right);
    TreeNode newRight = invertTree(root.left);

    root.left = newLeft;
    root.right = newRight;

    return root;
  }
}
