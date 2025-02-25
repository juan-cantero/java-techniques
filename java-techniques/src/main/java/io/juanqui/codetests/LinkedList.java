package io.juanqui.codetests;

import java.util.HashSet;

public class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // WRITE THE PARTITIONLIST METHOD HERE //
    // //
    // //
    // //
    // //
    /////////////////////////////////////////

    public void partitionList(int x) {
        Node minorDummy = new Node(0); // Dummy head for the < x list
        Node minor = minorDummy;
        Node mayorDummy = new Node(0); // Dummy head for the >= x list
        Node mayor = mayorDummy;

        Node current = this.head;

        while (current != null) {
            if (current.value < x) {
                minor.next = current;
                minor = minor.next;
            } else {
                mayor.next = current;
                mayor = mayor.next;
            }
            current = current.next;
        }

        mayor.next = null;
        minor.next = mayorDummy.next;

        this.head = minorDummy.next;

    }

    public void removeDuplicates() {
        if (this.head == null)
            return;
        Node currentDummy = new Node(0);
        Node current = currentDummy;
        current.next = this.head;

        HashSet<Integer> uniqueNodes = new HashSet<>();
        while (current.next != null) {
            if (uniqueNodes.contains(current.next.value)) {
                current.next = current.next.next;

            } else {
                uniqueNodes.add(current.next.value);
                current = current.next;
            }

        }
        this.head = currentDummy.next;

    }

    public int binaryToDecimal() {

        int sum = 0;
        Node current = this.head;
        while (current != null) {
            sum = sum * 2 + current.value;
            current = current.next;
        }

        return sum;
    }

    public void reverseBetween2(int m, int n) {
        Node beforeStart = this.head;
        Node start = this.head;
        Node end = this.head;
        Node sb;

        for (int i = 0; i < m; i++) {
            start = start.next;
        }

        while (beforeStart.next != start) {
            beforeStart = beforeStart.next;
        }

        for (int i = 0; i < n; i++) {
            end = end.next;
        }

        System.out.println("Before: " + beforeStart.value + " Start: " + start.value + " End: " + end.value);

        beforeStart.next = end;

        Node current = start;
        Node prev = current;
        Node next;

        // start.next = end.next;

        while (current != end) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

    }

    public void reverseBetween(int m, int n) {
        if (head == null || m == n)
            return; // No need to reverse if empty or same position

        Node dummy = new Node(0); // Dummy node to handle head edge case
        dummy.next = head;
        Node beforeStart = dummy;

        // Move beforeStart to just before the 'm' position
        for (int i = 0; i < m; i++) {
            beforeStart = beforeStart.next;
        }

        Node start = beforeStart.next;
        Node end = start;

        // Move end to the 'n' position
        for (int i = m; i < n; i++) {
            end = end.next;
        }

        Node afterEnd = end.next; // Store the node after the reversed part

        // Reverse the sublist
        Node prev = afterEnd;
        Node current = start;
        while (current != afterEnd) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect reversed part back
        beforeStart.next = prev;

        // If reversing from head, update head
        if (m == 0) {
            head = prev;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        // list.partitionList(5);
        // list.removeDuplicates();
        list.reverseBetween(1, 3);
        list.printAll();

        // LinkedList list2 = new LinkedList(1);
        // list2.append(0);
        // list2.append(1);

        // System.out.println(list2.binaryToDecimal());
    }

}