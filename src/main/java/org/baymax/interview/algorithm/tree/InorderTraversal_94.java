package org.baymax.interview.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/12 15:24
 */
public class InorderTraversal_94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> res = new ArrayList<>();

    inorderTraversal(root, res);

    return res;
  }

  private void inorderTraversal(TreeNode root, List<Integer> res) {

    if (root == null) {
      return;
    }

    inorderTraversal(root.left, res);
    res.add(root.val);
    inorderTraversal(root.right, res);
  }
}
