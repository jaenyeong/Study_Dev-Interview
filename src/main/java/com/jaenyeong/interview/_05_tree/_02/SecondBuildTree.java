package com.jaenyeong.interview._05_tree._02;

import java.util.HashMap;
import java.util.Map;

public class SecondBuildTree {
    private final int[] inOrderArr;
    private final int[] postOrderArr;

    public SecondBuildTree(final int[] inOrderArr, final int[] postOrderArr) {
        this.inOrderArr = inOrderArr;
        this.postOrderArr = postOrderArr;
    }

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        final SecondBuildTree buildTree = new SecondBuildTree(new int[]{4, 2, 5, 1, 6, 3, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        final Node root = buildTree.treeBuild();
        printInOrder(root);
    }

    private static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.value);
        printInOrder(root.right);
    }

    /**
     * TODO 문제. 중위탐색과 후위탐색 결과를 가지고 이진 트리를 만드는 코드를 작성하라.
     * 중위탐색(LDR): 4, 2, 5, 1, 6, 3, 7
     * 후위탐색(DLR): 4, 5, 2, 6, 7, 3, 1
     */
    int postIndex = 0;
    private final Map<Integer, Integer> inOrderIdxMap = new HashMap<>();

    private Node treeBuild() {
        for (int i = 0; i < inOrderArr.length; i++) {
            inOrderIdxMap.put(inOrderArr[i], i);
        }

        postIndex = postOrderArr.length - 1;

        return treeBuildRecursive(0, inOrderArr.length - 1);
    }

    private Node treeBuildRecursive(final int startIdx, final int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }

        final Node currentNode = new Node(postOrderArr[postIndex--]);

        if (startIdx == endIdx) {
            return currentNode;
        }

        final int inOrderIdx = inOrderIdxMap.get(currentNode.value);

        currentNode.right = treeBuildRecursive(inOrderIdx + 1, endIdx);
        currentNode.left = treeBuildRecursive(startIdx, inOrderIdx - 1);

        return currentNode;
    }
}
