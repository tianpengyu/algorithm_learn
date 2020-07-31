package org.baymax.interview.algorithm.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 逆波兰 表达式求解
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/31 15:49
 */
public class EvalRPN_150 {

  private Set<String> operators = new HashSet<String>(){{
    add("+");
    add("-");
    add("*");
    add("/");
  }};

  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }

    Stack<Integer> numberStack = new Stack<>();

    for (String cur : tokens) {
      if (isOperator(cur)) {
        Integer num2 = numberStack.pop();
        Integer num1 = numberStack.pop();
        Integer result = cal(num1, num2, cur);
        numberStack.push(result);
      } else {
        // number
        numberStack.push(Integer.valueOf(cur));
      }
    }

    return numberStack.pop();
  }

  private Integer cal(Integer num1, Integer num2, String operator) {
    switch (operator) {
      case "+":
        return num1 + num2;

      case "-":
        return num1 - num2;

      case "*":
        return num1 * num2;

      case "/":
        return num1 / num2;

      default:
        return 1;
    }
  }

  private boolean isOperator(String cur) {
    return operators.contains(cur);
  }

  public static void main(String[] args) {
    System.out.println(13/5);
    String [] tokens = {"4", "13", "5", "/", "+"};

    EvalRPN_150 demo = new EvalRPN_150();

    System.out.println(demo.evalRPN(tokens));

  }

}
