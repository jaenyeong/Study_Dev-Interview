package com.jaenyeong.interview._04_queue_01;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueSolutions {

    public static void main(String[] args) {
        Queue<Integer> numbers = new ArrayDeque<>();
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);

        System.out.println(numbers);
        ReverseQueueSolutions reverseQueue = new ReverseQueueSolutions();
        Queue<Integer> reversed = reverseQueue.reverse1(numbers);
        System.out.println(reversed);
    }

    private Queue<Integer> reverse1(Queue<Integer> numbers) {
        Stack<Integer> stack = new Stack<>();

        while (!numbers.isEmpty()) {
            stack.push(numbers.poll());
        }

        while (!stack.isEmpty()) {
            numbers.offer(stack.pop());
        }

        return numbers;
    }

    private Queue<Integer> reverse2(Queue<Integer> numbers) {
        if (numbers.isEmpty()) {
            return numbers;
        }

        int front = numbers.poll();
        numbers = reverse2(numbers);
        numbers.offer(front);

        return numbers;
    }
}
