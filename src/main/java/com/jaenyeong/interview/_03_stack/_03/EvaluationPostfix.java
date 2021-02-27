package com.jaenyeong.interview._03_stack._03;

import java.util.Stack;

public class EvaluationPostfix {
    private static final int FAIL = -1;

    public static void main(String[] args) {
        final EvaluationPostfix eval = new EvaluationPostfix();

        System.out.println(eval.evaluate("52+") == 7);
        System.out.println(eval.evaluate("52-") == 3);
        System.out.println(eval.evaluate("52*") == 10);
        System.out.println(eval.evaluate("52/") == 2);
        System.out.println(eval.evaluate("521+-9*") == 18);
        System.out.println(eval.evaluate("12+") == 3);
        System.out.println(eval.evaluate("123+-5*") == -20);
    }

    /**
     * TODO 포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+, -, *, /)만 사용한다고 가정한다.
     * 예) 12+      => 3
     * 예) 123+-5*  => -20
     */
    private int evaluate(String postfix) {
        final Stack<Integer> expressionStack = new Stack<>();

        for (char exp : postfix.toCharArray()) {
            if (Character.isDigit(exp)) {
                expressionStack.push(exp - '0');
                continue;
            }

            if (expressionStack.size() < 2) {
                return FAIL;
            }

            final int topOperand = expressionStack.pop();
            final int bottomOperand = expressionStack.pop();

            switch (exp) {
                case '+':
                    expressionStack.push(bottomOperand + topOperand);
                    break;
                case '-':
                    expressionStack.push(bottomOperand - topOperand);
                    break;
                case '*':
                    expressionStack.push(bottomOperand * topOperand);
                    break;
                case '/':
                    expressionStack.push(bottomOperand / topOperand);
                    break;
            }
        }

       return expressionStack.pop();
    }
}
