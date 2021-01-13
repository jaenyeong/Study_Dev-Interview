package com.jaenyeong.interview._03_stack_03;

import java.util.LinkedList;

public class EvaluationPostfixSolution {

    public static void main(String[] args) {
        EvaluationPostfixSolution postfix = new EvaluationPostfixSolution();
        System.out.println(postfix.evaluate("52+") == 7);
        System.out.println(postfix.evaluate("52-") == 3);
        System.out.println(postfix.evaluate("52*") == 10);
        System.out.println(postfix.evaluate("52/") == 2);
        System.out.println(postfix.evaluate("521+-9*") == 18);
    }

    private int evaluate(String s) {
        LinkedList<Integer> numbers = new LinkedList<>();
        char[] chars = s.trim().toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                numbers.push(Integer.parseInt(c + ""));
            } else {
                int right = numbers.pop();
                int left = numbers.pop();

                switch (c) {
                    case '+':
                        numbers.push(left + right);
                        break;
                    case '-':
                        numbers.push(left - right);
                        break;
                    case '*':
                        numbers.push(left * right);
                        break;
                    case '/':
                        numbers.push(left / right);
                        break;
                }
            }
        }

        return numbers.pop();
    }
}
