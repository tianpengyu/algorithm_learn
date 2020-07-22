package org.baymax.interview.algorithm.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * s[l ... r]
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/20 14:13
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

  public int lengthOfLongestSubstring(String s) {
    if(s == null) {
      return 0;
    }

    if(s.length() <= 1) {
      return s.length();
    }

    char[] chars = s.toCharArray();

    int l = 0;
    int r = -1;
    int size = 0;

    Set<Character> existedSet = new HashSet<>();

    while( l <= chars.length - 1) {

      if(r + 1 < chars.length && !existedSet.contains(chars[r+1])) {
        existedSet.add(chars[++r]);
      } else {
        existedSet.remove(chars[l++]);
      }

      size = Math.max(size, r - l + 1);

    }

    return size;
  }

}
