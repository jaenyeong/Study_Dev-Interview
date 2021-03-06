package com.jaenyeong.interview._04_queue._02;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int cacheSize;
    private final Map<Integer, DoubleNode<Integer>> cacheMap;
    private DoubleNode<Integer> head;
    private DoubleNode<Integer> tail;

    static class DoubleNode<Integer> {
        private Integer value;
        private DoubleNode<Integer> prev;
        private DoubleNode<Integer> next;
    }

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        cacheMap = new HashMap<>();
    }

    /**
     * TODO 문제. LRU 캐시를 구현하라
     * 최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU (least recently used) 캐시를 구현하라.
     * 입력값 number는 1부터 100까지의 숫자가 랜덤하게 입력된다.
     * 그 중에 최대 n (1보다 크고 9보다 작은)개 만큼의 데이터만 캐시할 수 있다.
     * n개를 넘는 새로운 값이 들어오면 그 중에서 가장 오래전에 접근한 데이터를 삭제하고 number를 캐시에 추가한다.
     * 다음 오퍼레이션을 구현하라.
     * query(int number): number에 해당하는 입력값을 캐시에 추가한다.
     * print() 현재 캐시하고 있는 데이터를 출력한다.
     *
     * @param number
     */
    private void query(int number) {
        if (cacheMap.containsKey(number)) {
            final DoubleNode<Integer> targetNode = cacheMap.get(number);
            removeNode(targetNode);
            addToHead(targetNode);
        } else {
            if (cacheSize == cacheMap.size()) {
                cacheMap.remove(tail.value);
                removeNode(tail);
            }

            final DoubleNode<Integer> newNode = new DoubleNode<>();
            newNode.value = number;

            addToHead(newNode);
            cacheMap.put(number, newNode);
        }
    }

    private void removeNode(final DoubleNode<Integer> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addToHead(final DoubleNode<Integer> targetNode) {
        targetNode.prev = null;
        targetNode.next = head;

        if (head == null) {
            head = targetNode;
            tail = targetNode;
        } else {
            head.prev = targetNode;
        }

        head = targetNode;

        if (tail == null) {
            tail = head;
        }
    }

    private void print() {
        LRUCache.DoubleNode<Integer> current = this.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.query(1);
        lruCache.query(2);
        lruCache.query(3);
        lruCache.query(1);
        lruCache.query(4);
        lruCache.query(5);
        lruCache.query(2);
        lruCache.query(2);
        lruCache.query(1);
        lruCache.print();
    }
}
