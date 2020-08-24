package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/12 15:55
 */
public class IsSubTree_572 {
  public boolean isSubtree(TreeNode s, TreeNode t) {

    if (t == null) {
      return true;
    }

    if (s == null && t != null) {
      return false;
    }


    if (s.val != t.val) {
      return isSubtree(s.left, t) || isSubtree(s.right, t);
    } else {
      if (isSubtree(s.left, t.left) && isSubtree(s.right, t.right)) {
        return true;
      } else {
        return isSubtree(s.left, t) || isSubtree(s.right, t);
      }
    }

  }
}
