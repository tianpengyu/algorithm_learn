package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 13:25
 */
public class RemoveDuplicatesFromSortedList_83 {

  public ListNode deleteDuplicates(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummyHead = new ListNode(0);

    dummyHead.next = head;

    ListNode cur = dummyHead.next;

    while (cur.next != null) {

      ListNode duplicateNode = cur.next;

      if (cur.val == duplicateNode.val) {
        cur.next = duplicateNode.next;
        // do not move to next again!!!!
      } else {
        cur = cur.next;
      }

    }

    return dummyHead.next;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 2,3 ,3 };
    ListNode head = ListNode.createLinkedList(arr);
    RemoveDuplicatesFromSortedList_83 demo = new RemoveDuplicatesFromSortedList_83();
    ListNode.printLinkedList(demo.deleteDuplicates(head));

  }
}
