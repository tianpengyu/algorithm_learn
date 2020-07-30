package org.baymax.interview.algorithm.linkedList;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/30 13:02
 */
public class SortList_148 {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummyHead = new ListNode(0);

    dummyHead.next = head;

    ListNode mid = findMid(dummyHead);

    ListNode secondHead = mid.next;
    mid.next = null;

    ListNode firstHead = sortList(dummyHead.next);

    secondHead = sortList(secondHead);

    return merge(firstHead, secondHead);

  }

  private ListNode merge(ListNode firstHead, ListNode secondHead) {
    ListNode first = firstHead;
    ListNode second = secondHead;
    ListNode dummyHead = new ListNode(-1);
    ListNode cur = dummyHead;


    while (first != null && second != null) {
      ListNode smallerOne = null;
      if (first.val <= second.val) {
        smallerOne = first;
        first = first.next;
      } else {
        smallerOne = second;
        second = second.next;
      }
      cur.next = smallerOne;
      cur = cur.next;
    }

    // 这个优化 要记住 和数字不一样 不需要在遍历了

    cur.next = first != null ? first : second;

    return dummyHead.next;
  }

  private ListNode findMid(ListNode dummyHead) {
    ListNode first = dummyHead;
    ListNode second = dummyHead;
    while (second != null && second.next != null) {
      first = first.next;
      second = second.next.next;
    }
    return first;
  }

  public static void main(String[] args) {
    int [] arr = {2,1,4,5};
    ListNode head = ListNode.createLinkedList(arr);
    SortList_148 demo = new SortList_148();
    ListNode.printLinkedList(demo.sortList(head));
  }
}
