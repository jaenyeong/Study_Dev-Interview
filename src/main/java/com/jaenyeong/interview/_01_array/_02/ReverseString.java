package com.jaenyeong.interview._01_array._02;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.solution("Hello".toCharArray()));
    }

    /**
     * TODO 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
     * 예) hello => olleh
     * 예) happy new year => reay wen yppah
     *
     * @param message
     * @return
     */
    private char[] solution1(final char[] message) {
        final char[] reversedMessage = new char[message.length];

        for (int i = message.length - 1; i >= 0; i--) {
            reversedMessage[message.length - 1 - i] = message[i];
        }

        return reversedMessage;
    }

    /**
     * TODO 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
     * 예) hello => olleh
     * 예) happy new year => reay wen yppah
     *
     * @param message
     * @return
     */
    private char[] solution(final char[] message) {
        for (int i = 0; i < message.length / 2; i++) {
            final char temp = message[i];
            message[i] = message[message.length - 1 - i];
            message[message.length - 1 - i] = temp;
        }

        return message;
    }
}
