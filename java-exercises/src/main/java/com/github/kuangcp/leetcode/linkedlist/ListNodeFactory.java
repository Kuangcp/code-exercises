package com.github.kuangcp.leetcode.linkedlist;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kuangcp on 2019-04-30 11:27 AM
 */
@Slf4j
class ListNodeFactory {

  static ListNode buildNode(int[] data) {
    if (Objects.isNull(data)) {
      log.error("build list error: ");
      return null;
    }

    ListNode result = new ListNode(data[0]);
    ListNode pointer = result;
    for (int i = 1; i < data.length; i++) {
      pointer.next = new ListNode(data[i]);
      pointer = pointer.next;
    }

    return result;
  }

  static void show(ListNode head) {
    while (Objects.nonNull(head)) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }
    System.out.println("null");
  }
}
