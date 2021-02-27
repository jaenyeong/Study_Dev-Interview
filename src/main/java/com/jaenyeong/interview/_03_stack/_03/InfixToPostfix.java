package com.jaenyeong.interview._03_stack._03;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        final InfixToPostfix infixToPostfix = new InfixToPostfix();

        System.out.println(infixToPostfix.getPostfixFromInfix("(1+2)*3").equals("12+3*"));
        System.out.println(infixToPostfix.getPostfixFromInfix("1+2*3").equals("123*+"));
        System.out.println(infixToPostfix.getPostfixFromInfix("(1 - (2 + 3)) * 5").equals("123+-5*"));

        System.out.println(infixToPostfix.getInfixFromPostfix("12+").equals("1 + 2"));
        System.out.println(infixToPostfix.getInfixFromPostfix("12+3+4*").equals("((1 + 2) + 3) * 4"));
        System.out.println(infixToPostfix.getInfixFromPostfix("12+34+*").equals("(1 + 2) * (3 + 4)"));

        System.out.println(infixToPostfix.getPrefixFromInfix("(1 + 2) * 3").equals("*+123"));
        System.out.println(infixToPostfix.getPrefixFromInfix("2 * 3 + 4 / 2").equals("+*23/42"));
        System.out.println(infixToPostfix.getPrefixFromInfix("2 + 3 * 4 + 2").equals("++2*342"));

        System.out.println(infixToPostfix.getInfixFromPrefix("*+132").equals("(1 + 3) * 2"));
        System.out.println(infixToPostfix.getInfixFromPrefix("++2*342").equals("(2 + (3 * 4)) + 2"));
        System.out.println(infixToPostfix.getInfixFromPrefix("*-6/42-/621").equals("(6 - (4 / 2)) * ((6 / 2) - 1)"));

        System.out.println(infixToPostfix.getPostfixFromPrefix("*+39-73").equals("39+73-*"));
        System.out.println(infixToPostfix.getPostfixFromPrefix("*-8/62-/841").equals("862/-84/1-*"));

        System.out.println(infixToPostfix.getPrefixFromPostfix("39+73-*").equals("*+39-73"));
        System.out.println(infixToPostfix.getPrefixFromPostfix("862/-84/1-*").equals("*-8/62-/841"));
    }

    /**
     * TODO 인픽스를 포스트픽스로 변환하기
     * 올바른 수식이라고 가정
     */
    private String getPostfixFromInfix(String infix) {
        infix = removeWhiteSpace(infix);

        final StringBuilder postfixBuilder = new StringBuilder();
        final Stack<Character> operatorStack = new Stack<>();

        for (char element : infix.toCharArray()) {
            if (Character.isDigit(element)) {
                postfixBuilder.append(element);
                continue;
            }

            if (element == '(') {
                operatorStack.push(element);
                continue;
            }

            if (element == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixBuilder.append(operatorStack.pop());
                }

                operatorStack.pop();
                continue;
            }

            while (!operatorStack.isEmpty() && pushAble(operatorStack.peek(), element)) {
                postfixBuilder.append(operatorStack.pop());
            }

            operatorStack.push(element);
        }

        while (!operatorStack.isEmpty()) {
            postfixBuilder.append(operatorStack.pop());
        }

        return postfixBuilder.toString();
    }

    private String removeWhiteSpace(final String mathExpression) {
        return mathExpression.replace(" ", "");
    }

    private boolean pushAble(final char operatorInStack, final char currentOperator) {
        final int stackOperatorValue = operatorPrecedence(operatorInStack);
        final int currentOperatorValue = operatorPrecedence(currentOperator);

        return stackOperatorValue >= currentOperatorValue;
    }

    private int operatorPrecedence(char letter) {
        if (letter == '+' || letter == '-') {
            return 1;
        }

        if (letter == '*' || letter == '/') {
            return 10;
        }

        if (letter == '^') {
            return 3;
        }

        return -10;
    }

    /**
     * TODO 포스트픽스를 인픽스로 변환하기
     * 올바른 수식이라고 가정
     */
    private String getInfixFromPostfix(String postfix) {
        postfix = removeWhiteSpace(postfix);
        final Stack<String> operands = new Stack<>();

        final int lastIdx = postfix.length() - 1;
        for (int i = 0; i < lastIdx; i++) {
            final char currentLetter = postfix.charAt(i);

            if (isOperator(currentLetter)) {
                final String secondExpression = operands.pop();
                final String firstExpression = operands.pop();

                operands.push("(" + generateOperand(currentLetter, firstExpression, secondExpression) + ")");
                continue;
            }

            operands.push(currentLetter + "");
        }

        final String secondExpression = operands.pop();
        final String firstExpression = operands.pop();

        return generateOperand(postfix.charAt(lastIdx), firstExpression, secondExpression);
    }

    private boolean isOperator(char letter) {
        return letter == '+' || letter == '-' || letter == '*' || letter == '/' || letter == '^';
    }

    private String generateOperand(final char currentLetter, final String firstExpression, final String secondExpression) {
        return firstExpression + " " + currentLetter + " " + secondExpression;
    }

    /**
     * TODO 인픽스를 프리픽스로 변환하기
     * 올바른 수식이라고 가정
     */
    private String getPrefixFromInfix(String infix) {
        infix = removeWhiteSpace(infix);

        final Stack<Character> operators = new Stack<>();
        final Stack<String> operands = new Stack<>();

        for (char letter : infix.toCharArray()) {
            if (letter == '(') {
                operators.push(letter);
                continue;
            }

            if (letter == ')') {
                while (!operators.empty() && operators.peek() != '(') {
                    generateOperand(operators, operands);
                }

                operators.pop();
                continue;
            }

            if (!isOperator(letter)) {
                operands.push(letter + "");
                continue;
            }

            while (!operators.empty() && pushAble(operators.peek(), letter)) {
                generateOperand(operators, operands);
            }

            operators.push(letter);
        }

        while (!operators.empty()) {
            generateOperand(operators, operands);
        }

        return operands.pop();
    }

    private void generateOperand(final Stack<Character> operators, final Stack<String> operands) {
        final String secondOperand = operands.pop();
        final String firstOperand = operands.pop();

        final char operator = operators.pop();

        operands.push(operator + firstOperand + secondOperand);
    }

    /**
     * TODO 프리픽스를 인픽스로 변환하기
     * 올바른 수식이라고 가정
     */
    private String getInfixFromPrefix(String prefix) {
        prefix = removeWhiteSpace(prefix);

        final Stack<String> operands = new Stack<>();

        final int lastIdx = prefix.length() - 1;

        for (int i = lastIdx; i > 0; i--) {
            final char currentLetter = prefix.charAt(i);

            if (isOperator(currentLetter)) {
                final String firstOperand = operands.pop();
                final String secondOperand = operands.pop();

                operands.push("(" + generateOperand(currentLetter, firstOperand, secondOperand) + ")");
                continue;
            }

            operands.push(currentLetter + "");
        }

        final String firstOperand = operands.pop();
        final String secondOperand = operands.pop();

        return generateOperand(prefix.charAt(0), firstOperand, secondOperand);
    }

    /**
     * TODO 프리픽스를 포스트픽스로 변환하기
     * 올바른 수식이라고 가정
     */
    private String getPostfixFromPrefix(String prefix) {
        prefix = removeWhiteSpace(prefix);

        final Stack<String> operands = new Stack<>();

        final int lastIdx = prefix.length() - 1;

        for (int i = lastIdx; i >= 0; i--) {
            final char currentLetter = prefix.charAt(i);

            if (isOperator(currentLetter)) {
                final String firstOperand = operands.pop();
                final String secondOperand = operands.pop();

                operands.push(firstOperand + secondOperand + currentLetter);
                continue;
            }

            operands.push(currentLetter + "");
        }

        return operands.pop();
    }

    /**
     * TODO 포스트픽스를 프리픽스로 변환하기
     * 올바른 수식이라고 가정
     */
    private String getPrefixFromPostfix(String postfix) {
        postfix = removeWhiteSpace(postfix);

        final Stack<String> operands = new Stack<>();

        for (char currentLetter : postfix.toCharArray()) {
            if (isOperator(currentLetter)) {
                final String secondOperand = operands.pop();
                final String firstOperand = operands.pop();

                operands.push(currentLetter + firstOperand + secondOperand);
                continue;
            }

            operands.push(currentLetter + "");
        }

        final StringBuilder prefixBuilder = new StringBuilder();
        for (String operand : operands) {
            prefixBuilder.append(operand);
        }

        return prefixBuilder.toString();
    }
}
