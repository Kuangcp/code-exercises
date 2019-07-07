package com.github.kuangcp.leetcode.string;

import java.util.Iterator;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kuangcp
 *
 * Date: 2019-05-13 22:56
 */
@Slf4j
class LinkedQueue<T> implements Iterable<T> {

  private int count;
  Node head;
  private Node tail;

  @Override
  public Iterator<T> iterator() {
    return new Itr(this.head);
  }

  private class Itr implements Iterator<T> {

    Node cursor;

    Itr(Node head) {
      cursor = head;
    }

    @Override
    public boolean hasNext() {
      return Objects.nonNull(cursor) && Objects.isNull(cursor.next);
    }

    @Override
    public T next() {
      T result = cursor.value;
      cursor = cursor.next;
      return result;
    }
  }

  class Node {

    T value;
    Node next;

    Node(T value, Node next) {
      this.value = value;
      this.next = next;
    }

    public boolean hasNext() {
      return Objects.nonNull(next);
    }
  }

  boolean isEmpty() {
    return count == 0 || Objects.isNull(head);
  }

  void add(T value) {
    Node append = new Node(value, null);
    if (Objects.isNull(this.head)) {
      this.head = append;
    }

    if (Objects.isNull(this.tail)) {
      this.tail = this.head;
    } else {
      this.tail.next = append;
      this.tail = this.tail.next;
    }

    count++;
//    log.info("+1 {} {}", count, value);
  }

  T poll() {
    if (Objects.isNull(this.head)) {
      return null;
    }
    T result = this.head.value;
    this.head = this.head.next;
    count--;
//    log.info("-1 {} {}", count, result);

    if (Objects.isNull(this.head)) {
      this.tail = null;
    }
    return result;
  }

  int size() {
    return count;
  }

  public String show() {
    Node pointer = this.head;
    StringBuilder builder = new StringBuilder();
    while (Objects.nonNull(pointer)) {
      builder.append(pointer.value).append("->");
      pointer = pointer.next;
    }
    return builder.toString();
  }
}
