package com.github.kuangcp.leetcode.linkedlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.github.kuangcp.base.Helper;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author kuangcp on 2019-04-30 11:26 AM
 */
@Slf4j
public class P0019_RemoveNthNodeTest extends Helper<BiFunction<ListNode, Integer, ListNode>> {

  {
    put("me", P0019_RemoveNthNode.me);
    put("simpler", P0019_RemoveNthNode.simpler);
  }

  @Test
  public void testMain() {
    test();
  }

  @Override
  public void testSuit(BiFunction<ListNode, Integer, ListNode> resolver) {
    ListNode list = ListNodeFactory.buildNode(new int[]{1, 2, 3});
    ListNodeFactory.show(list);
    ListNode result = resolver.apply(list, 1);
    ListNodeFactory.show(result);
    assertThat(ListNodeFactory.toArray(result), equalTo(new int[]{1, 2}));

    list = ListNodeFactory.buildNode(new int[]{1, 2, 3});
    result = resolver.apply(list, 2);
    ListNodeFactory.show(result);

    assertThat(ListNodeFactory.toArray(result), equalTo(new int[]{1, 3}));
  }
}