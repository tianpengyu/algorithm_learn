package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/30 15:13
 */
public class RotateRight_61 {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k <= 0) {
      return head;
    }
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;



    return dummyHead.next;
  }
}
