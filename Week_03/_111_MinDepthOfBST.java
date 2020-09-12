package org.mickey.homework.week3;

import org.mickey.homework.week2.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 9/12/20 09:40
 */
public class _111_MinDepthOfBST {

    // dfs
    public int minDepth(TreeNode root) {
        // terminator
        if (root == null) return 0;

        //process
        if (root.left == null || root.right == null) return 1;
        int min_depth = Integer.MAX_VALUE;

        // drill down
        if (root.left != null)
            min_depth = Math.min(minDepth(root.left), min_depth);

        if (root.right != null)
            min_depth = Math.min(minDepth(root.right), min_depth);
        return min_depth + 1;
        // revert state
    }


    // dfs
    public int anotherDFS(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        int leftHeight = anotherDFS(root.left);
        int rightHeight = anotherDFS(root.right);
        if (root.left == null || root.right == null) return leftHeight + rightHeight + 1;
        return Math.min(leftHeight, rightHeight) + 1;
    }


    private static class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }


    // bfs
    public int bfs(TreeNode root) {
        if (root == null) return 0;
        Deque<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode qd = queue.poll();
            TreeNode node = qd.node;
            int depth = qd.depth;

            if (node.left == null && node.right == null)
                return depth;
            if (node.left != null) queue.offer(new QueueNode(node.left, depth + 1));
            if (node.right != null) queue.offer(new QueueNode(node.right, depth + 1));
        }
        return 0;
    }

}
