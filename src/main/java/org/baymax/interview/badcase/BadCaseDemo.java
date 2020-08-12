package org.baymax.interview.badcase;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * 极客时间 - Java 业务开发常见错误 100 例
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/10 14:49
 */
public class BadCaseDemo {

  private static int THREAD_COUNT = 10;// 总元素数量

  private static int ITEM_COUNT = 1000;// 帮助方法，用来获得一个指定元素数量模拟数据的 ConcurrentHashMap

  private ConcurrentHashMap getData(int count) {
    return LongStream.
        rangeClosed(1, count)
        .boxed()
        .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(), (o1, o2) -> o1, ConcurrentHashMap::new));
  }

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("tpy", "xdc");

    BadCaseDemo demo = new BadCaseDemo();

    int input = 5;
    System.out.println("input:" + input);
    int n = -1 >>> Integer.numberOfLeadingZeros(input);

    System.out.println(n);

    System.out.println( (n < 0) ? 1 :  n + 1 );
  }

}
