package org.baymax.interview.algorithm.stack;

import java.util.Stack;

/**
 *
 * 栈顶元素反映了在嵌套的层次关系中，【最近】的需要匹配的元素
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/31 12:34
 */
public class StackDemo {
  public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Stack<Character> stack = new Stack();

    for (int i = 0; i < s.length(); i++) {
      if (isLeft(s.charAt(i))) {
        stack.push(s.charAt(i));
      } else {
        Character lastLeft = stack.pop();
        if(notMatch(lastLeft, s.charAt(i))) {
          return false;
        }

      }
    }
    if (stack.isEmpty()) {
      return true;
    }
    return false;
  }

  private boolean notMatch(Character lastLeft, Character right) {
    switch (right) {
      case '}':
        return lastLeft.equals('{');
      case ']':
        return lastLeft.equals('[');
      case ')':
        return lastLeft.equals('(');
      default:
        return false;
    }
  }

  private boolean isLeft(Character c) {
    return c.equals('{') || c.equals('[') ||c.equals('(');
  }

  public static void main(String[] args) {
    String s="{()}";
    StackDemo demo = new StackDemo();
    System.out.println(demo.isValid(s));
  }

}
