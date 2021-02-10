package com.jaenyeong.interview._03_stack._01;

import java.util.Stack;

public class ReverseStackSolutions {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);

        System.out.println(numbers);
        ReverseStackSolutions reverseStack = new ReverseStackSolutions();
        reverseStack.solution2(numbers);
        System.out.println(numbers);
    }

    private Stack<Integer> solution1(Stack<Integer> stack) {
        Stack<Integer> reversedStack = new Stack<>();
        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }

        return reversedStack;
    }

    private void solution2(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int temp = stack.pop();
        solution2(stack);
        insertAtBottom(stack, temp);
    }

    private void insertAtBottom(Stack<Integer> stack, int number) {
        if (stack.isEmpty()) {
            stack.push(number);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(stack, number);
        stack.push(temp);
    }
}
