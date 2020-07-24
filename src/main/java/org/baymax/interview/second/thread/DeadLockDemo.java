package org.baymax.interview.second.thread;

import java.util.concurrent.TimeUnit;

/**
 * 排查：
 *
 * ps -ef | grep xxxx
 * jps : java 运行程序，查看进程的命令; 查看进程号
 * jstack : 查看 进程状态死锁
 *
 *
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/24 07:48
 */
public class DeadLockDemo {
  public static void main(String[] args) {

    String lockA = "lockA";

    String lockB = "lockB";

    new Thread(new MyThreadDead(lockA, lockB), "AAAAAA").start();

    // 都让一个线程池有 就不会死锁，要一个线程持有一个才可以，所以不可 sleep
    // try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

    new Thread(new MyThreadDead(lockB, lockA), "BBBBBB").start();


  }
}



class MyThreadDead implements Runnable {
  private String lockA;
  private String lockB;

  public MyThreadDead(String lockA, String lockB) {
    this.lockA = lockA;
    this.lockB = lockB;
  }

  @Override
  public void run() {

    synchronized (lockA) {

      System.out.println(Thread.currentThread().getName() + "\t 已经获取 "+ lockA +"， 尝试获取 "+ lockB);

      try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

      synchronized (lockB) {
        System.out.println(Thread.currentThread().getName() + "\t 已经获取 " + lockB +", 此时 同时获取 两个锁");
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

      }

      System.out.println(Thread.currentThread().getName() + "\t 已经释放"+lockB);

    }

    System.out.println(Thread.currentThread().getName() + "\t 已经释放 " + lockA);

  }
}
