package com.jaenyeong.interview._05_tree._01;

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
        System.out.println(treeMaxDepth.getTreeDepth(root));
    }

    /**
     * TODO 주어진 이진 트리의 높이를 구하라
     */
    private int getTreeDepth(Node root) {
        if (root == null) {
            return 0;
        }

        final int leftTreeDepth = getTreeDepth(root.left);
        final int rightTreeDepth = getTreeDepth(root.right);

        return leftTreeDepth > rightTreeDepth ? leftTreeDepth + 1 : rightTreeDepth + 1;
    }
}
