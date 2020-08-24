package org.baymax.interview.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/12 15:31
 */
public class NTreePreorder_589 {
  public List<Integer> preorder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> res = new ArrayList<>();

    preorder(root, res);
    return res;
  }

  private void preorder(Node root, List<Integer> res) {
    if (root == null) {
      return;
    }
    res.add(root.val);
    if (root.children != null && root.children.size() > 0) {
      for (int i = 0; i < root.children.size(); i++) {
        preorder(root.children.get(i), res);
      }
    }
  }
}
