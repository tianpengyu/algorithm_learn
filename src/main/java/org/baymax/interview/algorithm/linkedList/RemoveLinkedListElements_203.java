package org.baymax.interview.algorithm.linkedList;

/**
 * 删除指定 val 的 节点
 *
 * 1 -> 2 -> 3 -> 4 (null) , 3
 *
 * 1 -> 2 ------> 4 ()null
 *               /\
 *           3 ==||
 *
 *  cur : 2 （cur.next.val == 3 && cur.next != null）
 *  delNode = cur.next
 *
 *  cur.next = delNode.next
 *
 *  即使 delNode .next == null 也可以
 *
 *
 *  但是上面的逻辑对第一个元素不适用，还没有虚拟头节点
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 13:31
 */
public class RemoveLinkedListElements_203 {

  public ListNode removeElements(ListNode head, int val) {

    ListNode dummyHead = new ListNode(-1);

    dummyHead.next = head;

    ListNode cur = dummyHead;

    while (cur.next != null) {

      if (cur.next.val == val) {
        ListNode delNode = cur.next;
        cur.next = delNode.next;
        // do not move to next
      } else {
        cur = cur.next;
      }

    }

    return dummyHead.next;
  }





    /**
     * 没有虚拟头节点时
     * @param head
     * @param val
     * @return
     */
  public ListNode removeElementsNoDummyHead(ListNode head, int val) {

    /**
     * 因为没有 虚拟头节点所以需要考虑头节点
     * 1. 如果头节点没有前一个
     * 2. 头节点为空
     * 3. 连续头节点
     * 4. 更新了 head, 每次使用 head 都要判读 head 是否为 null
    */
    while (head != null && head.val == val) {
      head = head.next;
    }

    if (head == null) {
      return head;
    }

    // 非头节点

    ListNode cur = head;

    while (cur.next != null) {
      if (cur.next.val == val) {
        ListNode delNode = cur.next;
        cur.next = delNode.next;
        cur = cur.next;
      } else {
        cur = cur.next;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    int [] arr = {1,1};

    ListNode head = ListNode.createLinkedList(arr);
    ListNode.printLinkedList(head);

    System.out.println("================");

    RemoveLinkedListElements_203 demo = new RemoveLinkedListElements_203();
    head = demo.removeElements(head, 1);
    ListNode.printLinkedList(head);
  }


}
