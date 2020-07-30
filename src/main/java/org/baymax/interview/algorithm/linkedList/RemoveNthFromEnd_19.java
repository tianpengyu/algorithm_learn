package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/30 11:46
 */
public class RemoveNthFromEnd_19 {
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return head;
    }

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;


    ListNode pre = dummyHead;
    ListNode tail = dummyHead;
    // [pre ... tail] 长度是 n + 1
    int i = 1;
    for (; i <= n+1 && tail != null; i++) {
      tail = tail.next;
    }

    if (tail == null) {
      if (i == n + 2) {
        ListNode next = pre.next;
        pre.next = next.next;
        next.next = null;
        return dummyHead.next;
      } else {
        return head;
      }
    }

    while (tail != null) {
      tail = tail.next;
      pre = pre.next;
    }

    ListNode next = pre.next;
    pre.next = next.next;
    next.next = null;
    return dummyHead.next;
  }

  public static void main(String[] args) {
    int [] arr = {1};
    ListNode head = ListNode.createLinkedList(arr);
    ListNode.printLinkedList(RemoveNthFromEnd_19.removeNthFromEnd(head,1));
  }
}
