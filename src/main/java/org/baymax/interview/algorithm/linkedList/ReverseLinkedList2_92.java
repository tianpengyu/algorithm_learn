package org.baymax.interview.algorithm.linkedList;

/**
 * 1 -> 2 -> 3 -> 4 -> 5
 *
 * 1 -> 3 -> 2 -> 4 -> 5
 *
 * 1 -> 4 -> 3 -> 2 -> 5
 *
 * 弄清楚上面的 就知道 count == n 还是 n + 1 了
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/27 22:32
 */
public class ReverseLinkedList2_92 {


  public ListNode reverseBetween(ListNode head, int m, int n) {

    if (head == null || n < m) {
      return head;
    }

    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode pre = dummy;


    for (int i = 1; i < m; i++) {
      pre = pre.next;
    }

    head = pre.next; // m

    for (int i = m; i < n; i++) {
      ListNode next = head.next;
      head.next = next.next;
      next.next = pre.next;// 这里 head  就是 cur 保持他指向的不变，所以要用 pre.next
      pre.next = next;
    }

    return dummy.next;

  }

  private void reverseBetween2(ListNode dummy, int m, int n) {
    int count = 0;

    ListNode pre = dummy;
    ListNode cur = dummy.next; // input head
    ListNode next = null;

    ListNode reverseHead = null;
    ListNode reverseHeadPre = null;


    while (cur != null) {
      count++;

      // TODO tianpengyu 2020/7/28 : 需要处理 m == 1 的情况
      if (count == m) {
        reverseHeadPre = pre;
        reverseHead = cur;
        reverseHeadPre.next = null;

        continue;

      }

      if (count == n + 1) {
        next = cur.next;
        cur.next = pre;
        reverseHeadPre.next = cur;
        reverseHead.next = next;
        break;
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
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(0);
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);

    head =  n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;


    ReverseLinkedList2_92 demo = new ReverseLinkedList2_92();
    head = demo.reverseBetween(head, 1, 5);
    System.out.println("end");


  }
}
