package com.github.kuangcp.leetcode.array;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.github.kuangcp.base.Helper;
import java.util.function.BiFunction;
import org.junit.Test;

/**
 * @author kuangcp on 2019-04-11 2:10 PM
 */
public class P0001_TwoSumTest extends Helper<BiFunction<int[], Integer, int[]>> {

  {
    put("use map", P0001_TwoSum.useMap);
  }

  @Test
  public void testTwoSum() {
    testAllStrategy();
  }

  @Override
  public void testSuit(BiFunction<int[], Integer, int[]> resolver) {
    int[] data = {1, 11, 2, 3, 5, 6};
    int target = 8;

    int[] result = resolver.apply(data, target);
    assertThat(data[result[0]] + data[result[1]], equalTo(target));
  }
}
