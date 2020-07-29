package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/29 11:31
 */
public class MergeTwoSortedLinkedList_21 {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    ListNode dummyHead = new ListNode(0);

    ListNode tail = dummyHead;


    ListNode l = l1;

    ListNode r = l2;

    while (l != null && r != null) {
      if (l.val <= r.val) {
        tail.next = l;
        l = l.next;
      } else {
        tail.next = r;
        r = r.next;
      }
      tail = tail.next;
    }

    while (l != null) {
      tail.next = l;
      l = l.next;
      tail = tail.next;
    }

    while (r != null) {
      tail.next = r;
      r = r.next;
      tail = tail.next;
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {
    int [] arr1 = {1,2,4};
    int [] arr2 = {1,3,4};

    ListNode l1 = ListNode.createLinkedList(arr1);
    ListNode l2 = ListNode.createLinkedList(arr2);

    ListNode.printLinkedList(MergeTwoSortedLinkedList_21.mergeTwoLists(l1, l2));

  }

}
