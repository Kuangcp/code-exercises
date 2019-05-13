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

  P0003_LongestSubstring target = new P0003_LongestSubstring();

  @Test
  public void testLengthOfLongestSubstring() throws Exception {
    int result = target.lengthOfLongestSubstring("ssds");
//    int result = target.lengthOfLongestSubstring("sdddadd");
    assertThat(result, equalTo(2));
  }
}
