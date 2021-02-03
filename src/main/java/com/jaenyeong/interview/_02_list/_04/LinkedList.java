package com.jaenyeong.interview._02_list._04;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        LinkedNode node3 = new LinkedNode(3);
        list.add(node3);
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));
        list.add(node3);

//        list.print();
        System.out.println(list.hasCircle());

        list.removeCircle();
        list.print();
    }

    /**
     * TODO 주어진 연결 리스트가 원형 연결 리스트인지 단일 연결 리스트인지 확인하는 함수를 구현하라.
     * 예) 1 -> 2 -> 3 -> 1   => true
     * 예) 1 -> 2 -> 3 -> 2   => true
     * 예) 1 -> 2 -> 3        => false
     *
     * @return
     */
    private boolean hasCircle() {
        LinkedNode slow = this.head;
        LinkedNode fast = this.head;

        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }

            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
        }
    }

    private void removeCircle() {
        if (this.head == null || this.head.next == null) {
            return;
        }

        LinkedNode prev = this.head;
        LinkedNode curr = this.head.next;

        final Set<LinkedNode> nodeSet = new HashSet<>();
        nodeSet.add(prev);

        while (true) {
            if (curr == null) {
                return;
            }

            if (nodeSet.contains(curr)) {
                prev.next = null;
            } else {
                nodeSet.add(curr);
                prev.next = curr;
                prev = curr;
            }

            curr = curr.next;
        }
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
