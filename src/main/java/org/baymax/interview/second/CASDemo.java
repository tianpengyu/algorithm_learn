package org.baymax.interview.second;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  CAS :
 *    比较并交换
 *
 *
 *
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/18 17:11
 */
public class CASDemo {
  public static void main(String[] args) {
    AtomicInteger atomicInteger = new AtomicInteger(7);


    System.out.println(atomicInteger.compareAndSet(7, 81) + ", current value: " + atomicInteger.get());

    System.out.println(atomicInteger.compareAndSet(7, 2) + ", current value: " + atomicInteger.get());

    atomicInteger.getAndIncrement();


  }
}
