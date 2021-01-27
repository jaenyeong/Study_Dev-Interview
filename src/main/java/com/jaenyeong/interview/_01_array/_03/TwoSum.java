package com.jaenyeong.interview._01_array._03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private static final int NOT_FOUND = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.findTwoSum(new int[]{2, 3, 5, 7}, 8)));
        System.out.println(Arrays.toString(twoSum.findThreeSum(new int[]{2, 3, 5, 7, 9, 13}, 12)));
    }

    /**
     * TODO 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는 두 수를 더해 target 숫자를 만들 수 있는 인덱스 두개를 찾는 함수를 작성하라.
     * 예) numbers = [2, 3, 5, 7] target = 8, 8을 만들 수 있는 3과 5의 인덱스인 1, 2를 리턴해야 한다.
     * 예) numbers = [1, 2, 6, 8] target = 9, 9를 만들 수 있는 1과 8의 인덱스인 0, 3을 리턴해야 한다.
     * <p>
     * numbers 배열에 중복되는 숫자는 없으며 target 숫자를 만들 수 있는 조합은 하나 뿐이라고 가정해도 좋다.
     *
     * @param numbers
     * @param target
     * @return
     */
    private int[] findTwoSum(final int[] numbers, final int target) {
        final Map<Integer, Integer> findNums = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            final int curNumber = numbers[i];
            // 타겟보다 크거나 같은 수는 요구사항에 맞게 처리할 것
            if (curNumber >= target) {
                continue;
            }

            // 요구사항에 맞춰 유효하지 않은 값(예를 들어 음수)으로 설정
            final Integer findIdx = findNums.getOrDefault(target - curNumber, NOT_FOUND);

            if (findIdx != NOT_FOUND) {
                return new int[]{findIdx, i};
            }

            findNums.put(curNumber, i);
        }

        // 결과가 존재하지 않는 경우는 요구사항에 맞게 처리할 것
        return null;
    }

    private int[] findThreeSum(final int[] numbers, final int target) {
        final Map<Integer, Integer> findNums = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            final int number = numbers[i];
            findNums.put(number, i);
        }

        for (int i = 0; i < numbers.length; i++) {
            final int firstNumber = numbers[i];

            if (firstNumber >= target) {
                continue;
            }

            for (int j = i + 1; j < numbers.length; j++) {
                final int secondNumber = numbers[j];

                if (secondNumber >= target) {
                    continue;
                }

                final Integer findIdx = findNums.getOrDefault(target - firstNumber - secondNumber, NOT_FOUND);

                if (findIdx != NOT_FOUND) {
                    return new int[]{i, j, findIdx};
                }
            }
        }

        return null;
    }
}
