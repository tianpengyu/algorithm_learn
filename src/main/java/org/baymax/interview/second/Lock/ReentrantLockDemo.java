package org.baymax.interview.second.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：
 * 多线程之间 按顺序调用，实现 A -> B -> C 三个线程的启动，要求如下：
 * AA 打印 5次， BB 打印 10 次， CC 打印 15 次
 * 紧接着
 * AA 打印 5次， BB 打印 10 次， CC 打印 15 次
 * ...
 * <p>
 * 来 10 轮
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/20 23:20
 */
public class ReentrantLockDemo {

  public static void main(String[] args) {
    ShareResource shareResource = new ShareResource();

    new Thread(() -> {

      for( int i = 1; i<= 10; i++) {
        shareResource.print5();
      }

    }, "AA").start();

    new Thread(() -> {


      for( int i = 1; i<= 10; i++) {
        shareResource.print10();
      }
    }, "BB").start();

    new Thread(() -> {


      for( int i = 1; i<= 10; i++) {
        shareResource.print15();
      }
    }, "CC").start();
  }


}

class ShareResource {
  private int number = 1; // AA：1， BB：2， CC:3
  private Lock lock = new ReentrantLock();
  Condition c1 = lock.newCondition();
  Condition c2 = lock.newCondition();
  Condition c3 = lock.newCondition();

  public void print5() {
    lock.lock();

    try {
      // while
      while (number != 1) {
        c1.await();
      }

      for (int i = 1; i <= 5; i++) {
        System.out.println(Thread.currentThread().getName() + "\t ");
      }

      number = 2;
      c2.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void print10() {
    lock.lock();

    try {
      // while
      while (number != 2) {
        c2.await();
      }

      for (int i = 1; i <= 10; i++) {
        System.out.println(Thread.currentThread().getName() + "\t ");
      }

      number = 3;
      c3.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void print15() {
    lock.lock();

    try {
      // while
      while (number != 3) {
        c3.await();
      }

      for (int i = 1; i <= 15; i++) {
        System.out.println(Thread.currentThread().getName() + "\t ");
      }

      number = 1;
      c1.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }

  }


}
