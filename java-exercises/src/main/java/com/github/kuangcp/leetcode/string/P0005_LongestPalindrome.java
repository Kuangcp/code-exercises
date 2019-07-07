package com.github.kuangcp.leetcode.string;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author https://github.com/kuangcp
 * 2019-07-07 17:54
 */
public class P0005_LongestPalindrome {

  public String longestPalindrome(String s) {
    return useDP.apply(s);
  }

  static Function<String, String> useDP = str -> {
    if (Objects.isNull(str) || str.isEmpty()) {
      return "";
    }
    if (str.length() == 1) {
      return str;
    }
    int len = str.length(), start = 0, maxLength = 1, left, right;
    for (int i = 0; i < len && len - i > maxLength / 2; ) {
      left = right = i;
      while (right < len - 1 && Objects.equals(str.charAt(right + 1), str.charAt(right))) {
        ++right;
      }
      i = right + 1;
      while (right < len - 1 && left > 0
          && Objects.equals(str.charAt(right + 1), str.charAt(left - 1))) {
        ++right;
        --left;
      }
      if (maxLength < right - left + 1) {
        start = left;
        maxLength = right - left + 1;
      }
    }
    return str.substring(start, start + maxLength);
  };
}
