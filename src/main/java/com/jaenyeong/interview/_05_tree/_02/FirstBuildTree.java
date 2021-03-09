package com.jaenyeong.interview._05_tree._02;

import java.util.HashMap;
import java.util.Map;

public class FirstBuildTree {
    private final int[] preOrderArr;
    private final int[] inOrderArr;

    public FirstBuildTree(final int[] preOrderArr, final int[] inOrderArr) {
        this.preOrderArr = preOrderArr;
        this.inOrderArr = inOrderArr;
    }

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        final FirstBuildTree buildTree = new FirstBuildTree(new int[]{1, 2, 4, 5, 3, 6}, new int[]{4, 2, 5, 1, 6, 3});
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
     * TODO 문제. 중위탐색과 전위탐색 결과를 가지고 이진 트리를 만드는 코드를 작성하라.
     * 중위탐색(LDR): 4, 2, 5, 1, 6, 3
     * 전위탐색(DLR): 1, 2, 4, 5, 3, 6
     */
    int preIndex = 0;
    private final Map<Integer, Integer> inOrderIdxMap = new HashMap<>();

    private Node treeBuild() {
        for (int i = 0; i < inOrderArr.length; i++) {
            inOrderIdxMap.put(inOrderArr[i], i);
        }

        return treeBuildRecursive(0, inOrderArr.length - 1);
    }

    private Node treeBuildRecursive(final int startIdx, final int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }

        final Node currentNode = new Node(preOrderArr[preIndex++]);

        if (startIdx == endIdx) {
            return currentNode;
        }

        final int inOrderIdx = inOrderIdxMap.get(currentNode.value);

        currentNode.left = treeBuildRecursive(startIdx, inOrderIdx - 1);
        currentNode.right = treeBuildRecursive(inOrderIdx + 1, endIdx);

        return currentNode;
    }
}
