package org.baymax.interview.second.jvm;

import java.util.Random;

/**
 * -XX:InitialHeapSize=10485760
 * -XX:MaxHeapSize=10485760
 * -XX:+PrintCommandLineFlags
 * -XX:+PrintGCDetails
 * -XX:+UseCompressedClassPointers
 * +XX:+UseCompressedOops
 * +XX:+UseG1GC
 * -XX:-UseLargePagesIndividualAllocation
 *
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/24 15:43
 */
public class GCCollectorDemo {
  public static void main(String[] args) {
    String str = "baymax";

    while (true) {
      str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
      str.intern();
    }
  }
}
