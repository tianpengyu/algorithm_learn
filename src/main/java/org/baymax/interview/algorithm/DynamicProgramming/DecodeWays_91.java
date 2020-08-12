/*
package org.baymax.interview.algorithm.DynamicProgramming;

*/
/**
 *
 *
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/8 22:49
 *//*

public class DecodeWays_91 {

  // TODO tianpengyu 2020/8/9 : 状态转移方程没想明白

  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    if (s.startsWith("0")) {
      return 0;
    }

    int [] dp = new int [s.length() + 1];

    dp[0] = 1;

    char [] chars = s.toCharArray();

    for ( int i = 1; i < chars.length; i++) {
      char cur = chars[i];
      if (cur != '0') {
        dp[i] = dp[i-1];
      }

      int lastNum = chars[i-1] - '0';
      int curNum = cur - '0';
      int num = lastNum * 10 + curNum;

      if ( num >= 10 &&  num <= 26 ) {
        dp[i]

      }



    }


    return dp[s.length() - 1];
  }

  private boolean isValidNum(int num) {
    return num <= 26 && num >= 1;
  }

  public static void main(String[] args) {
    String s = "101";
    DecodeWays_91 demo = new DecodeWays_91();
    System.out.println(demo.numDecodings(s));
  }
}
*/
