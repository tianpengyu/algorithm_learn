package org.baymax.algorithmlearn.link;

import org.baymax.algorithmlearn.linkedList.LinkedNode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/6/23 18:56
 */
@SpringBootTest
public class LinkedNodeTest {

  @Test
  public void testReverse() {
    LinkedNode<Integer> head = LinkedNode.newInstance();
    head.genChild(1);
    head.next.genChild(2);
    head.next.next.genChild(3);
    head.next.next.next.genChild(4);

    head.printNode();
    LinkedNode result = head.reverse();
    result.printNode();
  }

  @Test
  public void testHasCycle() {
    LinkedNode<Integer> head = LinkedNode.newInstance();
    head.genChild(1);
    head.next.genChild(2);
    head.next.next.genChild(3);
    head.next.next.next.genChild(4);
    head.next.next.next.next.genChild(5);
    head.next.next.next.next.next.genChild(6);
    head.next.next.next.next.next.next.genChild(7);
    head.next.next.next.next.next.next.next = head.next.next;
    Assert.assertTrue(head.hasCycle());
  }

}
