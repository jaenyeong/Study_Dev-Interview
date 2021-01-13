package com.jaenyeong.interview._05_tree_01;

public class TreeMaxDepth {

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

        TreeMaxDepth treeMaxDepth = new TreeMaxDepth();
        System.out.println(treeMaxDepth.solution(root));
    }

    /**
     * TODO 주어진 이진 트리의 높이를 구하라
     */
    private int solution(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = solution(root.left);
        int rightDepth = solution(root.right);

        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }
}
