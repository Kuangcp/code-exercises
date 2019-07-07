package com.github.kuangcp.leetcode.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.github.kuangcp.base.Helper;
import java.util.function.BiFunction;
import org.junit.Test;

/**
 * @author kuangcp on 2019-04-11 9:57 PM
 */
public class P0004_MedianOfTwoSortedArraysTest extends Helper<BiFunction<int[], int[], Double>> {

  {
    put("stack", P0004_MedianOfTwoSortedArrays.useStack);
    put("array", P0004_MedianOfTwoSortedArrays.useTwoCache);
  }

  @Override
  public void testSuit(BiFunction<int[], int[], Double> resolver) {
    assertThat(resolver.apply(new int[]{1, 2}, new int[]{3, 4}), equalTo(2.5));
    assertThat(resolver.apply(new int[]{}, new int[]{3, 4}), equalTo(3.5));
    assertThat(resolver.apply(new int[]{1, 3}, new int[]{2}), equalTo(2.0));
  }

  @Test
  public void testMain() {
    testAllStrategy();
  }
}
