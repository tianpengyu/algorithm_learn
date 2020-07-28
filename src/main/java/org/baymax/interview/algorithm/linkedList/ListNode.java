package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 13:14
 */
public class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  public static  ListNode createLinkedList(int[] arr) {
    if (arr == null || arr.length ==0) {
      return null;
    }

    ListNode head = new ListNode(arr[0]);

    ListNode curNode = head;

    for (int i = 1; i <= arr.length-1; i++){
      curNode.next = new ListNode(arr[i]);
      curNode = curNode.next;
    }
    return head;
  }

  public static void printLinkedList(ListNode head) {
    ListNode curNode = head;
    while (curNode != null) {
      System.out.print(curNode.val + " -> ");
      curNode = curNode.next;
    }
    System.out.println("null");
  }
}
