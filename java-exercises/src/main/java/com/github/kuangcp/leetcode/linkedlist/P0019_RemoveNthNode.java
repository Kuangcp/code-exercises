package com.github.kuangcp.leetcode.linkedlist;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * 移除第N个节点, 如果超出链表长度 则移除头结点
 *
 * @author kuangcp on 2019-04-29 6:41 PM
 */
class P0019_RemoveNthNode {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    return simpler.apply(head, n);
  }

  // fast & slow pointer  https://leetcode.com/submissions/detail/225829332/
  static BiFunction<ListNode, Integer, ListNode> me = (head, n) -> {
    ListNode fast = head;
    ListNode slow = head;
    ListNode front = head;

    // 3 2
    int slowCount = 1;
    int sum = 1;
    boolean reachedTail = false;

    while (true) {
      if (!reachedTail) {
        for (int i = 0; i < n + 1; i++) {
          fast = fast.next;
          if (Objects.nonNull(fast)) {
            sum++;
          } else {
            reachedTail = true;
            break;
          }
        }
      }

      if (reachedTail && slowCount == (sum - n + 1)) {
        if (sum == 1) {
          return null;
        } else if (n == sum) {
          head = slow.next;
        } else {
          front.next = slow.next;
        }
        break;
      }

      front = slow;
      slow = slow.next;
      slowCount++;
    }
    return head;
  };

  static BiFunction<ListNode, Integer, ListNode> simpler = (head, n) -> {
    ListNode fast = head;
    ListNode slow = head;

    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    if (fast == null) {
      return head.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  };
}
