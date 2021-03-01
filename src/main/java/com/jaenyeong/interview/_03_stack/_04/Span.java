package com.jaenyeong.interview._03_stack._04;

import java.util.Arrays;
import java.util.Stack;

public class Span {

    public static void main(String[] args) {
        final Span span = new Span();

        System.out.println(Arrays.toString(span.solution(new int[]{5, 3, 2, 4, 7, 1})));
        System.out.println(Arrays.toString(span.solution(new int[]{2, 3, 4, 5, 6, 7})));

        System.out.println(Arrays.toString(span.solutionWithoutStack(new int[]{5, 3, 2, 4, 7, 1})));
        System.out.println(Arrays.toString(span.solutionWithoutStack(new int[]{2, 3, 4, 5, 6, 7})));
    }

    /**
     * TODO 주어진 배열 prices에 대한 스팬을 구하는 코드를 작성하라.
     * 스팬: 당일의 주가 보다 낮거나 같았던 연속적인 일 수.
     * 예) [5, 3, 2, 4, 7, 1]    =>   [1, 1, 1, 3, 5, 1]
     * 예) [2, 3, 4, 5, 6, 7]    =>   [1, 2, 3, 4, 5, 6]
     *
     * @param price
     * @return
     */
    private int[] solution(int[] price) {
        final Stack<Integer> indices = new Stack<>();
        final int[] resultSpan = new int[price.length];

        indices.push(0);
        resultSpan[0] = 1;

        for (int i = 1; i < price.length; i++) {
            while (!indices.isEmpty() && price[indices.peek()] <= price[i]) {
                indices.pop();
            }

            resultSpan[i] = indices.isEmpty() ? i + 1 : i - indices.peek();
            indices.push(i);
        }

        return resultSpan;
    }

    private int[] solutionWithoutStack(int[] price) {
        final int[] resultSpan = new int[price.length];

        resultSpan[0] = 1;

        for (int i = 1; i < price.length; i++) {
            resultSpan[i] = 1;

            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--) {
                resultSpan[i]++;
            }
        }

        return resultSpan;
    }
}
