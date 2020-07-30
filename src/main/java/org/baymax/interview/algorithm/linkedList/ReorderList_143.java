package org.baymax.interview.algorithm.linkedList;


/**
 * 1. 快速 找到中间元素 （奇数、偶数要区别）
 * 2. 后半部分反转
 * 3. 只遍历一次可以嘛
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/30 16:00
 */
public class ReorderList_143 {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    // find mid and odd flag
    ListNode mid = findMid(head);

    ListNode secondHead = mid.next;
    mid.next = null;

    secondHead = reverse(secondHead);

    ListNode first = head;
    ListNode second = secondHead;
    while (first != null && second != null) {
      ListNode firstNext = first.next;
      ListNode secondNext = second.next;
      first.next = second;
      second.next = firstNext;
      first = firstNext;
      second = secondNext;
    }

  }

  private ListNode findMid(ListNode head) {
    ListNode mid;
    ListNode slow = head;
    ListNode fast = head;
    while (true) {
      if (fast == null) {
        mid = slow;
        break;
      }

      if (fast.next == null) {
        mid = slow;
        break;
      }

      slow = slow.next;
      fast = fast.next.next;
    }
    return mid;
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
    int [] arr = {1,2,3,4,5};
    ListNode head = ListNode.createLinkedList(arr);
    ReorderList_143 demo = new ReorderList_143();
    demo.reorderList(head);
    ListNode.printLinkedList(head);
  }
}
