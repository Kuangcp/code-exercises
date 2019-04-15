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

  // 6ms
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
    if (size1 == 1 && size2 == 1) {
      return half(nums1[0], nums2[0]);
    }
    if (size1 == 2 && size2 == 0) {
      return half(nums1[0], nums1[1]);
    }
    if (size1 == 0 && size2 == 2) {
      return half(nums2[0], nums2[1]);
    }

    Stack<Integer> stack = new Stack<>();

    int total = size1 + size2;
    if (total % 2 == 0) {
      cal(nums1, nums2, size1, size2, stack, total);
      return half(stack.pop(), stack.pop());
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

  private double half(int a, int b) {
    return (a + b) / 2.0;
  }

  /////////////////////
  // 2ms
  public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
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
    if (size1 == 1 && size2 == 1) {
      return half(nums1[0], nums2[0]);
    }
    if (size1 == 2 && size2 == 0) {
      return half(nums1[0], nums1[1]);
    }
    if (size1 == 0 && size2 == 2) {
      return half(nums2[0], nums2[1]);
    }

    int[] cache = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
    int total = size1 + size2;
    double medium = total / 2.0;
    int index1 = 0, index2 = 0;
    while ((index1 + index2) <= medium) {
      if (index1 == size1) {
        push(cache, nums2[index2]);
        index2++;
        continue;
      }
      if (index2 == size2) {
        push(cache, nums1[index1]);
        index1++;
        continue;
      }
      if (nums1[index1] <= nums2[index2]) {
        push(cache, nums1[index1]);
        index1++;
      } else {
        push(cache, nums2[index2]);
        index2++;
      }
    }

    if (total % 2 == 0) {
      return half(cache[0], cache[1]);
    } else {
      return cache[1];
    }
  }

  private void push(int[] cache, int value) {
    if (cache[1] == Integer.MIN_VALUE) {
      cache[1] = value;
      return;
    }

    cache[0] = cache[1];
    cache[1] = value;
  }

  ///////////////////

  // https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
  // log min(n,m)
  public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;

    // make sure nums1 <= nums2
    if (len1 > len2) {
      return findMedianSortedArrays3(nums2, nums1);
    }

    int k = (len1 + len2 + 1) / 2;
    int l = 0;
    int r = len1;

    //find the m1 so that nums1[m1] >= nums2[m2 - 1]
    while (l < r) {
      int m1 = l + (r - l) / 2;
      int m2 = k - m1;
      if (nums1[m1] < nums2[m2 - 1]) {
        l = m1 + 1;
      } else {
        r = m1;
      }
    }

    int m1 = l;
    int m2 = k - l;
    int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
        m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
    if ((len1 + len2) % 2 == 1) {
      return c1;
    }
    int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1],
        m2 >= len2 ? Integer.MAX_VALUE : nums2[m2]);
    return (c1 + c2) / 2.0;
  }
}
