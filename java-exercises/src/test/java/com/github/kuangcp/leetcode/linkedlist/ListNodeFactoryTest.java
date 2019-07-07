package com.github.kuangcp.leetcode.linkedlist;

import org.junit.Test;

/**
 * @author https://github.com/kuangcp
 * 2019-07-07 20:15
 */
public class ListNodeFactoryTest {

  @Test
  public void testBuildNode() throws Exception {
    ListNode result = ListNodeFactory.buildNode(new int[]{0,1});
    ListNodeFactory.show(result);
  }

  @Test
  public void testShow() throws Exception {
    ListNodeFactory.show(new ListNode(0));
  }
}