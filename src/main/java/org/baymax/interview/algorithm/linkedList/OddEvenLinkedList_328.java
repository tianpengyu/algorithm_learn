package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 19:07
 */
public class OddEvenLinkedList_328 {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummyHead = new ListNode(0);

    dummyHead.next = head;
    ListNode cur = head;


    ListNode first =  new ListNode(0);
    ListNode firstTail =  cur ;

    ListNode second =  new ListNode(0);
    ListNode secondTail =  cur.next;

    cur = cur.next.next;
    firstTail.next = null;
    secondTail.next = null;

    first.next = firstTail;
    second.next = secondTail;

    int count = 3;

    while (cur != null) {
      ListNode next = cur.next;
      cur.next = null;

      if (count % 2 != 0) {
        firstTail.next = cur;
        firstTail = firstTail.next;
      } else {
        secondTail.next = cur;
        secondTail = secondTail.next;
      }
      cur = next;
      count++;
    }



    firstTail.next = second.next;
    dummyHead.next = first.next;
    return dummyHead.next;
  }

  public static void main(String[] args) {
    int [] arr = {2,1,3,5,6,4,7}; // 3

    ListNode head = ListNode.createLinkedList(arr);

    OddEvenLinkedList_328 demo = new OddEvenLinkedList_328();
    ListNode.printLinkedList(demo.oddEvenList(head));
  }
}
