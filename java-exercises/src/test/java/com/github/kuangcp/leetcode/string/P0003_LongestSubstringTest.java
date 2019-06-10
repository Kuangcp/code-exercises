package com.github.kuangcp.leetcode.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
/**
 * @author kuangcp
 *
 * Date: 2019-05-13 23:21
 */
public class P0003_LongestSubstringTest {

  private P0003_LongestSubstring target = new P0003_LongestSubstring();

  @Test
  public void testLengthOfLongestSubstring() throws Exception {
    assertThat(target.lengthOfLongestSubstring("bbbbb"), equalTo(1));
    assertThat(target.lengthOfLongestSubstring("abcabcbb"), equalTo(3));
    assertThat(target.lengthOfLongestSubstring("pwwkew"), equalTo(3));
    assertThat(target.lengthOfLongestSubstring(" "), equalTo(1));
  }
}
