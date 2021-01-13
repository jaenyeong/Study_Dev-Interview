package com.jaenyeong.interview._05_tree_02;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeSolution {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BuildTreeSolution buildTree = new BuildTreeSolution();
        Node root = buildTree.build(new int[]{4, 2, 5, 1, 6, 3}, new int[]{1, 2, 4, 5, 3, 6});
        printInOrder(root);
    }

    private static void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.println(root.value);
            printInOrder(root.right);
        }
    }

    Map<Integer, Integer> indexMap;
    int preIndex = 0;

    private Node build(int[] inOrder, int[] preOrder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }

        return buildRecurse(inOrder, preOrder, 0, inOrder.length - 1);
    }

    private Node buildRecurse(int[] inOrder, int[] preOrder, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        Node node = new Node(preOrder[preIndex++]);

        if (startIndex == endIndex) {
            return node;
        }

        int inIndex = searchIndex(inOrder, startIndex, endIndex, node.value);

        node.left = buildRecurse(inOrder, preOrder, startIndex, inIndex - 1);
        node.right = buildRecurse(inOrder, preOrder, inIndex + 1, endIndex);

        return node;
    }

    private int searchIndex(int[] inOrder, int startIndex, int endIndex, int value) {
        for (int i = startIndex; i < endIndex + 1; i++) {
            if (inOrder[i] == value) {
                return i;
            }
        }

        return 0;
    }
}
