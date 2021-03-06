package com.github.kuangcp.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (43.11%)
 * Total Accepted:    1.7M
 * Total Submissions: 3.8M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
class P0001_TwoSum {

  public int[] twoSum(int[] nums, int target) {
    return useMap.apply(nums, target);
  }

  static BiFunction<int[], Integer, int[]> useMap = (nums, target) -> {
    int[] result = new int[2];
    Map<Integer, Integer> numberMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];

      if (numberMap.containsKey(target - temp)) {
        result[0] = numberMap.get(target - temp);
        result[1] = i;
      } else {
        numberMap.put(temp, i);
      }
    }

    return result;
  };
}

