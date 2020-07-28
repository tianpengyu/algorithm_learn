package org.baymax.interview.second.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/28 08:47
 */
public class GCParamDemo {
  public static void main(String[] args) {
//    try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }


    long totalMemory = Runtime.getRuntime().totalMemory(); // 1 / 64
    long maxMemory = Runtime.getRuntime().maxMemory(); // 1/ 4
    System.out.println("TOTAL MEMORY (-Xms) = " + totalMemory +"(字节)" + (totalMemory / (double) 1024 / 1024) + " MB");
    System.out.println("MAX MEMORY (-Xmx) = " + maxMemory +"(字节)" + (maxMemory / (double) 1024 / 1024) + " MB");


    System.out.println("end");

  }
}
