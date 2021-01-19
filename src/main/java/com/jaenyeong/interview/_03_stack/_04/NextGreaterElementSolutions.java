package com.jaenyeong.interview._03_stack._04;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementSolutions {

    public static void main(String[] args) {
        NextGreaterElementSolutions nge = new NextGreaterElementSolutions();
        System.out.println(Arrays.toString(nge.solution(new int[]{1, 1, 2, 3})));
        System.out.println(Arrays.toString(nge.solution(new int[]{10, 4, 2, 30})));
        System.out.println(Arrays.toString(nge.solution(new int[]{82, 7, 15})));
    }

    private int[] solution(int[] numbers) {
        int[] nge = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers.length - 1);
        nge[numbers.length - 1] = -1;

        for (int i = numbers.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]) {
                stack.pop();
            }

            nge[i] = stack.isEmpty() ? -1 : numbers[stack.peek()];
            stack.push(i);
        }

        return nge;
    }
}
