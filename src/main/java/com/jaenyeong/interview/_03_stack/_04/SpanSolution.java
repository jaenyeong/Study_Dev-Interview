package com.jaenyeong.interview._03_stack._04;

import java.util.Arrays;
import java.util.Stack;

public class SpanSolution {

    public static void main(String[] args) {
        SpanSolution span = new SpanSolution();
        System.out.println(Arrays.toString(span.solution(new int[]{5, 3, 2, 4, 7, 1})));
        System.out.println(Arrays.toString(span.solution(new int[]{2, 3, 4, 5, 6, 7})));
    }

    /**
     * Span 문제를 거꾸로 뒤집어서 생각하면 쉽습니다.
     *
     * @param price
     * @return
     */
    private int[] solution(int[] price) {
        int[] span = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return span;
    }
}
