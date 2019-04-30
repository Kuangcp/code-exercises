package com.github.kuangcp.leetcode.linkedlist;

import org.junit.Test;

/**
 * @author kuangcp on 2019-04-30 11:26 AM
 */
public class P0019_RemoveNthNodeTest {

  private P0019_RemoveNthNode target = new P0019_RemoveNthNode();

  @Test
  public void test1() throws Exception {
    ListNode list = ListNodeFactory.buildNode(new int[]{1, 2});
    ListNode result = target.removeNthFromEnd(list, 1);
    ListNodeFactory.show(result);
  }

  @Test
  public void test2() throws Exception {
    ListNode list = ListNodeFactory.buildNode(new int[]{1, 2});
    ListNode result = target.removeNthFromEnd(list, 2);
    ListNodeFactory.show(result);
  }
}