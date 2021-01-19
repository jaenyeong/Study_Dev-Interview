package com.jaenyeong.interview._03_stack._02;

public class CheckingBrackets {

    public static void main(String[] args) {
        CheckingBrackets checkingBrackets = new CheckingBrackets();
        System.out.println(checkingBrackets.check("[{1 + 2 * (2 + 2)} - (1 - 3)]"));
        System.out.println(checkingBrackets.check("[{1 + 2 * (2 + 2)} - [1 - 3)]"));
        System.out.println(checkingBrackets.check("((())"));
        System.out.println(checkingBrackets.check("(()))"));
        System.out.println(checkingBrackets.check("{{()}}"));
    }

    /**
     * TODO 주어진 수식의 괄호짝이 맞는지 확인하는 코드를 작성하라.
     * 예) [{1 + 2 * (2 + 2)} - (1 - 3)]   => true
     * 예) [{1 + 2 * (2 + 2)} - [1 - 3)]   => false
     */
    private boolean check(String mathExpression) {
        return false;
    }
}
