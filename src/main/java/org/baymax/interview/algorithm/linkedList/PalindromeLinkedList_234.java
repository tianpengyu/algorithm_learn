package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/30 16:31
 */
public class PalindromeLinkedList_234 {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
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
      if (first.val != second.val) {
        return false;
      }
      first = first.next;
      second = second.next;
    }
    return true;
  }

  private ListNode findMid(ListNode head) {
    ListNode mid;
    ListNode slow = head;
    ListNode fast = head;
    ListNode pre = new ListNode(0);
    pre.next = slow;
    while (true) {
      if (fast == null) {
        mid = pre;
        break;
      }

      if (fast.next == null) {
        mid = slow;
        break;
      }
      pre = pre.next;
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
    int [] arr = {1,1,3,2,1};
    ListNode head = ListNode.createLinkedList(arr);
    PalindromeLinkedList_234 demo = new PalindromeLinkedList_234();
    System.out.println(demo.isPalindrome(head));
  }
}
