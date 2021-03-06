package com.jaenyeong.interview._05_tree._01;

public class PostOrder {

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

        PostOrder postOrder = new PostOrder();
        postOrder.nodePrint(root, 4);
    }

    private int nodePrintCount = 0;

    /**
     * TODO 주어진 이진 트리에서 후위탐색(왼쪽, 오른쪽, 루트 순서)시 n번째에 해당하는 값을 출력하라.
     */
    private void nodePrint(Node root, int index) {
        if (root == null) {
            return;
        }

        nodePrint(root.left, index);
        nodePrint(root.right, index);

        if (nodePrintCount++ == index) {
            System.out.println(root.value);
        }
    }
}
