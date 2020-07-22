package org.baymax.interview.algorithm;

/**
 * 跳表
 * 二分搜索 依赖：1. 有序 2. 数组的随机访问
 * 如果数据存储在链表中，就真的没法用二分查找算法了吗？
 * 实际上，我们只需要对链表稍加改造，就可以支持类似 “二分” 的查找算法。我们把改造之后的数据结构叫作跳表（Skip list）
 * 一种各方面性能都比较优秀的动态数据结构，可以支持快速的插入、删除、查找操作，写起来也不复杂，甚至可以替代红黑树（Red-black tree）。
 * Redis 中的有序集合（Sorted Set）就是用跳表来实现的
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/1 14:37
 */
public class SkipList {
}
