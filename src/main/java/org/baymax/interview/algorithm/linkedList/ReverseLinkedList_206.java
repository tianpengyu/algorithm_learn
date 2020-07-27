package org.baymax.interview.algorithm.linkedList;

/**
 * input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * output: 5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 *
 * 分析:
 * pre     cur       next
 *  |       |         |
 * null -   1         2        3
 *
 *         pre       cur      next
 *          |         |        |
 * null     1         2        3
 *
 * 常见问题：
 * 1. 容易 丢失 next ： 所以需要 next
 * 2. 容易 丢失 上一个 所以需要 pre
 *
 * 通常是不能改变链表中的 值
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/27 13:25
 */
public class ReverseLinkedList_206 {

}
