package com.jaenyeong.interview._05_tree._04;

public class ValidateBST {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(5);

        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.validate(root));
    }

    /**
     * TODO 주어진 이진 트리가 BST 인지 확인하는 코드를 작성하라.
     */
    private boolean validate(Node node) {
        if (node == null) {
            return true;
        }

        if (node.left != null && node.value <= node.left.value) {
            return false;
        }

        if (node.right != null && node.value >= node.right.value) {
            return false;
        }

        return validate(node.left) && validate(node.right);
    }
}
