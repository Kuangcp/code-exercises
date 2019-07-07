package com.github.kuangcp.leetcode.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.github.kuangcp.base.Helper;
import java.util.function.Function;
import org.junit.Test;

/**
 * @author https://github.com/kuangcp
 * 2019-07-07 17:56
 */
public class P0005_LongestPalindromeTest extends Helper<Function<String, String>> {

  {
    put("dynamic programming", P0005_LongestPalindrome.useDP);
  }

  @Test
  public void testMain() {
    testAllStrategy();
  }

  @Override
  public void testSuit(Function<String, String> function) {
    assertThat(function.apply("ddfddfffdsfewwrffd"), equalTo("ddfdd"));
    assertThat(function.apply("dd"), equalTo("dd"));
    assertThat(function.apply("ddffdaa"), equalTo("dffd"));
  }
}

