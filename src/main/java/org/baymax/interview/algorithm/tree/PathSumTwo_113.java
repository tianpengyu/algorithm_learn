package org.baymax.interview.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. tree:
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 2. sum = 22
 *
 * return:
 *  [
 *    [5,4,11,2],
 *    [5,8,4,5]
 *  ]
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 11:31
 */
public class PathSumTwo_113 {
  private List<List<Integer>> paths;


  // TODO tianpengyu 2020/8/3 : try dfs
  public List<List<Integer>> pathSum(TreeNode root, int sum) {

    paths = new ArrayList<>();
    if (root == null) {
      return paths;
    }

    List<Integer> onePath = new ArrayList<>();

    pathSum(root, sum, onePath);

    return paths;
  }

  private void pathSum(TreeNode root, int sum, List<Integer> onePath) {
    if (root == null) {
      return;
    }

    onePath.add(root.val);

    if (root.left == null && root.right == null && root.val == sum) {
      paths.add(onePath);
      return;
    }

    pathSum(root.left, sum - root.val, new ArrayList<>(onePath));
    pathSum(root.right, sum - root.val, new ArrayList<>(onePath));

  }
}
