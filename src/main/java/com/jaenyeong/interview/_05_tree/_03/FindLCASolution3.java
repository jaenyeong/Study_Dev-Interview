package com.jaenyeong.interview._05_tree._03;

public class FindLCASolution3 {

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
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        FindLCASolution3 findLCA = new FindLCASolution3();
        System.out.println(findLCA.solution(root, 1, 3)); // 2
        System.out.println(findLCA.solution(root, 1, 2)); // 2
        System.out.println(findLCA.solution(root, 1, 5)); // 4
        System.out.println(findLCA.solution(root, 5, 7)); // 6
        System.out.println(findLCA.solution(root, 2, 7)); // 4
    }

    private Node solution(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        int value = root.value;
        if (value < n1 && value < n2) {
            return solution(root.right, n1, n2);
        }

        if (value > n1 && value > n2) {
            return solution(root.left, n1, n2);
        }

        return root;
    }
}
