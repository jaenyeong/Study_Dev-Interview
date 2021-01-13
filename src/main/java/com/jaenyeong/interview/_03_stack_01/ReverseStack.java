package com.jaenyeong.interview._03_stack_01;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);

        System.out.println(numbers);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.solution(numbers);
        System.out.println(numbers);
    }

    // TODO 스택을 뒤집는 코드를 작성하라.
    private void solution(Stack<Integer> stack) {
    }
}
