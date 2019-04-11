package com.github.kuangcp.leetcode.array;

import org.junit.Test;

/**
 * @author kuangcp on 2019-04-11 2:10 PM
 */
public class P0001_TwoSumTest {

  private P0001_TwoSum p0001_TwoSum = new P0001_TwoSum();

  @Test
  public void testTwoSum() throws Exception {
    int[] result = p0001_TwoSum.twoSum(new int[]{1, 11, 2, 3, 5, 6}, 8);
    System.out.println(result[0] + " " + result[1]);
  }
}
