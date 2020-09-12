package org.mickey.homework.week3;

import org.mickey.homework.week2.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 9/11/20 21:29
 */
public class _226_InvertBinaryTree {

    // Recursion Solution 1
    public TreeNode invertTree(TreeNode root) {
        // terminator
        if (root == null) return null;
        // process current level logic
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        // drill down
        root.left = right;
        root.right = left;
        return root;
        // revert state
    }


    // Recursion Solution 2
    public TreeNode invertTreeRecursion(TreeNode root) {
        // terminator
        if (root == null) return null;

        // process current level logic
        TreeNode left = root.left;
        TreeNode right = root.right;

        // drill down
        root.left = invertTreeRecursion(right);
        root.right = invertTreeRecursion(left);

        // revert state
        return root;
    }


    // Iteration Solution
    public TreeNode iterationSolution(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }


}
