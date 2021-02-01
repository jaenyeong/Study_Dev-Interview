package com.jaenyeong.interview._02_list._02;

public class LinkedList {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));

        list.print();
        LinkedNode node = list.findFromLast(2);
        System.out.println("answer: " + node.number);
    }

    /**
     * TODO 단일 연결 리스트의 끝에서 n번째에 위치한 노드를 찾는 함수를 구현하라.
     * 예) findFromLast(1 -> 4 -> 2 -> 3, 2), 끝에서 2번째에 위치한 2를 리턴한다.
     *
     * @param n
     * @return
     */
    private LinkedNode findFromLast(int n) {
        if (this.head == null) {
            return null;
        }

        if (this.head.next == null) {
            return this.head;
        }

        LinkedNode prev = this.head;
        LinkedNode curr = this.head.next;

        while (curr != null) {
            if (curr.next == null) {
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        return prev;
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
