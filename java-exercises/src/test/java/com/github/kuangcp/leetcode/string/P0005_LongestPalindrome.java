package com.github.kuangcp.leetcode.string;

/**
 * @author https://github.com/kuangcp
 * 2019-07-07 17:54
 */
public class P0005_LongestPalindrome {

  public String longestPalindrome(String s) {
    return new UseStack().execute(s);
  }

  interface Resolver {

    String execute(String str);
  }

  static class UseStack implements Resolver {

    @Override
    public String execute(String str) {
      return null;
    }
  }
}
