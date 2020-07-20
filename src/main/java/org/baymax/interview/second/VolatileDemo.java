package org.baymax.interview.second;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile : JVM 提供的 轻量级的同步机制
 *
 * 1. 验证 volatile 的可见性
 * 1-1 假设 number 前面没有添加 volatile
 * 1-2 添加了 volatile 解决了可见性
 * <p>
 * 2. volatile 不保证原子性：
 * 2-1 原子性：不可分割，完整性，某哥线程正在做某个业务时，中间不可以被分割或加塞
 *
 *  2-2 why?
 *   i++：
 *      a. 从主内存中读取到 自己的 工作内存中
 *      b.操作
 *      c. 写回主内存
 *
 *  2-3 如何保证 原子性 ：atomic
 *
 *
 *
 *  3 禁止指令重拍
 *
 *
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/18 09:14
 */
public class VolatileDemo {

  public static void main(String[] args) {

//    testNoVolatile();

//    testHasVolatile();

    testAtomic();


  }

  /**
   * 不保证原子性 案例演示
   */
  private static void testAtomic() {

    MyDataWithVolatile myData = new MyDataWithVolatile()   ;

    for (int iThread = 1; iThread <= 20; iThread++) {

      new Thread(() -> {
        for (int i = 1 ; i <= 1000; i++) {
          myData.addPlusPlus();
          myData.addAtomic();

        }
      }, String.valueOf("第 " + iThread + " 线程")).start();

    }

    while (Thread.activeCount() > 2) {
      Thread.yield();
    }

    System.out.println(Thread.currentThread().getName() + "\t finale value:" + myData.number);
    System.out.println(Thread.currentThread().getName() + "\t finale atomic value:" + myData.atomicInteger.get());


  }

  private static void testHasVolatile() {

    MyDataWithVolatile myData = new MyDataWithVolatile();

    new Thread(() -> {

      System.out.println(Thread.currentThread().getName() + "\t come in.");

      try {
        TimeUnit.SECONDS.sleep(3);

        myData.addTo60();

        System.out.println(Thread.currentThread().getName() + "\t update mydata to 60, current value:" + myData.number);


      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }, "aaa").start();

    while (myData.number == 0) {

    }


    System.out.println(Thread.currentThread().getName() + "\t 这是主线程，退出 while 了 说明看到了 aaa 线程修改的 number 值");

  }

  private static void testNoVolatile() {
    MyData myData = new MyData();

    new Thread(() -> {

      System.out.println(Thread.currentThread().getName() + "\t come in.");

      try {
        TimeUnit.SECONDS.sleep(3);

        myData.addTo60();

        System.out.println(Thread.currentThread().getName() + "\t update mydata to 60, current value:" + myData.number);


      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }, "aaa").start();

    while (myData.number == 0) {

    }


    System.out.println(Thread.currentThread().getName() + "\t 这是主线程，退出 while 了 说明看到了 aaa 线程修改的 number 值");
  }
}


class MyData {
  int number = 0;

  public void addTo60() {
    this.number = 60;
  }

  public void addPlusPlus() {
    this.number++;
  }
}

class MyDataWithVolatile {
  volatile int number = 0;

  AtomicInteger atomicInteger = new AtomicInteger();

  public void addTo60() {
    this.number = 60;
  }

  public void addPlusPlus() {
    this.number++;
  }

  public void addAtomic() {
    atomicInteger.getAndIncrement();
  }
}