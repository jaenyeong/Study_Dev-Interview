package com.jaenyeong.interview._02_list._03;

public class LinkedList {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(4));

        list.print();
        list.removeDuplicates();
        list.print();
    }

    /**
     * TODO 정렬된 연결 리스트에서 중복가 노드를 제거하는 함수를 구현하라.
     * 예) 1 -> 1 -> 1 -> 2 -> 3 -> 3   =>   1 -> 2 -> 3
     *
     * @return
     */
    private void removeDuplicates() {

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
