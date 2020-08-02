package org.baymax.interview.algorithm.tree;

/**
 *
 *  注意必须是叶子节点，若一个节点有右孩子 没有左孩子 则不算叶子节点
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 12:19
 */
public class MinDepth_111 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.right == null ) {
      return minDepth(root.left) + 1;
    }

    if (root.left == null ) {
      return minDepth(root.right) + 1;
    }

    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;



  }
}
