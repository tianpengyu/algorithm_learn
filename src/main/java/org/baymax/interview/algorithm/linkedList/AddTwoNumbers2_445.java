package org.baymax.interview.algorithm.linkedList;

import java.util.Stack;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 20:03
 */
public class AddTwoNumbers2_445 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    Stack<ListNode> stack1 = new Stack<>();
    Stack<ListNode> stack2 = new Stack<>();
    Stack<ListNode> resultStack = new Stack<>();


    while (l1 != null) {
      stack1.add(l1);
      l1 = l1.next;
    }

    while (l2 != null) {
      stack2.add(l2);
      l2 = l2.next;
    }
    int ten = 0;

    while (true) {

      if (stack1.empty() || stack2.empty()) {
        break;
      }
      ListNode a1 = stack1.pop();
      ListNode a2 = stack2.pop();
      int sum = a1.val + a2.val + ten;
      if (ten > 0) {
        ten--;
      }
      if (sum >= 10) {
        sum -= 10;
        ten++;
      }
      ListNode result = new ListNode(sum);
      resultStack.add(result);
    }

    while (!stack1.empty()) {
      ListNode a1 = stack1.pop();
      int sum = a1.val + ten;
      if (ten > 0) {
        ten--;
      }
      if (sum >= 10) {
        sum -= 10;
        ten++;
      }
      ListNode result = new ListNode(sum);
      resultStack.add(result);
    }

    while (!stack2.empty()) {
      ListNode a2 = stack2.pop();
      int sum = a2.val + ten;
      if (ten > 0) {
        ten--;
      }
      if (sum >= 10) {
        sum -= 10;
        ten++;
      }
      ListNode result = new ListNode(sum);
      resultStack.add(result);
    }

    if (ten > 0) {
      resultStack.add(new ListNode(1));
    }

    ListNode dummyHead = new ListNode(0);

    if (!resultStack.empty()) {
      dummyHead.next = resultStack.pop();
    }

    ListNode tail = dummyHead.next;

    while (!resultStack.empty()) {
      tail.next = resultStack.pop();

      tail = tail.next;
    }

    return dummyHead.next;
  }

  public static void main(String[] args) {
    int[] arr1 = {7, 2, 4, 3};
    int[] arr2 = {5, 6, 4};

    ListNode l1 = ListNode.createLinkedList(arr1);

    ListNode l2 = ListNode.createLinkedList(arr2);

    AddTwoNumbers2_445 demo = new AddTwoNumbers2_445();

    ListNode.printLinkedList(demo.addTwoNumbers(l1, l2));

  }
}
