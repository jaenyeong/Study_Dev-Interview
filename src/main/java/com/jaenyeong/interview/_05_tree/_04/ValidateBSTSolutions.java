package com.jaenyeong.interview._05_tree._04;

public class ValidateBSTSolutions {

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

        ValidateBSTSolutions validateBST = new ValidateBSTSolutions();
        System.out.println(validateBST.solution(root));
    }

    private boolean solution(Node node) {
        if (node == null) {
            return true;
        }

        if (node.left != null && node.left.value > node.value) {
            return false;
        }

        if (node.right != null && node.right.value < node.value) {
            return false;
        }

        if (!solution(node.left) || !solution(node.right)) {
            return false;
        }

        return true;
    }

    private boolean solution2(Node node) {
        return isValid(node, null, null);
    }

    private boolean isValid(Node node, Node left, Node right) {
        if (node == null) {
            return true;
        }

        if (left != null && node.value <= left.value) {
            return false;
        }

        if (right != null && node.value >= right.value) {
            return false;
        }

        return isValid(node.left, left, node) &&
            isValid(node.right, node, right);
    }

    private Node prevNode;

    private boolean solution3(Node node) {
        if (node != null) {
            if (!solution(node.left)) {
                return false;
            }

            if (prevNode != null && node.value <= prevNode.value) {
                return false;
            }

            prevNode = node;
            return solution(node.right);
        }

        return true;
    }
}
