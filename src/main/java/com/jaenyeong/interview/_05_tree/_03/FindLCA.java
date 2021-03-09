package com.jaenyeong.interview._05_tree._03;

import java.util.ArrayList;
import java.util.List;

public class FindLCA {

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
        final Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        final FindLCA findLCA = new FindLCA();
        System.out.println(findLCA.getLCA(root, 4, 5)); // 2
        System.out.println(findLCA.getLCA(root, 2, 5)); // 2
        System.out.println(findLCA.getLCA(root, 3, 4)); // 1
        System.out.println(findLCA.getLCA(root, 3, 7)); // 3
        System.out.println(findLCA.getLCA(root, 3, 8)); // null
    }

    /**
     * TODO 주어진 이진 트리 (node) 에서 두 노드 n1, n2의 가장 가까운 공통 조상(Lowest Common Ancestor)을 찾는 코드를 작성하라.
     */
    private Node getLCA(Node root, int n1, int n2) {
        final List<Node> n1Path = new ArrayList<>();
        final List<Node> n2Path = new ArrayList<>();

        if (!findPath(root, n1, n1Path) || !findPath(root, n2, n2Path)) {
            return null;
        }

        int idx = 0;
        while (idx < n1Path.size() && idx < n2Path.size()) {
            if (!n1Path.get(idx).equals(n2Path.get(idx))) {
                break;
            }
            idx++;
        }

        return n1Path.get(idx - 1);
    }

    private boolean findPath(final Node node, final int targetValue, final List<Node> path) {
        if (node == null) {
            return false;
        }

        path.add(node);

        if (node.value == targetValue) {
            return true;
        }

        if (findPath(node.left, targetValue, path)) {
            return true;
        }

        if (findPath(node.right, targetValue, path)) {
            return true;
        }

        path.remove(node);
        return false;
    }
}
