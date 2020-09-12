package org.mickey.homework.week3;

import org.mickey.homework.week2.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 9/11/20 23:50
 */
public class _104_MaximumDepthOfBST {

    public int maxDepth(TreeNode root) {
        // terminator
        if (root == null) return 0;

        // process logic

        // drill down
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;

        // revert state
    }


    // bfs
    public int bfsSolution(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            ans++;
        }
        return ans;
    }
}
