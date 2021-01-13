package com.jaenyeong.interview._02_list_02;

import java.util.HashMap;
import java.util.Map;

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
        LinkedNode node = list.findFromLast3(2);
        System.out.println(node.number);
    }

    /**
     * TODO 단일 연결 리스트의 끝에서 n번째에 위치한 노드를 찾는 함수를 구현하라.
     * 예) findFromLast(1 -> 4 -> 2 -> 3, 2), 끝에서 2번째에 위치한 2를 리턴한다.
     *
     * @param n
     * @return
     */
    private LinkedNode findFromLast1(int n) {
        Map<Integer, LinkedNode> nodeMap = new HashMap<>();
        LinkedNode current = this.head;
        int i = 0;

        while (current != null) {
            nodeMap.put(i++, current);
            current = current.next;
        }

        return nodeMap.get(nodeMap.size() - n);
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
