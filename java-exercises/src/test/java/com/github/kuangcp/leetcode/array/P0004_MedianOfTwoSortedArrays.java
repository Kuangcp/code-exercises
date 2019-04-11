package com.github.kuangcp.leetcode.array;

import java.util.Stack;

/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.93%)
 * Total Accepted:    409.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * 30Min
 */
public class P0004_MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int size1 = nums1.length;
    int size2 = nums2.length;
    if (size1 == 0 && size2 == 0) {
      return 0;
    }
    if (size1 == 0 && size2 == 1) {
      return nums2[0];
    }
    if (size2 == 0 && size1 == 1) {
      return nums1[0];
    }

    Stack<Integer> stack = new Stack<>();

    int total = size1 + size2;
    if (total % 2 == 0) {
      if (size1 == 1 && size2 == 1) {
        return (nums1[0] + nums2[0]) / 2.0;
      }
      if (size1 == 2 && size2 == 0) {
        return (nums1[0] + nums1[1]) / 2.0;
      }
      if (size1 == 0 && size2 == 2) {
        return (nums2[0] + nums2[1]) / 2.0;
      }
      cal(nums1, nums2, size1, size2, stack, total);
      return (stack.pop() + stack.pop()) / 2.0;
    } else {
      cal(nums1, nums2, size1, size2, stack, total);
      return stack.pop();
    }
  }

  private void cal(int[] nums1, int[] nums2, int size1, int size2, Stack<Integer> stack,
      int total) {
    double medium = total / 2.0;
    int index1 = 0, index2 = 0;
    while ((index1 + index2) <= medium) {
      if (index1 == size1) {
        stack.push(nums2[index2]);
        index2++;
        continue;
      }
      if (index2 == size2) {
        stack.push(nums1[index1]);
        index1++;
        continue;
      }
      if (nums1[index1] <= nums2[index2]) {
        stack.push(nums1[index1]);
        index1++;
      } else {
        stack.push(nums2[index2]);
        index2++;
      }
    }
  }
}
