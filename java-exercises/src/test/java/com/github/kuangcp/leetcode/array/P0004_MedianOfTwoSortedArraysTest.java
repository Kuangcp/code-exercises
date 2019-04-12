package com.github.kuangcp.leetcode.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.function.BinaryOperator;
import org.junit.Test;

/**
 * @author kuangcp on 2019-04-11 9:57 PM
 */
public class P0004_MedianOfTwoSortedArraysTest {

  private P0004_MedianOfTwoSortedArrays target = new P0004_MedianOfTwoSortedArrays();

  @Test
  public void test() {
    assertThat(target.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), equalTo(2.5));
    assertThat(target.findMedianSortedArrays(new int[]{}, new int[]{3, 4}), equalTo(3.5));
    assertThat(target.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), equalTo(2.0));
  }

  @Test
  public void test3() {
    assertThat(target.findMedianSortedArrays3(new int[]{1, 2}, new int[]{3, 4}), equalTo(2.5));
    assertThat(target.findMedianSortedArrays3(new int[]{}, new int[]{3, 4}), equalTo(3.5));
    assertThat(target.findMedianSortedArrays3(new int[]{1, 3}, new int[]{2}), equalTo(2.0));
  }

}
