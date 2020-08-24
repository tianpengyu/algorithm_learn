package org.baymax.interview.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/12 15:39
 */
public class NTreePostorder_590 {
  public List<Integer> postorder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> res = new ArrayList<>();

    postorder(root, res);
    return res;
  }

  private void postorder(Node root, List<Integer> res) {
    if (root == null) {
      return;
    }

    if (root.children != null && root.children.size() > 0) {
      for (int i = 0; i < root.children.size(); i++) {
        postorder(root.children.get(i), res);
      }
    }

    res.add(root.val);
  }

}
