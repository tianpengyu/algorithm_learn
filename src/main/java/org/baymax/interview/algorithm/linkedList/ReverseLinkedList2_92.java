package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/27 22:32
 */
public class ReverseLinkedList2_92 {


  public ListNode reverseBetween(ListNode head, int m, int n) {

    int count = 0;

    ListNode pre = null;
    ListNode cur = head;
    ListNode next = null;

    ListNode reverseHead = null;
    ListNode reverseTail = null;
    ListNode reverseHeadPre = null;


    while (cur != null) {
      count++;
      if (count >= n) {
        next = cur.next;
        reverseTail = cur;
        cur.next = pre;
        reverseHead = pre;
        reverseHead.next = cur;
        reverseTail.next = next;
        reverseHeadPre.next = reverseHead;
        break;
      }
      if (count == m) {
        reverseTail = cur;
        reverseHeadPre = pre;
        pre.next = null;
      }

      if (count >= m) {
        next = cur.next;

        cur.next = pre;
        pre = cur;
        cur = next;

      } else {
        next = cur.next;

        pre = cur;
        cur = next;


      }
    }
    return head;

  }

  public static void main(String[] args) {
    ListNode head = null;
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);

    head = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;


    ReverseLinkedList2_92 demo = new ReverseLinkedList2_92();
    head = demo.reverseBetween(head, 2, 4);
    System.out.println("end");





  }
}
