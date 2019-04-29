package com.github.kuangcp.leetcode.linkedlist;

/**
 * @author kuangcp on 2019-04-29 5:38 PM
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class P0002_AddTwoNumber {

  public ListNode addTwoNumbers(ListNode one, ListNode other) {
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
  }

  private ListNode appendNode(ListNode pointer, int value) {
    pointer.next = new ListNode(value);
    pointer = pointer.next;

//    if (pointer.val == -1) {
//      pointer.val = value;
//    } else {
//      pointer.next = new ListNode(value);
//      pointer = pointer.next;
//    }
    return pointer;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode pointer = result;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
      pointer.next = new ListNode((carry + sum) % 10);
      carry = (carry + sum) / 10;
      pointer = pointer.next;

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry > 0) {
      pointer.next = new ListNode(carry);
    }
    return result.next;
  }


}
