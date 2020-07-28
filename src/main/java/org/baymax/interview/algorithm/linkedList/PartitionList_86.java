package org.baymax.interview.algorithm.linkedList;

/**
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 *
 * 链表节点的交换
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 14:56
 */
public class PartitionList_86 {

  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummyHead = new ListNode(0);

    dummyHead.next = head;





    return dummyHead.next;

  }

}
