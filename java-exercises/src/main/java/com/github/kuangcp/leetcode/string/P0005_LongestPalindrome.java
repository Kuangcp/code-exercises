package com.github.kuangcp.leetcode.string;

import java.util.function.Function;

/**
 * @author https://github.com/kuangcp
 * 2019-07-07 17:54
 */
public class P0005_LongestPalindrome {

  public String longestPalindrome(String s) {
    return useStack.apply(s);
  }

  static Function<String, String> useStack = str -> {
    return null;
  };

}
