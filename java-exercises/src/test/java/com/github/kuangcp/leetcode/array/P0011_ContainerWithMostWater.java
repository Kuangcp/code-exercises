package com.github.kuangcp.leetcode.array;

/**
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * @author kuangcp on 2019-04-28 11:54 PM
 */
public class P0011_ContainerWithMostWater {

  /**
   * simple implementation
   * 189 ms  https://leetcode.com/submissions/detail/225499667/
   */
  public int maxArea(int[] height) {
    int max = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {

        int temp = calculateArea(height, i, j);
        if (max < temp) {
          max = temp;
        }
      }
    }
    return max;
  }

  private int calculateArea(int[] data, int x, int y) {
    if (x >= data.length || y >= data.length) {
      return 0;
    }
    return Math.min(data[x], data[y]) * Math.abs(x - y);
  }

  /////////////////

  /**
   * use two cursor move to right or left
   * 2 ms https://leetcode.com/submissions/detail/225500591/
   */
  public int maxArea3(int[] height) {
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int max = 0;
    while (leftIndex < rightIndex) {
      int temp = calculateArea(height, leftIndex, rightIndex);
      if (max < temp) {
        max = temp;
      }

      if (height[leftIndex] > height[rightIndex]) {
        rightIndex--;
      } else {
        leftIndex++;
      }
    }
    return max;
  }

  /**
   * avoid use Math lib and invoke method
   * 1 ms https://leetcode.com/submissions/detail/225501485/
   */
  public int maxArea2(int[] height) {
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int max = 0;

    while (leftIndex < rightIndex) {
      int temp;
      if (height[leftIndex] >= height[rightIndex]) {
        temp = (rightIndex - leftIndex) * height[rightIndex];
        rightIndex--;
      } else {
        temp = (rightIndex - leftIndex) * height[leftIndex];
        leftIndex++;
      }
      if (max < temp) {
        max = temp;
      }
    }

    return max;
  }
}
