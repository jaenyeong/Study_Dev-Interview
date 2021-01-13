package com.jaenyeong.interview._03_stack_03;

public class InfixToPostfix {

    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        String postfix = infixToPostfix.convert("(1+2)*3");
        System.out.println(postfix.equals("12+3*"));
        System.out.println(infixToPostfix.convert("1+2*3").equals("123*+"));
    }

    /**
     * TODO 인픽스를 포스트픽스로 변환하기
     */
    private String convert(String infix) {
        return infix;
    }
}
