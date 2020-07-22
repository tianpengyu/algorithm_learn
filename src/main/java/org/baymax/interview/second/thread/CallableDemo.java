package org.baymax.interview.second.thread;

import java.util.concurrent.Callable;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/22 22:47
 */
public class CallableDemo {
  public static void main(String[] args) {
    System.out.println(Runtime.getRuntime().availableProcessors());
  }
}


class MyThread implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    System.out.println(Thread.currentThread().getName() + "\t ************** come in callable.");
    return 1024;
  }
}
