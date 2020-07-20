package org.baymax.interview.second.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁 demo
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/19 16:13
 */
public class SpinLockDemo {

  AtomicReference<Thread> atomicReference = new AtomicReference<>();

  public void myLock() {
    Thread curThread = Thread.currentThread();
    System.out.println(Thread.currentThread().getName() + "\t invoked myLock");

    while(!atomicReference.compareAndSet(null, curThread)) {

    }

  }

  public void myUnLock() {
    Thread curThread = Thread.currentThread();
    atomicReference.compareAndSet(curThread, null);
    System.out.println(Thread.currentThread().getName() + "\t ******** invoked myUnLock");

  }

  public static void main(String[] args) {

    SpinLockDemo spinLockDemo = new SpinLockDemo();

    new Thread(() -> {

      spinLockDemo.myLock();

      try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

      spinLockDemo.myUnLock();

    }, "AAA").start();

    try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

    new Thread(() -> {

      spinLockDemo.myLock();

      spinLockDemo.myUnLock();

    }, "BBB").start();
  }



}
