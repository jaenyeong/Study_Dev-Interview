package com.jaenyeong.interview._04_queue_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO 큐 인스턴스를 사용해서 Stack 인터페이스를 구현하라.
 * pop() 오퍼레이션은 가장 마지막으로 추가한 값을 꺼내야 한다.
 * push() 오퍼레이션은 값을 추가한다.
 * 큐가 제공하는 offer(), poll(), isEmpty(), size()만 사용할 수 있다. Deque는 사용하지 못한다.
 * (힌트) 큐 인스턴스를 여러개 사용할 수 있다.
 */
public class QueueStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {
        QueueStack stack = new QueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop() == 3);
        System.out.println(stack.pop() == 2);
        System.out.println(stack.pop() == 1);
    }

    private Integer pop() {
        if (q1.isEmpty()) {
            return null;
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        Integer result = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return result;
    }

    private void push(int number) {
        q1.offer(number);
    }
}
