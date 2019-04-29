package com.github.kuangcp.leetcode.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;
import org.junit.Test;

/**
 * @author kuangcp on 2019-04-29 5:26 PM
 */
public class P0015_3SumToZeroTest {

  private P0015_3SumToZero target = new P0015_3SumToZero();

  @Test
  public void testThreeSum() throws Exception {
    List<List<Integer>> result = target.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    assertThat(result.size(), equalTo(2));
    result.forEach(System.out::println);
  }
}
