package com.github.kuangcp.leetcode.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.github.kuangcp.base.Helper;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;

/**
 * @author kuangcp on 2019-04-29 5:26 PM
 */
public class P0015_3SumToZeroTest extends Helper<Function<int[], List<List<Integer>>>> {

  {
    put("use two cursor", P0015_3SumToZero.useTwoCursor);
  }

  @Override
  public void testSuit(Function<int[], List<List<Integer>>> resolver) {
    int[] datas = {-1, 0, 1, 2, -1, -4};

    List<List<Integer>> result = resolver.apply(datas);
    assertThat(result.size(), equalTo(2));
    result.forEach(System.out::println);
  }

  @Test
  public void testThreeSum() {
    testAllStrategy();
  }
}
