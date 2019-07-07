package com.github.kuangcp.leetcode.linkedlist;

import java.util.Objects;

/**
 * @author kuangcp on 2019-04-29 6:38 PM
 */
class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ListNode)) {
      return false;
    }
    ListNode listNode = (ListNode) o;
    return val == listNode.val;
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, next);
  }
}
