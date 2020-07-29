package org.baymax.interview.algorithm.linkedList;

/**
 *
 * 定义清楚每一个变量的的节点的含义，这个节点到底是什么
 *
 * 循环不变式：要交换 p 后连续的两个节点
 *
 * 有些中间变量不适合在 while 外面定义和初始化 放在 while 里弄会更简单
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/29 11:54
 */
public class SwapPairs_24 {
  public static  ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummyHead = new ListNode(0);

    dummyHead.next = head;

    ListNode p = dummyHead;

    // 要交换 p 后连续的两个节点，所以要保证 有两个节点
    while (p.next != null && p.next.next != null) {
      // 放在这个定义吧 会简单些
      ListNode node1 = p.next;
      ListNode node2 = node1.next;
      ListNode next = node2.next;

      node2.next = node1;
      node1.next = next;
      p.next = node2;

      p = node1;
    }

    return dummyHead.next;
  }

  public static void main(String[] args) {
    int [] arr = {1,2,3,4,5,6,7};
    ListNode head = ListNode.createLinkedList(arr);

    ListNode.printLinkedList(SwapPairs_24.swapPairs(head));
  }
}
