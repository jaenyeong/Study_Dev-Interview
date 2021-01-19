package com.jaenyeong.interview._03_stack._04;

import java.util.Arrays;

public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        System.out.println(Arrays.toString(nge.solution(new int[]{1, 1, 2, 3})));
        System.out.println(Arrays.toString(nge.solution(new int[]{10, 4, 2, 30})));
        System.out.println(Arrays.toString(nge.solution(new int[]{82, 7, 15})));
    }

    /**
     * TODO 주어진 배열의 오른쪽에 처음으로 등장하는 현재 숫자보다 큰 수를 담고 있는 배열을 만드는 코드를 작성하라.
     * 예) [1, 1, 2, 3]   =>   [2, 2, 3, -1]
     * 예) [10, 4, 2, 30]   =>  [30, 30, 30, -1]
     * 예) [82, 7, 15]   =>  [-1, 15, -1]
     *
     * @param numbers
     * @return
     */
    private int[] solution(int[] numbers) {
        return numbers;
    }
}
