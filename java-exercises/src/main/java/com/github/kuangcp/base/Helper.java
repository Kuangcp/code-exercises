package com.github.kuangcp.base;

import com.github.kuangcp.time.GetRunTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

/**
 * 多种实现策略的辅助测试工具
 *
 * @author https://github.com/kuangcp
 * 2019-07-07 17:57
 */
public abstract class Helper<T> {

  private Map<String, T> resolverMap = new HashMap<>();
  private GetRunTime runTime = new GetRunTime();

  protected void put(String title, T resolver) {
    resolverMap.put(title, resolver);
  }

  protected void test() {
    Consumer<T> consumer = this::testSuit;

    for (Entry<String, T> entry : resolverMap.entrySet()) {
      runTime.startCount();
      consumer.accept(entry.getValue());
      runTime.endCountOneLine(entry.getKey());
    }
  }

  /**
   * 所有的测试用例
   */
  public abstract void testSuit(T resolver);
}