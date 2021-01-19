package com.jaenyeong.interview._05_tree._01;

public class PostOrderSolution {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        PostOrderSolution postOrder = new PostOrderSolution();
        postOrder.print(root, 4);
    }

    private int count = 0;

    private void print(Node root, int index) {
        if (root != null) {
            print(root.left, index);
            print(root.right, index);

            if (count++ == index - 1) {
                System.out.println(root.value);
            }
        }
    }
}
