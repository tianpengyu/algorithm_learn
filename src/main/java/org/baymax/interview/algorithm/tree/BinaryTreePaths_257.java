package org.baymax.interview.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 10:30
 */
public class BinaryTreePaths_257 {

  private List<String> paths;
  private StringBuilder sb;
  private String arrow = "->";


  /**
   * 用 StringBuilder
   * @param root
   * @return
   */
  public List<String> binaryTreePaths(TreeNode root) {
    paths = new ArrayList<>();
    if (root == null) {
      return paths;
    }
    sb = new StringBuilder();

    binaryTreePaths(root, sb);
    return paths;
  }

  /**
   * 返回的是实例的 paths 成员变量
   * 填充当前节点到 paths 中
   * 填充完 再去当前节点的孩子节点进行填充
   * 注意 ：
   * 1. 填充 paths 的时机
   * 2. sb 传到孩子时 需要 new 一个新的 否则会 覆盖父亲的
   *
   * 递归逻辑是：
   *  先根据已经填充好的父亲 paths 把自己的填充进去；
   *  然后再递归地填充自己的孩子
   * @param root
   * @param populatedParentPaths
   */
  private void binaryTreePaths(TreeNode root, StringBuilder populatedParentPaths) {
    if (root == null) {
      return;
    }

    populatedParentPaths.append(root.val);

    // 因为这有个 所以不存在 【1->2->】 的情况，只会是：【1->2】
    if (root.left == null && root.right == null) {
      paths.add(populatedParentPaths.toString());
      return;
    }

    populatedParentPaths.append(arrow);

    binaryTreePaths(root.left, new StringBuilder(populatedParentPaths));
    binaryTreePaths(root.right, new StringBuilder(populatedParentPaths));
  }


  /**
     * 最简单的实现
     */
//  public List<String> binaryTreePaths(TreeNode root) {
//
//    List<String> result = new ArrayList<>();
//    if (root == null) {
//      return result;
//    }
//
//    if (root.left == null && root.right == null) {
//      result.add(String.valueOf(root.val));
//      return result;
//    }
//
//    // cur -> {leftPaths} , cur -> {rightPaths}
//    List<String> leftChildrenPaths = binaryTreePaths(root.left);
//    for (int i = 0; i < leftChildrenPaths.size(); i++) {
//      result.add(root.val + "->" + leftChildrenPaths.get(i));
//    }
//
//    List<String> rightChildrenPaths = binaryTreePaths(root.right);
//    for (int i = 0; i < rightChildrenPaths.size(); i++) {
//      result.add(root.val + "->" + rightChildrenPaths.get(i));
//    }
//
//    return result;
//  }
  }
