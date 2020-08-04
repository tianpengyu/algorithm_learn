package org.baymax.interview.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/3 23:09
 */
public class LetterCombinations_17 {
  // TODO tianpengyu 2020/8/3 : remenber this
  private List<String> letterMap = new ArrayList<String>() {
    {
      add(""); // 0
      add("!@#"); // 1
      add("abc");
      add("def");
      add("ghi");
      add("jkl");
      add("mno");
      add("pqrs");
      add("tuv");
      add("wxyz"); // 9
    }
  };

  private List<String> res;

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }

    res = new ArrayList<>();

    findCombinations(digits, 0, "");

    return res;

  }

  private void findCombinations(String digits, int index, String processedStr) {
    System.out.println("当前 index:" + index + " ， 已经处理好的：" + processedStr);
    if (index == digits.length()) {
      res.add(processedStr);
      System.out.println("已经获取带一个完整的结果：" + processedStr);
      return;
    }

    Character curChar = digits.charAt(index);

    String letterStr = letterMap.get(curChar - '0');

    for (int i = 0; i < letterStr.length(); i++) {
      Character useChar = letterStr.charAt(i);
      System.out.println("digits[" + index + "]: " + (curChar - '0') + ", user :" + useChar + ", all: " + letterStr);
      findCombinations(digits, index + 1, processedStr + useChar);
    }

    System.out.println("digits[" + index + "] 已经遍历完了 ");
  }

  public static void main(String[] args) {
    String digits = "23";
    LetterCombinations_17 demo = new LetterCombinations_17();
    System.out.println(demo.letterCombinations(digits));

  }
}
