package com.jaenyeong.interview._05_tree_03;

public class FindLCASolution2 {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                "value=" + value +
                '}';
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

        FindLCASolution2 findLCA = new FindLCASolution2();
        System.out.println(findLCA.solution(root, 4, 5));
        System.out.println(findLCA.solution(root, 2, 5));
        System.out.println(findLCA.solution(root, 3, 4));
        System.out.println(findLCA.solution(root, 3, 7));
        System.out.println(findLCA.solution(root, 3, 8));
    }

    private Node solution(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.value == n1 || root.value == n2) {
            return root;
        }

        Node leftLCA = solution(root.left, n1, n2);
        Node rightLCA = solution(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
