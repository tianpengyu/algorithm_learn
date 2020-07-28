package org.baymax.interview.algorithm.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/26 23:52
 */
public class JvmParamDemo {
  public static void main(String[] args) {
    System.out.println("******* Hello GC~~~");


    try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }

  }
}
