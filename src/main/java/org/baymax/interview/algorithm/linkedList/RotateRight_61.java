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

    int length = 0;

    ListNode pre = dummyHead;
    ListNode tail = head;
    for (int i = 1; i <= k-1 && tail != null; i++) {
      tail = tail.next;
      length ++;
    }

    if (tail == null) {
      // k > head.size()
      k = k % length;
      if (k == 0) {
        return dummyHead.next;
      }
      tail = head;
      for (int i = 1; i <= k-1 && tail != null; i++) {
        tail = tail.next;
      }
    }

    // (pre, pre.next ... tail]
    while (tail.next != null) {
      pre = pre.next;
      tail = tail.next;
    }

    pre.next = reverse(pre.next);

    ListNode cur = pre.next;
    pre.next = null;

    while(cur != null) {
      // head insert
      ListNode next = cur.next;
      cur.next = dummyHead.next;
      dummyHead.next = cur;
      cur = next;
    }

    return dummyHead.next;
  }

  private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    int [] arr = {1,2,3,4,5,6,7};
    ListNode head = ListNode.createLinkedList(arr);
    RotateRight_61 demo = new RotateRight_61();
    ListNode.printLinkedList(demo.rotateRight(head, 8));
  }
}
