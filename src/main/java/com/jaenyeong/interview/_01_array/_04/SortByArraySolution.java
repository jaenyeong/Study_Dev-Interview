package com.jaenyeong.interview._01_array._04;

import java.util.Arrays;

public class SortByArraySolution {

    public static void main(String[] args) {
        SortByArraySolution sortByArray = new SortByArraySolution();
        System.out.println(Arrays.toString(sortByArray.solution(new int[]{2, 4, 1, 5, 6, 9})));
    }

    private int[] solution(int[] numbers) {
        boolean[] booleans = new boolean[100];

        for (int num : numbers) {
            booleans[num] = true;
        }

        int index = 0;

        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                numbers[index++] = i;
            }
        }

        return numbers;
    }

}
