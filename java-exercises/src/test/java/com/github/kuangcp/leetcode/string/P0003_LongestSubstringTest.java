package com.github.kuangcp.leetcode.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.github.kuangcp.base.Helper;
import java.util.function.Function;
import org.junit.Test;

/**
 * @author kuangcp
 *
 * Date: 2019-05-13 23:21
 */
public class P0003_LongestSubstringTest extends Helper<Function<String, Integer>> {

  {
    put("linked queue", P0003_LongestSubstring.useLinkedQueue);
    put("set", P0003_LongestSubstring.useSet);
  }

  @Test
  public void testLengthOfLongestSubstring() {
    test();
  }

  @Override
  public void testSuit(Function<String, Integer> resolver) {
    assertThat(resolver.apply("bbbbb"), equalTo(1));
    assertThat(resolver.apply("abcabcbb"), equalTo(3));
    assertThat(resolver.apply("pwwkew"), equalTo(3));
    assertThat(resolver.apply(" "), equalTo(1));
    assertThat(resolver.apply("abdfagiol"), equalTo(8));
    assertThat(resolver.apply("abdfagidol"), equalTo(7));
  }
}
