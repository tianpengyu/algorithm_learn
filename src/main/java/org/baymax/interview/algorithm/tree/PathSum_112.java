package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 22:40
 */
public class PathSum_112 {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return root.val == sum;
    }

    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

  }
}
