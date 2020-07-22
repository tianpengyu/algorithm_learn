package org.baymax.interview.second.queue;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 传统版 生产者 - 消费者
 * JUC 之前的 版本
 * <p>
 * 一个初始值为零的变量，两个线程交替操作，一个加一 一个减一，来5轮
 * <p>
 * 多线程的企业级模版口诀：
 * （高并发 ， 高内聚 低耦合的前提下）
 * 上联：线程        操纵(方法)          资源类
 * 下联：判断        干活          唤醒通知
 * 横批：防止 多线程并发下的虚假唤醒 （用 while 判断 不要用 if）
 * <p>
 * 包含的知识不下 8 个
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/20 22:32
 */
public class ProConsumerTraditionalDemo {

  public static void main(String[] args) {

    ShareData shareData = new ShareData();

    new Thread(() -> {

      for (int i = 1; i <= 5; i++) {
        shareData.increment();
      }

    }, "生产者线程").start();

    new Thread(() -> {

      for (int i = 1; i <= 5; i++) {
        shareData.decrement();
      }

    }, "消费者线程").start();

    new Thread(() -> {

      for (int i = 1; i <= 5; i++) {
        shareData.increment();
      }

    }, "生产者线程2222222").start();

    new Thread(() -> {

      for (int i = 1; i <= 5; i++) {
        shareData.decrement();
      }

    }, "消费者线程2222222").start();



  }
}


/**
 * 共享的资源类，有不同的线程共享并操作
 */
@Data
class ShareData {
  private Integer number = 0;
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  public void increment() {
    // 对同步代码块 进行加锁
    lock.lock();

    try {

      // 1. 判断 (为了防止虚假的唤醒机制 要用 while)
      while (number != 0) {

        // 等待，不能生产
        condition.await();

      }

      // 2. 干活
      number++;
      System.out.println(Thread.currentThread().getName() + "\t " + number);

      // 3. 通知唤醒
      condition.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void decrement() {
    // 对同步代码块 进行加锁
    lock.lock();

    try {

      // 1. 判断 (为了防止虚假的唤醒机制 要用 while)
      while (number == 0) {

        // 等待，不能消费
        condition.await();

      }

      // 2. 干活 - 消费
      number--;
      System.out.println(Thread.currentThread().getName() + "\t " + number);

      // 3. 通知唤醒
      condition.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

}
