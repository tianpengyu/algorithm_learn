package org.baymax.interview.algorithm.tree;

/**
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 15:52
 */
public class DeleteNode_450 {
  // TODO tianpengyu 2020/8/3 : 需要再看看
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return root;
    }

    // 这里写反了，第二次
    if (root.val < key) {
      // 这里第一次没想到，没用好函数的定义
      root.right = deleteNode(root.right, key);
      return root;
    }

    if (root.val > key) {
      root.left = deleteNode(root.left, key);
      return root;
    }

    //
    // root.val == key
    if (root.left == null) {
      TreeNode right = root.right;
      return right;
    }

    if (root.right == null) {
      TreeNode left = root.left;
      return left;
    }

    // 这里是核心
    TreeNode maxRightNode = new TreeNode(findMin(root.right).val);
    maxRightNode.left = root.left;
    maxRightNode.right = deleteMin(root.right);
    return maxRightNode;
  }


  private TreeNode findMin(TreeNode root) {
    if (root == null) {
      return root;
    }

    if (root.left == null) {
      return root;
    }

    return findMin(root.left);
  }

  /**
   * 竟然忘记了
   *
   * @param root
   * @return
   */
  private TreeNode deleteMin(TreeNode root) {
    if (root == null) {
      return root;
    }
    if (root.left == null) {
      return root.right;
    }

    root.left = deleteMin(root.left);
    return root;
  }

  public static void main(String[] args) {
    Integer [] arr = {5,3,6,2,4,null,7};
    TreeNode root = TreeNode.createTreeNode(arr);
    DeleteNode_450 demo = new DeleteNode_450();
    TreeNode result = demo.deleteNode(root, 3);
    System.out.println("end");
  }
}
