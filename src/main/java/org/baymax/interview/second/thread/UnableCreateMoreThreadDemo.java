package org.baymax.interview.second.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/18 11:24
 */
public class UnableCreateMoreThreadDemo {
  public static void main(String[] args) {
    for (int i = 1; ; i++) {
      System.out.println("************** i = " + i);

      new Thread(() -> {
        try {
          TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }, ""+i).start();
    }
  }
}
