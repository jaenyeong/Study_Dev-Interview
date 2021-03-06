package com.jaenyeong.interview._04_queue._02;

import java.util.Deque;
import java.util.LinkedList;

public class LRUCacheSolution1 {

    public static void main(String[] args) {
        LRUCacheSolution1 lruCache = new LRUCacheSolution1(3);
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

    private int cacheSize;

    private Deque<Integer> cache;

    public LRUCacheSolution1(int cacheSize) {
        this.cacheSize = cacheSize;
        cache = new LinkedList<>();
    }

    private void print() {
        System.out.println(cache);
    }

    private void query(int number) {
        if (!cache.contains(number)) {
            if (cache.size() == this.cacheSize) {
                cache.removeLast();
            }
        } else {
            cache.remove(number);
        }
        cache.addFirst(number);
    }
}
