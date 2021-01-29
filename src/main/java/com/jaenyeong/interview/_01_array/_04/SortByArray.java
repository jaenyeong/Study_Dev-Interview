package com.jaenyeong.interview._01_array._04;

import java.util.Arrays;

public class SortByArray {

    public static void main(String[] args) {
        SortByArray sortByArray = new SortByArray();
        System.out.println(Arrays.toString(sortByArray.solution(new int[]{2, 4, 1, 5, 6, 9})));
    }

    /**
     * TODO 1부터 100 까지의 숫자 중에 50개의 랜덤한 숫자가 들어있는 배열이 있다.
     * 이 배열을 O(n)의 시간 복잡도로 정렬하라.
     *
     * @param numbers
     * @return
     */
    private int[] solution(final int[] numbers) {
        final boolean[] sortedValues = new boolean[100];

        for (int number : numbers) {
            sortedValues[number] = true;
        }

        int valueIdx = 0;
        for (int i = 0; i < sortedValues.length; i++) {
            if (sortedValues[i]) {
                numbers[valueIdx++] = i;
            }
        }

        return numbers;
    }
}
