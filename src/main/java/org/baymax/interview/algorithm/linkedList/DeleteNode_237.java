package org.baymax.interview.algorithm.linkedList;

/**
 * 不一定非要穿针引线，也可以尝试改变节点的值
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/30 11:37
 */
public class DeleteNode_237 {
  public void deleteNode(ListNode node) {
    if (node == null) {
      return;
    }

    if (node.next == null) {
      node = null;
    }

    ListNode next =node.next;
    node.val =next.val;
    node.next = next.next;
    next.next =null;
  }
}
