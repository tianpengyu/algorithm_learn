package org.baymax.interview.algorithm.linkedList;

/**
 * 循环不变式：
 * 新的循环开始时
 * 1. count: 当前需要处理的 下标
 * 2. cur: 当前需要处理的 node,
 * 3. next 和 cur 一致
 * 4. pre: cur 的前一个
 * 5. pre 和 cur 之间【断开】
 *
 * 弄清楚上面的 就知道 count == n 还是 n + 1 了
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/27 22:32
 */
public class ReverseLinkedList2_92 {


  public ListNode reverseBetween(ListNode head, int m, int n) {

    if (head == null) {
      return head;
    }

    int count = 0;

    ListNode pre = head;
    ListNode cur = head.next;
    ListNode next = null;

    ListNode reverseHead = null;
    ListNode reverseHeadPre = null;


    while (cur != null) {
      count++;

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
    return head;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(0);
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);

    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;


    ReverseLinkedList2_92 demo = new ReverseLinkedList2_92();
    head = demo.reverseBetween(head, 1, 5);
    System.out.println("end");


  }
}
