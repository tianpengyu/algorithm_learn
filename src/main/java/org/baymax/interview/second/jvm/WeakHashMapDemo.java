package org.baymax.interview.second.jvm;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/14 14:10
 */
public class WeakHashMapDemo {
  public static void main(String[] args) {
    WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();

    Integer key =  new Integer(1);

    String value = "weakHashMap";

    weakHashMap.put(key, value);


    System.gc();
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    System.out.println(weakHashMap);
  }
}
