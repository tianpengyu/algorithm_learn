package org.baymax.interview.algorithm.linkedList;

/**
 * 不要用断开的方法 这样不好
 * 不一定要改变原来的 返回
 * 可以构建一个新的链表 把 原来链表中符合条件的找出来，一次尾插到 新的结果中
 *
 * 循环不变量：[l ... r) 如果长度是1 则把 l 尾插 否则 l = r 继续处理 因为 l == r 所以 while 一定会走
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 23:05
 */
public class DeleteDuplicates2_82 {
  public static ListNode deleteDuplicates(ListNode head) {

    if (head == null) return head;  // 若head为空则直接返回null
    ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
    ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
    for (ListNode l = head, r = head; l != null; l = r) {
      while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
      if (l.next == r) {  // 若长度为1，则通过尾插法加入。
        tail.next = l;  // 基本的尾插法
        tail = l;
        tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
      }
    }
    return dummy.next;

//
//
//    if (head == null) {
//      return head;
//    }
//
//    ListNode dummyHead = new ListNode(0);
//
//    ListNode tail = dummyHead;
//
//
//    // [l ... r) 的插入到 dummyHead 尾部
//    for (ListNode l = head, r = head; l != null; l = r) {
//      while (r != null && r.val == l.val) {
//        r = r.next;
//      }
//
//      if (l.next != r) {
//        tail.next = l;
//        tail = l;
//        l.next = null;
//      }
//    }
//
//    return dummyHead.next;
  }


  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 2, 3, 5};
    ListNode head = ListNode.createLinkedList(arr);

    ListNode.printLinkedList(deleteDuplicates(head));
  }
}
