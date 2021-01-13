package com.jaenyeong.interview._03_stack_02;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CheckingBracketsSolution {

    public static void main(String[] args) {
        CheckingBracketsSolution checkingBrackets = new CheckingBracketsSolution();
        System.out.println(checkingBrackets.check("[{1 + 2 * (2 + 2)} - (1 - 3)]"));
        System.out.println(checkingBrackets.check("[{1 + 2 * (2 + 2)} - [1 - 3)]"));
    }

    private boolean check(String mathExpression) {
        Stack<Character> brackets = new Stack<>();
        List<Character> openingBrackets = Arrays.asList('{', '[', '(');
        List<Character> closingBrackets = Arrays.asList('}', ']', ')');

        for (char c : mathExpression.toCharArray()) {
            if (openingBrackets.contains(c)) {
                brackets.push(c);
            } else if (closingBrackets.contains(c)) {
                Character openingBracket = brackets.pop();
                if (openingBrackets.indexOf(openingBracket) != closingBrackets.indexOf(c)) {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }
}
