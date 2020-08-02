package org.baymax.interview.algorithm.tree;

import com.sun.jmx.remote.internal.ArrayQueue;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/2 12:03
 */
@Data
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {
  }

  TreeNode(int x) {
    val = x;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode createTreeNode(Integer[] arr) {
    if (arr == null || arr.length == 0) {
      return null;
    }
    Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(arr.length + 1);
    TreeNode root = new TreeNode(arr[0]);
    queue.add(root);


    for (int i = 1; i < arr.length - 1; ) {
      if (queue.isEmpty()) {
        break;
      }
      TreeNode cur = queue.poll();
      Integer leftVal = arr[i];
      Integer rightVal = arr[i + 1];
      if (leftVal != null) {
        cur.left = new TreeNode(leftVal);
        queue.offer(cur.left);
      }
      if (rightVal != null) {
        cur.right = new TreeNode(rightVal);
        queue.offer(cur.right);
      }

      i += 2;

    }

    return root;
  }

//  public static void printTree(TreeNode root) {
//    if (root == null) {
//      System.out.println("root is null, can't print tree");
//      return;
//    }
//
//    int maxDepth = maxDepth(root);
//
//    Queue<TreeNode> queue = new LinkedList<>();
//
//    Map<TreeNode, Integer> posMap = new HashMap<TreeNode, Integer>(); //记录节点位置。
//    queue.offer(root);
//    int level = 1, levelCount = 1, nextlevelCount = 0; //记录当前层号及层节点数
//    posMap.put(root, (int) Math.pow(2, maxDepth - level));
//    while (!queue.isEmpty()) {
//      TreeNode temp = queue.poll();
//      for (int i = 0; i < posMap.get(temp); i++)
//        System.out.print("\t");
//      System.out.print(temp.val);
//
//      if (temp.left != null) {
//        nextlevelCount++;
//        posMap.put(temp.left, posMap.get(temp) - (int) Math.pow(2, maxDepth - (level + 1)));
//        queue.offer(temp.left);
//
//      }
//      if (temp.right != null) {
//        nextlevelCount++;
//        posMap.put(temp.right, posMap.get(temp) + (int) Math.pow(2, maxDepth - (level + 1)));
//        queue.offer(temp.right);
//      }
//      levelCount--;
//      if (levelCount == 0)//开始打印下一层
//      {
//        levelCount = nextlevelCount;
//        level++;
//        nextlevelCount = 0;
//        System.out.println();
//      }
//    }
//
//
//  }

  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, null, null, 4, 5, null};
    TreeNode root = TreeNode.createTreeNode(arr);
//    TreeNode.printTree(root);

  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
