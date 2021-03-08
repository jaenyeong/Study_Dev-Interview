package com.jaenyeong.interview._04_queue._04;

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
        QueueStack firstStack = new QueueStack();
        firstStack.firstPush(1);
        firstStack.firstPush(2);
        firstStack.firstPush(3);
        System.out.println(firstStack.firstPop() == 3);
        System.out.println(firstStack.firstPop() == 2);
        System.out.println(firstStack.firstPop() == 1);

        QueueStack secondStack = new QueueStack();
        secondStack.secondPush(1);
        secondStack.secondPush(2);
        secondStack.secondPush(3);
        System.out.println(secondStack.secondPop() == 3);
        System.out.println(secondStack.secondPop() == 2);
        System.out.println(secondStack.secondPop() == 1);
    }

    private Integer firstPop() {
        if (q1.isEmpty()) {
            return null;
        }

        return q1.poll();
    }

    private void firstPush(int number) {
        q2.offer(number);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> tempQ = q1;
        q1 = q2;
        q2 = tempQ;
    }

    private Integer secondPop() {
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

    private void secondPush(int number) {
        q1.offer(number);
    }
}
