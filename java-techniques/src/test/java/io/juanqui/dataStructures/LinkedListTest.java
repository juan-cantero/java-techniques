package io.juanqui.dataStructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.juanqui.dataStructures.LinkLists.LinkedList;

public class LinkedListTest {
  private LinkedList list;

  @BeforeEach
  void setUp() {
    list = new LinkedList(10); // Initial list with one element
  }

  @Test
  void testAppendSingleElement() {
    list.append(20);
    list.getTail(); // Expected output: "Tail: 20"

    assertEquals(20, list.append(20), "The last appended value should be 20");
  }

  @Test
  void testAppendMultipleElements() {
    list.append(20);
    list.append(30);

    list.getTail(); // Expected output: "Tail: 30"

    assertEquals(30, list.append(30), "The last appended value should be 30");
  }

  @Test
  void testGetLength() {
    long length = list.getLength(); // Expected output: "Length: 1"
    assertEquals(length, 1);
  }

  @Test
  void removeLast() {
    list.append(20);
    list.removeLast();

    int tail = list.getTailValue(); // Expected output: "Tail: null"

    assertEquals(tail, 10);
  }

  @Test
  void removeLastAndGetNull() {
    list.removeLast();

    assertNull(list.getTail(), "Tail should be null");

  }

  @Test
  void preppend() {
    list.preppend(20);
    assertEquals(list.getHeadValue(), 20);
  }

  @Test
  void getNode() {
    list.append(20);
    list.append(30);
    assertEquals(list.getNode(1).value, 20);
  }

  @Test
  void setNode() {
    list.append(40);
    list.append(50);
    list.insert(20, 1);
    assertEquals(list.getNode(1).value, 20);
  }

  @Test
  void remove() {
    list.append(20);
    list.append(30);
    list.remove(2);
    assertEquals(list.getNode(1).value, 20);
  }

}
