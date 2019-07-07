package com.github.kuangcp.leetcode.linkedlist;

import java.util.function.BiFunction;

/**
 * @author kuangcp on 2019-04-29 5:38 PM
 * https://leetcode.com/problems/add-two-numbers/description/
 */
class P0002_AddTwoNumber {

  public ListNode addTwoNumbers(ListNode one, ListNode other) {
    return me.apply(one, other);
  }

  static BiFunction<ListNode, ListNode, ListNode> me = (one, other) -> {
    ListNode result = new ListNode(0);
    ListNode pointer = result;

    int temp = 0;
    while (one != null && other != null) {
      int sum = one.val + other.val + temp;

      if (sum > 9) {
        temp = 1;
        sum %= 10;
      } else {
        temp = 0;
      }

      pointer = appendNode(pointer, sum);
      one = one.next;
      other = other.next;
    }

    while (one != null) {
      int sum = one.val + temp;
      if (sum > 9) {
        temp = 1;
        sum %= 10;
      } else {
        temp = 0;
      }

      pointer = appendNode(pointer, sum);
      one = one.next;
    }

    while (other != null) {
      int sum = other.val + temp;
      if (sum > 9) {
        temp = 1;
        sum %= 10;
      } else {
        temp = 0;
      }

      pointer = appendNode(pointer, sum);
      other = other.next;
    }

    if (temp != 0) {
      appendNode(pointer, temp);
    }
    return result;
  };

  static BiFunction<ListNode, ListNode, ListNode> simpler = (one, other) -> {
    ListNode result = new ListNode(0);
    ListNode pointer = result;

    int carry = 0;
    while (one != null || other != null) {
      int sum = (one == null ? 0 : one.val) + (other == null ? 0 : other.val);
      pointer.next = new ListNode((carry + sum) % 10);
      carry = (carry + sum) / 10;
      pointer = pointer.next;

      if (one != null) {
        one = one.next;
      }
      if (other != null) {
        other = other.next;
      }
    }
    if (carry > 0) {
      pointer.next = new ListNode(carry);
    }
    return result.next;
  };

  private static ListNode appendNode(ListNode pointer, int value) {
    pointer.next = new ListNode(value);
    pointer = pointer.next;

    if (pointer.val == -1) {
      pointer.val = value;
    } else {
      pointer.next = new ListNode(value);
      pointer = pointer.next;
    }
    return pointer;
  }
}
