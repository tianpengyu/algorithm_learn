package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/29 16:55
 */
public class InsertSortList_147 {
  public static  ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode dummyHead = new ListNode(0);

    dummyHead.next = head;

    ListNode right = dummyHead;

    ListNode cur = head;

    while (cur != null) {

      ListNode next = cur.next;

      ListNode pre = dummyHead;

      while (pre.next != cur && pre.next.val <= cur.val) {
        // move to next
        pre = pre.next;
      }

      if (pre.next == cur) {
        cur = cur.next;
        right = right.next;
        continue;
      }

      // insert
      cur.next = pre.next;
      right.next = next;
      pre.next = cur;
      cur = next;
    }

    return dummyHead.next;
  }

  public static void main(String[] args) {
    int [] arr = {1,3,3,2,5,3,1};
    ListNode head = ListNode.createLinkedList(arr);
    ListNode.printLinkedList(InsertSortList_147.insertionSortList(head));
  }
}
