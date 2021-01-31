package com.jaenyeong.interview._02_list._01;

public class LinkedList {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList loopList = new LinkedList();
        loopList.add(new LinkedNode(1));
        loopList.add(new LinkedNode(2));
        loopList.add(new LinkedNode(3));

        loopList.print();
        loopList.reverseForLoop();
        System.out.println("[after reverse]");
        loopList.print();

        System.out.println("-----");

        LinkedList recursiveList = new LinkedList();
        recursiveList.add(new LinkedNode(1));
        recursiveList.add(new LinkedNode(2));
        recursiveList.add(new LinkedNode(3));

        recursiveList.print();
        recursiveList.reverseForRecursive();
        System.out.println("[after reverse]");
        recursiveList.print();
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

    /**
     * TODO 단일 연결 리스트를 뒤집는 함수를 구현하라.
     * 예) 1 -> 2 -> 3   =>   3 -> 2 -> 1
     *
     * @return
     */
    private void reverseForLoop() {
        LinkedNode curr = this.head;
        LinkedNode prev = null;
        LinkedNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        this.tail = this.head;
        this.head = prev;
    }

    private void reverseForRecursive() {
        this.tail = this.head;
        this.head = this.reverseRecursive(this.head);
    }

    private LinkedNode reverseRecursive(final LinkedNode current) {
        if (current.next == null) {
            return current;
        }

        LinkedNode head = reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;

        return head;
    }
}
