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

  static int length(ListNode head) {
    if (Objects.isNull(head)) {
      return 0;
    }
    int count = 0;
    ListNode pointer = head;
    while (Objects.nonNull(pointer)) {
      count++;
      pointer = pointer.next;
    }
    return count;
  }

  static int[] toArray(ListNode head) {
    if (Objects.isNull(head)) {
      return null;
    }

    int length = length(head);
    int[] result = new int[length];
    ListNode pointer = head;
    int count = 0;
    while (Objects.nonNull(pointer)) {
      result[count++] = pointer.val;
      pointer = pointer.next;
    }

    return result;
  }

}
