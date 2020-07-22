package org.baymax.interview.second.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueue 接口 和 List 接口是平级的 所以 ArrayList ， ArrayBlockingQueue; LinkedList LinkedBlockingQueue
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/20 21:45
 */
public class BlockingQueueDemo {

  public static void main(String[] args) throws InterruptedException {

//    testThrowExceptionMethods();

//    testReturnBooleanMethods();
//
//    testBlockingMethods();

    testTimeOutBlockingMethods();


  }

  private static void testTimeOutBlockingMethods() throws InterruptedException {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

    System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));


    System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));





  }

  private static void testBlockingMethods() throws InterruptedException {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

    blockingQueue.put("a");
    blockingQueue.put("a");
    blockingQueue.put("a");
    // blockingQueue.put("blocking");
    System.out.println("===============");

    blockingQueue.take();
    blockingQueue.take();
    blockingQueue.take();
    // blockingQueue.take();
    System.out.println("---------------");

  }

  private static void testReturnBooleanMethods() {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

    System.out.println(blockingQueue.offer("a"));
    System.out.println(blockingQueue.offer("b"));
    System.out.println(blockingQueue.offer("c"));
    System.out.println(blockingQueue.offer("x")); // false

    System.out.println(blockingQueue.peek());

    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
  }

  private static void testThrowExceptionMethods() {
    // 类比：List list = new ArrayList<>();
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

    System.out.println(blockingQueue.add("a"));
    System.out.println(blockingQueue.add("b"));
    System.out.println(blockingQueue.add("c"));
//    System.out.println(blockingQueue.add("x")); // IllegalStateException: Queue full


    System.out.println(blockingQueue.remove());
    System.out.println(blockingQueue.remove());
    System.out.println(blockingQueue.remove());
//    System.out.println(blockingQueue.remove()); // NoSuchElementException




  }
}
