package org.mickey.homework.week4;

import org.mickey.homework.week2.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 2020/9/17 14:47
 */
public class _226_InvertBinaryTree {

    // 交换左右子树
    // dfs
    public TreeNode invertTree(TreeNode root) {
        // terminator
        if (root == null) return null;
        // process
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        // drill down
        invertTree(root.left);
        invertTree(root.right);
        return root;
        // reverse state
    }


    // bfs 层序遍历左右子树的节点可以同时被访问到
    public TreeNode bfs(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return root;
    }
}
