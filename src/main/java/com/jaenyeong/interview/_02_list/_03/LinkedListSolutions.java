package com.jaenyeong.interview._02_list._03;

public class LinkedListSolutions {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedListSolutions list = new LinkedListSolutions();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));

        list.print();
        list.removeDuplicates1();
        list.print();
    }

    private void removeDuplicates1() {
        LinkedNode current = this.head;

        while (current != null) {
            LinkedNode temp = current;

            while (temp != null && temp.number == current.number) {
                temp = temp.next;
            }

            current.next = temp;
            current = current.next;
        }
    }

    private LinkedNode findFromLast2(int n) {
        LinkedNode current = this.head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        int targetIndex = length - n;
        LinkedNode targetNode = this.head;

        while (targetIndex > 0) {
            targetNode = targetNode.next;
            targetIndex--;
        }

        return targetNode;
    }

    private LinkedNode findFromLast3(int n) {
        LinkedNode left = this.head;
        LinkedNode right = this.head;
        int count = 0;

        while (right.next != null) {
            if (count == n - 1) {
                left = left.next;
                right = right.next;
            } else if (count++ < n) {
                right = right.next;
            }
        }

        return left;
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
}
