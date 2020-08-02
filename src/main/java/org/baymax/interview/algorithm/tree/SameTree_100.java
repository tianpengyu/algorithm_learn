package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 21:59
 */
public class SameTree_100 {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) {
      return q == null;
    }

    if (q == null) {
      return p == null;
    }

    if (q.val != p.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

  }
}
