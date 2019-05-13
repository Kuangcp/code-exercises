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

    public Itr(Node head) {
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

    public Node(T value, Node next) {
      this.value = value;
      this.next = next;
    }

    public boolean hasNext() {
      return Objects.nonNull(next);
    }
  }

  public boolean isEmpty() {
    return count == 0 || Objects.isNull(head);
  }

  public void add(T value) {
    Node append = new Node(value, null);
    if (Objects.isNull(this.head)) {
      this.head = append;
    }

    if (Objects.isNull(this.tail)) {
      this.tail = append;
    } else {
      this.tail.next = append;
    }

    count++;
    log.info("+1 {} {}", count, value);
  }

  public T poll() {
    if (Objects.isNull(this.head)) {
      return null;
    }
    T result = this.head.value;
    this.head = this.head.next;
    count--;
    log.info("-1 {} {}", count, result);

    if (Objects.isNull(this.head)) {
      this.tail = null;
    }
    return result;
  }

  public int size() {
    return count;
  }

  public void show() {
    Node pointer = this.head;
    while (Objects.nonNull(pointer)) {
      System.out.print(pointer.value + "->");
      pointer = pointer.next;
    }
  }

}
