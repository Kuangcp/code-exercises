package com.github.kuangcp.leetcode.string;

import com.github.kuangcp.base.Helper;
import com.github.kuangcp.leetcode.string.P0005_LongestPalindrome.Resolver;
import com.github.kuangcp.leetcode.string.P0005_LongestPalindrome.UseStack;
import org.junit.Test;

/**
 * @author https://github.com/kuangcp
 * 2019-07-07 17:56
 */
public class P0005_LongestPalindromeTest extends Helper<Resolver> {

  {
    put("", new UseStack());
  }

  @Test
  public void testMain() {
    test();
  }

  @Override
  public void testSuit(Resolver resolver) {

  }
}

