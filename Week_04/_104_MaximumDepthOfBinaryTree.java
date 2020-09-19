package org.mickey.homework.week4;

import org.mickey.homework.week2.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 2020/9/17 15:41
 */
public class _104_MaximumDepthOfBinaryTree {

    //dfs
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    //bfs
    public int bfs(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans += 1;
        }
        return ans;
    }

}
