package org.baymax.interview.algorithm.linkedList;

import java.util.Objects;

/**
 * 经常用来检查链表是否正确的边界 4 个边界条件：
 * 1. 如果链表为空时，代码是否能正常工作？
 * 2. 如果链表只包含一个节点时，代码是否能正常工作？
 * 3. 如果链表只包含两个节点时，代码是否能正常工作？
 * 4. 代码逻辑在处理头尾节点时是否能正常工作？
 * 默认是 链表都是带 head
 * @author tianpengyu
 * @version 1.0
 * @date 2020/6/23 16:18
 */
public class LinkedNode <T> {
  public T data;
  public LinkedNode<T> next;



  public static LinkedNode newInstance() {
    return new LinkedNode();
  }

  public static LinkedNode newInstance(Object data) {
    LinkedNode instance = newInstance();
    instance.data = data;
    return instance;
  }


  public LinkedNode genChild(T data) {
    LinkedNode child = newInstance(data);
    this.next = child;
    return this;
  }

  /**
   * 反转链表
   * @param head
   * @return 反转后的链表的 head
   */
  public LinkedNode reverse(LinkedNode head) {
    // 1. 这里需要 两个 not null 校验
    if (Objects.isNull(head) || Objects.isNull(head.next)) {
      return head;
    }

    // 2. 这里需要三个初始化
    LinkedNode current = head.next;

    LinkedNode before = null;

    LinkedNode next = current.next;

    // 3. 这里需要两个 not null 校验 以及 指针操作
    while (Objects.nonNull(current) && Objects.nonNull(next)) {
      current.next = before;
      before = current;
      current = next;
      next = next.next;
    }

    // 4. 对结束时 最后一个 node 的处理
    current.next = before;
    head.next = current;
    return head;
  }

  public LinkedNode reverse() {
    return reverse(this);
  }

  public void printNode() {
    if (Objects.isNull(this)) {
      System.out.print("null");
      System.out.println();
      return;
    }
    System.out.print(this.data + " -> ");
    if (Objects.nonNull(this.next)) {
      this.next.printNode();
    } else {
      System.out.print("null");
      System.out.println();
    }
  }

  /**
   * 检测环
   */
  public boolean hasCycle() {
    if (this.next == null || this.next.next == null) {
      return false;
    }
    LinkedNode one = this.next;
    LinkedNode two = this.next.next;

    while (Objects.nonNull(one) && Objects.nonNull(two)) {
      if (one == two) {
        return true;
      }

      // 1. 第一次写的时候忘记这个 判断了，这样 没有 cycle 的会 NPE
      if (Objects.isNull(two.next) || Objects.isNull(two.next.next)) {
        return true;
      }
      one = one.next;
      two = two.next.next;
    }

    return false;
  }



}
