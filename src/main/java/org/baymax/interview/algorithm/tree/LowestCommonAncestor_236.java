package org.baymax.interview.algorithm.tree;

/**
 *
 * 灵活运用 函数的含义， 举个简单的例子
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 22:18
 */
public class LowestCommonAncestor_236 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null && right == null) {
      return null;
    }

    if (left == null) {
      return right;
    }

    if (right == null) {
      return left;
    }

    return root;

  }
}
