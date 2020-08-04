package org.baymax.interview.algorithm.tree;

/**
 *
 * 第一遍 忘记 每个子树的上界 和 下界的判断了
 *
 * 只需要定义
 *  以 root 为根的树中 所有的 节点值都在 (lowerBound, upperBound) 之间即可
 *
 *  初始条件：可以让 lowerBound = null 这时需要处理以下 或者 lowerBound = Integer.MINIUM
 *
 *  递归逻辑、
 *  0. curNode 为 null 时 return ture
 *  1. curValue <= low 时 不符合
 *  2. curValue >= upper 时 不符合
 *  3. 递归判断 cur.left (low = inputLow, upper = curValue)
 *  4. 递归判断 cur.right (low = curValue, upper = inputUpper)
 *
 *  上面的 3 - 4 思想是第一次思考时 想不到的 ，我想的是 如何把 父亲传下去 然后考虑当前的孩子，其实不用考当前的孩子，只考虑当前和传进来的父亲的值即可
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 13:46
 */
public class ValidBST_98 {
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode root, Integer lowerBound, Integer upperBound) {
    if (root == null) {
      return true;
    }

    int val = root.val;
    if (lowerBound != null && val <= lowerBound) {
      return false;
    }

    if (upperBound != null && val >= upperBound) {
      return false;
    }

    return isValidBST(root.left, lowerBound, val) && isValidBST(root.right, val, upperBound);

  }
}
