package com.github.kuangcp.leetcode.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.github.kuangcp.base.Helper;
import com.github.kuangcp.leetcode.string.P0003_LongestSubstring.Resolver;
import com.github.kuangcp.leetcode.string.P0003_LongestSubstring.UseLinkedQueue;
import com.github.kuangcp.leetcode.string.P0003_LongestSubstring.UseSet;
import org.junit.Test;

/**
 * @author kuangcp
 *
 * Date: 2019-05-13 23:21
 */
public class P0003_LongestSubstringTest extends Helper<Resolver> {

  {
    put("linked queue", new UseLinkedQueue());
    put("set", new UseSet());
  }

  @Test
  public void testLengthOfLongestSubstring() {
    test();
  }

  @Override
  public void testSuit(Resolver resolver) {
    assertThat(resolver.execute("bbbbb"), equalTo(1));
    assertThat(resolver.execute("abcabcbb"), equalTo(3));
    assertThat(resolver.execute("pwwkew"), equalTo(3));
    assertThat(resolver.execute(" "), equalTo(1));
    assertThat(resolver.execute("abdfagiol"), equalTo(8));
    assertThat(resolver.execute("abdfagidol"), equalTo(7));
  }

}
