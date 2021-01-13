package com.jaenyeong.interview._02_list_01;

public class LinkedListSolution {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedListSolution list = new LinkedListSolution();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));

        list.print();
        list.reverse2();
        list.print();
    }

    private void print() {
        LinkedNode nodeToPrint = this.head;

        while (nodeToPrint != null) {
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

    private void reverse1() {
        LinkedNode current = this.head;
        LinkedNode prev = null;
        LinkedNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.tail = this.head;
        this.head = prev;
    }


    private void reverse2() {
        LinkedNode head = this.head;
        this.head = reverseRecursive(head);
        this.tail = head;
    }

    private LinkedNode reverseRecursive(LinkedNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        LinkedNode newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}
