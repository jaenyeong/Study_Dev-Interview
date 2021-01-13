package com.jaenyeong.interview._01_array_03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolutions {

    public static void main(String[] args) {
        TwoSumSolutions twoSumSolutions = new TwoSumSolutions();
        System.out.println(Arrays.toString(twoSumSolutions.solution2(new int[]{2, 3, 4, 7}, 6)));
    }

    private int[] solution1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    private int[] solution2(int[] numbers, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int numberToFind = target - numbers[i];
            if (numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i) {
                return new int[]{i, numberMap.get(numberToFind)};
            }

            numberMap.put(numbers[i], i);
        }

        return null;
    }
}
