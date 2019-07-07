package com.github.kuangcp.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * @author kuangcp on 2019-04-29 4:03 PM
 */
class P0015_3SumToZero {

  public List<List<Integer>> threeSum(int[] nums) {
    return useTwoCursor.apply(nums);
  }

  // 31ms
  static Function<int[], List<List<Integer>>> useTwoCursor = nums -> {
    List<List<Integer>> res = new LinkedList<>();
    Arrays.sort(nums);

    for (int index = 0; index < nums.length - 2; ++index) {
      if (index == 0 || nums[index] != nums[index - 1]) {
        int low = index + 1;
        int high = nums.length - 1;

        // use two cursor with low and high
        while (low < high) {
          int tempValue = nums[index] + nums[low] + nums[high];

          if (tempValue == 0) {
            res.add(Arrays.asList(nums[index], nums[low], nums[high]));
            while (low < high && nums[low] == nums[low + 1]) {
              ++low;
            }
            while (low < high && nums[high] == nums[high - 1]) {
              --high;
            }
            ++low;
            --high;
          } else if (tempValue > 0) {
            --high;
          } else {
            ++low;
          }
        }
      }
    }
    return res;
  };
}
