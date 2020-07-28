package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 19:38
 */
public class AddTwoNumbers_2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode head = result;

    int ten = 0;

    while (true) {
      if (l1 == null || l2 == null) {
        break;
      }

      int sum = l1.val + l2.val + ten;
      if (ten > 0) {
        ten--;
      }

      if (sum >= 10) {
        ten++;
        sum -= 10;
      }

      result.next = new ListNode(sum);
      l1 = l1.next;
      l2 = l2.next;
      result = result.next;
    }

    while(l1 != null) {
      // 上面加法考虑的东西这里也要考虑
      int sum = l1.val + ten;
      if (ten > 0) {
        ten--;
      }
      if (sum >= 10) {
        ten++;
        sum -= 10;
      }
      result.next = new ListNode(sum);
      result = result.next;
      l1 = l1.next;
    }

    while(l2 != null) {
      int sum = l2.val + ten;
      if (ten > 0) {
        ten--;
      }
      if (sum >= 10) {
        ten++;
        sum -= 10;
      }
      result.next = new ListNode(sum);
      result = result.next;
      l2 = l2.next;
    }

    // 这个忘记了
    if (ten > 0) {
      result.next = new ListNode(1);
      result = result.next;
    }

    return head.next;
  }

  public static void main(String[] args) {
    int [] arr1 = {1}; // 3
    int [] arr2 = {9,9}; // 3


    ListNode l1 = ListNode.createLinkedList(arr1);
    ListNode l2 = ListNode.createLinkedList(arr2);


    AddTwoNumbers_2 demo = new AddTwoNumbers_2();
    ListNode.printLinkedList(demo.addTwoNumbers(l1, l2));


  }
}
