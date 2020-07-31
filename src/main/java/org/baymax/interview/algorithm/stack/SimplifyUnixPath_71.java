package org.baymax.interview.algorithm.stack;

import java.util.*;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/31 16:11
 */
public class SimplifyUnixPath_71 {

  private String root = "/";
  private String dot = ".";
  private String doubleDot = "..";


  public String simplifyPath(String path) {
    if (path == null || path.length() == 0) {
      return path;
    }

    Stack<String> stack = new Stack();

    String [] arr = path.split("/+");
    for (String s : arr) {

      if (s == null || s.length() == 0) {
        continue;
      }

      if (isDot(s)) {
        continue;
      }

      if (isDoubleDot(s)) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
        continue;
      }

      stack.push(s);
    }

    // 1. 学到了
//    Collections.reverse(stack);

    // 2. 学到了 StringBuilder 会更快
    return "/"+ String.join("/", stack);
  }


  private boolean isDot(String c) {
    return dot.equals(c);
  }

  private boolean isDoubleDot(String c) {
    return doubleDot.equals(c);
  }

  public static void main(String[] args) {
    String path = "/home//foo/";
    SimplifyUnixPath_71 demo = new SimplifyUnixPath_71();
    System.out.println(demo.simplifyPath(path));
  }
}
