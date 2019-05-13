package com.github.kuangcp.leetcode.string;

import com.github.kuangcp.leetcode.string.LinkedQueue.Node;
import java.util.Objects;

/**
 * @author kuangcp
 *
 * Date: 2019-05-13 10:29 PM
 */
class P0003_LongestSubstring {

  // 采用链式队列的方式
  public int lengthOfLongestSubstring(String s) {
    if (Objects.isNull(s) || s.isEmpty()) {
      return 0;
    }

    LinkedQueue<Character> queue = new LinkedQueue<>();
    for (int j = 0; j < s.length(); j++) {
      char value = s.charAt(j);
      if (queue.isEmpty()) {
        queue.add(value);
        continue;
      }

      int count = 0;
      boolean hasRepeated = false;
      queue.add(value);

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

      if (hasRepeated) {
        for (int i = 0; i < count; i++) {
          queue.poll();
        }
      }

    }

    queue.show();
    return queue.size();
  }

}
