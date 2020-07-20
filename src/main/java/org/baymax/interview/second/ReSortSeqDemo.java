package org.baymax.interview.second;

/**
 * 指令重排案例
 * 两个线程 同事操作 ReSortSeqDemo的 一个实例
 * 一个线程执行 setTrue
 * 另一个线程执行 add
 *
 * setTrue 中 可能会对 a , flag 重排序： 先执行，flag 赋值后 线程刮起 此时 另一个线程执行 add 这是 flag 是 true 但是 a = 0 所以最后 a = 5 而不是 a = 6
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/18 11:18
 */
public class ReSortSeqDemo {
  int a = 0;
  boolean flag = false;

  public void setTrue() {
    a = 1;
    flag = true;
  }

  public void add() {
    if (flag) {
      a = a + 5;
      System.out.println("*********retValue:" + a);
    }
  }
}
