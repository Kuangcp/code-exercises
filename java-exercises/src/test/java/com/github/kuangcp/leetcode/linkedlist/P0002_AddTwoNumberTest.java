package com.github.kuangcp.leetcode.linkedlist;

import com.github.kuangcp.base.Helper;
import java.util.function.BiFunction;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author https://github.com/kuangcp
 * 2019-07-07 19:08
 */
public class P0002_AddTwoNumberTest extends Helper<BiFunction<ListNode, ListNode, ListNode>> {

  {
    put("me", P0002_AddTwoNumber.me);
    put("simpler", P0002_AddTwoNumber.simpler);
  }

  @Override
  public void testSuit(BiFunction<ListNode, ListNode, ListNode> resolver) {
    ListNode result = resolver.apply(new ListNode(0), new ListNode(0));

    Assert.assertNotNull(result);
    Assert.assertEquals(0, result.val);
  }

  @Test
  public void testMain() {
    test();
  }
}