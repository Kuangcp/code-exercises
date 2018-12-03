package com.github.kuangcp.lintcode.p1546;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

public class MainTest {

  public int solutionOne(int m, int n) {
    int[] data = {100, 50, 20, 10, 5, 2, 1};
    int result = 0;
    int remainder = m - n;
    for (int i : data) {
      int temp = remainder / i;
      if (temp != 0) {
        remainder = remainder % i;
        result += temp;
      }
    }

    return result;
  }

  @Test
  public void testOne() {
    int result = solutionOne(100, 29);
    assertThat(result, equalTo(3));
  }
}
