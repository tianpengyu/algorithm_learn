package org.baymax.interview.second.queue;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用阻塞队列后，没有
 * 1. lock, unlock
 * 2. await, signal
 * 3. wait, notify
 *
 * 只有阻塞队列
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/21 22:16
 */
public class ProConsumerBlockingQueueDemo {

  public static void main(String[] args) throws Exception {
    MyData myData = new MyData(new ArrayBlockingQueue<String>(5));


    new Thread(() -> {
      try {
        myData.myPro();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }, "pro").start();


    new Thread(() -> {

      try {
        myData.myCon();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }, "con").start();


    try {
      TimeUnit.SECONDS.sleep(7);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("大老板叫停");

    myData.stop();




  }
}



class MyData {
  private volatile Boolean flag;
  private AtomicInteger atomicInteger = new AtomicInteger(0);

  private BlockingQueue<String> blockingQueue;

  public MyData(BlockingQueue<String> blockingQueue) {
    this.blockingQueue = blockingQueue;
    flag = true;
    System.out.println(Thread.currentThread().getName() + "\t 传入阻塞队列：" + blockingQueue.getClass().getName());
  }

  public void myPro() throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + "\t 生产者线程启动了");
    System.out.println();
    System.out.println();
    System.out.println();

    int value ;
    boolean retValue ;

    while (flag) {

      value = atomicInteger.incrementAndGet();
      retValue = blockingQueue.offer( value+ "", 2L, TimeUnit.SECONDS);
      if (retValue) {
        System.out.println(Thread.currentThread().getName() + "\t  插入队列 " + value + "成功");
      } else {
        System.out.println(Thread.currentThread().getName() + "\t  插入队列 " + value + "失败");
      }
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

    System.out.println(Thread.currentThread().getName() + "\t 大老板叫停，表示 flag=false, 生产者退出");
  }

  public void myCon() throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + "\t 消费者线程启动了");
    System.out.println();
    System.out.println();
    System.out.println();

    String data = null;

    while (flag) {

      data = blockingQueue.poll(2L, TimeUnit.SECONDS);

      if (StringUtils.isBlank(data)) {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "\t 消费超时，或者老板叫停");
        System.out.println();
        System.out.println();
        return;
      }

      System.out.println(Thread.currentThread().getName() + "\t 消费队列成功 " + data);

    }

    System.out.println(Thread.currentThread().getName() + "\t 消费者退出");
  }

  public void stop() {
    flag = false;
  }






}
