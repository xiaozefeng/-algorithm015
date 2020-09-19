package org.mickey.homework.week4;

import org.mickey.homework.week2.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 2020/9/17 16:10
 */
public class _111_MinimumDepthOfBinaryTree {

    private static class Node {
        TreeNode treeNode;
        int depth;

        public Node(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    //bfs
    public int bfs(TreeNode root) {
        if (root == null) return 0;
        Deque<Node> q = new LinkedList<>();
        q.offer(new Node(root, 1));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int depth = node.depth;
            TreeNode treeNode = node.treeNode;
            if (treeNode.left == null
                    && treeNode.right == null) return depth;

            if (treeNode.left != null) q.offer(new Node(treeNode.left, depth + 1));
            if (treeNode.right != null) q.offer(new Node(treeNode.right, depth + 1));
        }
        return 0;
    }

    public int minDepth(TreeNode root){
        // terminator
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;


        // drill down
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        // process
        if (root.left == null || root.right == null) return leftHeight + rightHeight + 1;

        return Math.min(leftHeight, rightHeight) + 1;

        // reverse state
    }



}
