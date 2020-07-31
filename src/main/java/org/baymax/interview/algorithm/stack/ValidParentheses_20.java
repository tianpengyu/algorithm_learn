package org.baymax.interview.algorithm.stack;

import java.util.Stack;

/**
 * { [ ( ) ] }
 *
 * 判定括号匹配是否合法
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/31 12:34
 */
public class ValidParentheses_20 {

  public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Stack<Character> stack = new Stack();

    for (int i = 0; i < s.length(); i++) {
      if (isLeft(s.charAt(i))) {
        stack.push(s.charAt(i));
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        Character lastLeft = stack.pop();
        if(!match(lastLeft, s.charAt(i))) {
          return false;
        }

      }
    }
    if (stack.isEmpty()) {
      return true;
    }
    return false;
  }

  private boolean match(Character lastLeft, Character right) {
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
    ValidParentheses_20 demo = new ValidParentheses_20();
    System.out.println(demo.isValid(s));
  }
}
