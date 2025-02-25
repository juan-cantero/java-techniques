package io.juanqui.dataStructures.LinkLists;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  public class Node {
    public int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

  public LinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public int append(int value) {

    Node newNode = new Node(value);
    if (length == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }

    this.length++;
    return this.tail.value;
  }

  public Node preppend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      this.head = newNode;
      this.tail = newNode;
      length++;
      return this.head;
    }
    newNode.next = this.head;
    this.head = newNode;
    length++;
    return this.head;
  }

  public void removeLast() {
    if (this.head == null)
      return;

    if (length == 1) {
      this.head = null;
      this.tail = null;
      this.length--;
      return;
    }
    Node current = this.head;

    while (current.next.next != null) {
      current = current.next;
    }
    current.next = null;
    this.tail = current;
    this.length--;
  }

  public void removeFirst() {
    if (this.head == null) {
      return;
    }
    Node current = this.head;
    this.head = current.next;
    current.next = null;
    length--;
  }

  public Node getTail() {
    return this.tail;
  }

  public Node getHead() {
    return this.head;
  }

  public int getHeadValue() {
    return this.head.value;
  }

  public int getTailValue() {
    return this.tail.value;
  }

  public Node getNode(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    Node current = this.head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }

  public long getLength() {
    System.out.println("Length: " + length);
    return length;
  }

  public boolean set(int index, int value) {
    if (index < 0 || index >= length) {
      return false;
    }
    Node current = this.head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    current.value = value;
    return true;
  }

  public boolean insert(int value, int index) {
    if (index < 0 || index >= length) {
      return false;
    }
    if (index == 0) {
      preppend(value);
      return true;
    }
    Node newNode = new Node(value);
    Node current = this.head;
    for (int i = 0; i < index - 1; i++) {
      current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;
    length++;

    return true;
  }

  public Node remove(int index) {
    if (index == 0) {
      Node current = getNode(0);
      this.removeFirst();
      return current;
    }
    if (index == length - 1) {
      Node current = getNode(length - 1);
      this.removeLast();
      return current;

    }
    Node prev = this.getNode(index - 1);
    Node current = this.getNode(index);
    prev.next = current.next;
    current.next = null;
    index--;
    return current;

  }

}
