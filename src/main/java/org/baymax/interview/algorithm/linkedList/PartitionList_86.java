package org.baymax.interview.algorithm.linkedList;

/**
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 *
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
    ListNode firstPre = dummyHead;
    ListNode cur = dummyHead.next;

    while(cur != null) {
      if (cur.val >= x) {
        break;
      }

      firstPre = cur;
      cur = cur.next;
    }

    ListNode first = cur;
    ListNode pre = firstPre;


    while (cur != null) {
      if (cur.val < x) {
        firstPre.next = cur;
        cur = cur.next;
        // 1. 这里忘记了导致出现循环了，就是当前处理节点的前一个节点忘记维护了，所以补了一个这个用来记录前一个节点
        pre.next = cur;

        firstPre = firstPre.next;
        firstPre.next = first;
      } else {
        // 1. 这里忘记了导致出现循环了，就是当前处理节点的前一个节点忘记维护了
        pre = cur;
        cur = cur.next;
      }
    }

    return dummyHead.next;
  }


  public static void main(String[] args) {
    int [] arr = {1, 4, 3, 2, 5, 2}; // 3

    ListNode head = ListNode.createLinkedList(arr);

    PartitionList_86 demo = new PartitionList_86();
    ListNode.printLinkedList(demo.partition(head, 3));

  }

}
