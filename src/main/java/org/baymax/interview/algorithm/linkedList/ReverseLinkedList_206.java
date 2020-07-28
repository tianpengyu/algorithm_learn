package org.baymax.interview.algorithm.linkedList;

/**
 * input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * output: 5 -> 4 -> 3 -> 2 -> 1 -> null
 * <p>
 * <p>
 * 分析:
 * pre     cur       next
 * |       |         |
 * null -   1         2        3
 * <p>
 * pre       cur      next
 * |         |        |
 * null     1         2        3
 * <p>
 * 常见问题：
 * 1. 容易 丢失 next ： 所以需要 next
 * 2. 容易 丢失 上一个 所以需要 pre
 * <p>
 * 通常是不能改变链表中的 值
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/27 13:25
 */
public class ReverseLinkedList_206 {
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode(int x) { val = x; }
   * }
   */
  public ListNode reverseList(ListNode head) {

    /**
     * 因为 要用 cur.next 所以先保证 cur != null 这里可以在 进入的时候判断，也可以在 while 中判断，后者更好一点，这样直接吧 next = cur.next
     * 放在 while 第一行， 也不用在判断 next 是否为 null
     */
    ListNode pre = null;
    ListNode cur = head;
    ListNode next = null;

    while (cur != null) {
      next = cur.next;

      cur.next = pre;
      pre = cur;
      cur = next;

    }

    return pre;
  }

}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
