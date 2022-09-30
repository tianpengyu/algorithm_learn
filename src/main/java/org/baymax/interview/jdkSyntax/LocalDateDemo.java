package org.baymax.interview.jdkSyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2021/4/1 11:35
 */
public class LocalDateDemo {
  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

  public static void main(String[] args) {
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime.format(formatter));

  }
}
