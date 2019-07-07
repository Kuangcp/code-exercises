package com.github.kuangcp.leetcode.string;

import com.github.kuangcp.base.Helper;
import java.util.function.Function;
import org.junit.Test;

/**
 * @author https://github.com/kuangcp
 * 2019-07-07 17:56
 */
public class P0005_LongestPalindromeTest extends Helper<Function<String, String>> {

  {
    put("", P0005_LongestPalindrome.useStack);
  }

  @Test
  public void testMain() {
    test();
  }

  @Override
  public void testSuit(Function<String, String> function) {

  }
}

