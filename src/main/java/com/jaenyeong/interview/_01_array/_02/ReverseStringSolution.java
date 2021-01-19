package com.jaenyeong.interview._01_array._02;

public class ReverseStringSolution {

    public static void main(String[] args) {
        ReverseStringSolution reverseString = new ReverseStringSolution();
        System.out.println(reverseString.solution2("Hello".toCharArray()));
    }

    private char[] solution1(char[] message) {
        char[] reversedMessage = new char[message.length];

        for (int i = message.length - 1; i >= 0; i--) {
            reversedMessage[message.length - 1 - i] = message[i];
        }

        return reversedMessage;
    }

    // h e l l o
    // he l lo
    // 4 - 0 = 4
    // 4 - 1 = 3
    private char[] solution2(char[] message) {
        for (int i = 0; i < message.length / 2; i++) {
            char temp = message[i];
            message[i] = message[message.length - 1 - i];
            message[message.length - 1 - i] = temp;
        }

        return message;
    }
}
