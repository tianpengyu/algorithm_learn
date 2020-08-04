package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 13:28
 */
public class LowestCommonAncestor_235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return root;
    }

    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    }

    return root;
  }
}
