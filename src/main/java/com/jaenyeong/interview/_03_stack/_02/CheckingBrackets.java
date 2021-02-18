package com.jaenyeong.interview._03_stack._02;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CheckingBrackets {
    private static final int FAIL = -1;
    private final List<Character> opens = Arrays.asList('(', '{', '[');
    private final List<Character> closes = Arrays.asList(')', '}', ']');

    public static void main(String[] args) {
        CheckingBrackets checkingBrackets = new CheckingBrackets();
        System.out.println(checkingBrackets.checkPair("[{1 + 2 * (2 + 2)} - (1 - 3)]"));
        System.out.println(checkingBrackets.checkPair("[{1 + 2 * (2 + 2)} - [1 - 3)]"));
        System.out.println(checkingBrackets.checkPair("((())"));
        System.out.println(checkingBrackets.checkPair("(()))"));
        System.out.println(checkingBrackets.checkPair("{{()}}"));

        System.out.println(checkingBrackets.findTheIndexOfAPair("[{1 + 2 * (2 + 2)} - (1 - 3)]", 1));
        System.out.println(checkingBrackets.findTheIndexOfAPair("[{1 + 2}]", 0));

        System.out.println(checkingBrackets.createRightExpression("{{{}}"));
        System.out.println(checkingBrackets.createRightExpression("{{{{}}"));
        System.out.println(checkingBrackets.createRightExpression("}}}}{}}}"));
        System.out.println(checkingBrackets.createRightExpression("{{{{"));

        System.out.println(checkingBrackets.existUnnecessaryParentheses("((1 + 2)) + 3"));
        System.out.println(checkingBrackets.existUnnecessaryParentheses("1 + (2 * 3)"));
        System.out.println(checkingBrackets.existUnnecessaryParentheses("1 + (2) * 3"));
    }

    /**
     * TODO 주어진 수식의 괄호짝이 맞는지 확인하는 코드를 작성하라.
     * 예) [{1 + 2 * (2 + 2)} - (1 - 3)]  => true
     * 예) [{1 + 2 * (2 + 2)} - [1 - 3)]  => false
     */
    private boolean checkPair(String mathExpression) {
        final Stack<Character> stack = new Stack<>();
        for (char exp : mathExpression.toCharArray()) {
            if (opens.contains(exp)) {
                stack.push(exp);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (!closes.contains(exp)) {
                continue;
            }

            final Character pop = stack.pop();
            if (closes.indexOf(exp) != opens.indexOf(pop)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * TODO 괄호 수식과 여는 괄호의 위치가 주어졌을 때, 그에 대응하는 닫힌 괄호의 위치를 찾는 코드를 작성하라.
     * 주어진 mathExpression이 올바른 수식이라고 가정
     * 예) [{1 + 2 * (2 + 2)} - (1 - 3)]
     * 1번째 ('{') => 11번째 ('}')
     */
    private int findTheIndexOfAPair(String mathExpression, int targetIdx) {
        mathExpression = removeWhiteSpace(mathExpression);
        final Stack<Character> expression = new Stack<>();

        for (int i = 0; i < mathExpression.length(); i++) {
            final char currentChar = mathExpression.charAt(i);

            if (opens.contains(currentChar)) {
                expression.push(currentChar);
                continue;
            }

            if (expression.isEmpty()) {
                return FAIL;
            }

            if (!closes.contains(currentChar)) {
                continue;
            }

            final char popChar = expression.pop();

            if (opens.indexOf(popChar) == closes.indexOf(currentChar) && expression.size() == targetIdx) {
                return i;
            }
        }

        return FAIL;
    }

    private String removeWhiteSpace(final String mathExpression) {
        return mathExpression.replace(" ", "");
    }

    /**
     * TODO 정상적인 수식을 만들기 위해 괄호를 몇 개 뒤집어야 하는지 계산하는 코드를 작성하라.
     * 항상 parentheses로 이루어진 수식이라고 가정
     * 예) {{{}}     => exception
     * 예) {{{{}}    => 1
     * 예) }}}}{}}}  => 3
     * 예) {{{{      => 2
     */
    private int createRightExpression(String mathExpression) {
        if (mathExpression.length() % 2 == 1) {
            return FAIL;
        }

        final Stack<Character> openStack = new Stack<>();
        final Stack<Character> closeStack = new Stack<>();

        for (char currentChar : mathExpression.toCharArray()) {
            if (opens.contains(currentChar)) {
                openStack.push(currentChar);
                continue;
            }

            if (closes.contains(currentChar)) {
                closeStack.push(currentChar);
            }
        }

        return Math.abs(openStack.size() - closeStack.size()) / 2;
    }

    /**
     * TODO 주어진 수식에 불필요한 괄호를 확인하는 코드를 작성하라.
     * 주어진 표현식은 유효하다고 가정, 괄호 안에 수식이 없다면 불필요한 괄호라고 판단함
     * 예) ((1 + 2)) + 3  => true
     * 예) 1 + (2 * 3)    => false (산술적으론 불필요하나, 현 문제에서는 유효하다고 가정함)
     * 예) 1 + (2) * 3    => true  (2를 감싼 괄호는 불필요함)
     */
    private boolean existUnnecessaryParentheses(String mathExpression) {
        mathExpression = removeWhiteSpace(mathExpression);

        final Stack<Character> expression = new Stack<>();

        for (char currentChar : mathExpression.toCharArray()) {
            if (!closes.contains(currentChar)) {
                expression.push(currentChar);
                continue;
            }

            char popChar = expression.pop();

            while (isNotOperator(popChar)) {
                popChar = expression.pop();

                if (opens.contains(popChar)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isNotOperator(final char popChar) {
        return popChar != '+' && popChar != '-' && popChar != '*' && popChar != '/';
    }
}
