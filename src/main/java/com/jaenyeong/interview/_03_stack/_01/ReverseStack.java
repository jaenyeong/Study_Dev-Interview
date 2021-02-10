package com.jaenyeong.interview._03_stack._01;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        final Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);

        System.out.println(numbers);
        ReverseStack reverseStack = new ReverseStack();
//        reverseStack.solutionByOtherStack(numbers);
        reverseStack.solutionByRecursive(numbers);
        System.out.println(numbers);
    }

    // TODO 스택을 뒤집는 코드를 작성하라.
    private void solutionByOtherStack(final Stack<Integer> originStack) {
        final Stack<Integer> reverseStack = new Stack<>();

        while (!originStack.isEmpty()) {
            reverseStack.add(originStack.pop());
        }

        originStack.addAll(reverseStack);
    }

    private void solutionByRecursive(final Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        final int popValue = stack.pop();
        solutionByRecursive(stack);
        pushUpsideDown(stack, popValue);
    }

    private void pushUpsideDown(final Stack<Integer> stack, final int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        final int popValue = stack.pop();
        pushUpsideDown(stack, value);
        stack.push(popValue);
    }
}
