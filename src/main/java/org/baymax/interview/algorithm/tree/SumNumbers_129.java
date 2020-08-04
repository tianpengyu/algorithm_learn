package org.baymax.interview.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 先举个例子 看看有没有更好的方法
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 11:49
 */
public class SumNumbers_129 {

  private int summation = 0;

  public int sumNumbers(TreeNode root) {
    sum(root,0);
    return summation;
  }

  private void sum(TreeNode root, int numberOfParent) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      summation += root.val + numberOfParent * 10;
    }

    sum(root.left, numberOfParent*10 + root.val);
    sum(root.right, numberOfParent*10 + root.val);

  }


  // dfs?
//  private List<List<Integer>> paths;
//  public int sumNumbers(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//
//    paths = new ArrayList<>();
//
//    List<Integer> onePath = new ArrayList<>();
//    populatePaths(root, onePath);
//
//    List<Integer> results = new ArrayList<>();
//
//
//    for (int i = 0; i< paths.size(); i++) {
//      results.add(transferToNumber(paths.get(i)));
//    }
//
//    int result = 0;
//    for (int i = 0; i < results.size(); i++) {
//      result += results.get(i);
//    }
//    return result;
//  }
//
//  private Integer transferToNumber(List<Integer> integers) {
//    if (integers == null || integers.size() == 0) {
//      return 0;
//    }
//    Integer result = 0;
//    for (int i = 0; i < integers.size(); i++) {
//      result = (int)Math.pow(10, integers.size() - 1 -i) * integers.get(i) + result;
//    }
//    return result;
//  }
//
//  private void populatePaths(TreeNode root, List<Integer> onePath) {
//    if (root == null) {
//      return;
//    }
//
//    onePath.add(root.val);
//    if (root.left == null && root.right == null) {
//      paths.add(onePath);
//    }
//
//    populatePaths(root.left, new ArrayList<>(onePath));
//    populatePaths(root.right, new ArrayList<>(onePath));
//
//  }
}
