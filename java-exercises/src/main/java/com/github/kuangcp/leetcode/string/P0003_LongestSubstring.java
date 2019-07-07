package com.github.kuangcp.leetcode.string;

import com.github.kuangcp.leetcode.string.LinkedQueue.Node;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author kuangcp
 *
 * Date: 2019-05-13 10:29 PM
 */
class P0003_LongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    return useSet.apply(s);
  }

  // 采用链式队列的方式 遇到重复就丢弃第一个元素
  static Function<String, Integer> useLinkedQueue = str -> {
    if (Objects.isNull(str) || str.isEmpty()) {
      return 0;
    }

    int max = 0;
    LinkedQueue<Character> queue = new LinkedQueue<>();
    for (int j = 0; j < str.length(); j++) {
      char value = str.charAt(j);
      if (queue.isEmpty()) {
        queue.add(value);
        max = 1;
        continue;
      }

      int count = 0;
      boolean hasRepeated = false;

      Node pointer = queue.head;
      while (Objects.nonNull(pointer)) {
        Object temp = pointer.value;
        if (temp.equals(value)) {
          hasRepeated = true;
          break;
        }

        count++;
        pointer = pointer.next;
      }
      queue.add(value);

      if (hasRepeated) {
        for (int i = 0; i <= count; i++) {
          queue.poll();
        }
      }
      if (max < queue.size()) {
        max = queue.size();
      }
    }
    return max;
  };

  // 采用 缓存 set 的方式
  static Function<String, Integer> useSet = str -> {
    if (str == null || str.length() == 0) {
      return 0;
    }

    if (str.length() == 1) {
      return 1;
    }

    HashSet<Character> checkSet = new HashSet<>();
    int len, maxSize = 0, startIndex = 0;
    for (int i = 0; i < str.length(); i++) {
      if (checkSet.contains(str.charAt(i))) {
        len = checkSet.size();
        maxSize = Math.max(maxSize, len);
        checkSet.clear();
        i = startIndex++;
      } else {
        checkSet.add(str.charAt(i));
      }
    }
    maxSize = Math.max(maxSize, checkSet.size());
    return maxSize;
  };
}
