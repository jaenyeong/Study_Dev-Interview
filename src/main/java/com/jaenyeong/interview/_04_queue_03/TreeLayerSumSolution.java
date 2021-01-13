package com.jaenyeong.interview._04_queue_03;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLayerSumSolution {

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

        TreeLayerSumSolution treeLayerSum = new TreeLayerSumSolution();
        System.out.println(treeLayerSum.maxSum(root) == 15);
    }

    private int maxSum(Node root) {
        if (root == null) {
            return 0;
        }

        int result = root.value;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            int sum = 0;

            while (count > 0) {
                count--;
                Node node = queue.poll();
                sum += node.value;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result = Math.max(sum, result);
        }

        return result;
    }
}
