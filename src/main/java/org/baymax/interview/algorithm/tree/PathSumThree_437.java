package org.baymax.interview.algorithm.tree;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 12:43
 */
public class PathSumThree_437 {

  /**
   * 以 root 为 根节点的二叉树中，寻找和为 sum 的路径，返回这样的路径个数
   *
   * @param root
   * @param sum
   * @return
   */
  public int pathSum(TreeNode root, int sum) {
    int pathSum = 0;

    if (root == null) {
      return pathSum;
    }

    pathSum += findPathContainRoot(root, sum);
    pathSum += pathSum(root.left, sum);
    pathSum += pathSum(root.right, sum);

    return pathSum;
  }

  /**
   * 找到 以root 为根，并且包含 root 的路径个数，每一个路径上所有节点的和是 sum
   *
   * @param root
   * @param sum
   * @return
   */
  private int findPathContainRoot(TreeNode root, int sum) {
    int result = 0;

    // 不要求 以叶子节点为结尾
    if (root == null) {
      return result;
    }

    // 这里不return 表示可以继续 向下搜索
    if (root.val == sum) {
      result++;
    }

    // sum - root.val 意味着 包含 root
    result  += findPathContainRoot(root.left, sum - root.val);
    result  += findPathContainRoot(root.right, sum - root.val);
    return result;
  }

}
