package org.mickey.homework.week3;

import org.mickey.homework.week2.TreeNode;

import java.util.*;

/**
 * @author mickey
 * @date 9/11/20 21:50
 */
public class _98_ValidBST {

    // 1. 中序遍历后，看看是否有序
    public boolean inorderSolution(TreeNode root) {
        if (root == null) return true;
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        for (int i = 1; i < ans.size(); i++)
            if (ans.get(i) <= ans.get(i - 1)) return false;
        return true;
    }

    private void inorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }


    // 2. 边递归边判断， 剪枝
    public boolean recursionSolution(TreeNode root) {
        return is_valid_bst(root, null, null);
    }

    private boolean is_valid_bst(TreeNode node, Integer lower, Integer upper) {
        // terminator
        if (node == null) return true; //能遍历到底表示是一颗bst
        // process current level logic
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        // drill down
        if (!is_valid_bst(node.left, lower, val)) return false;
        if (!is_valid_bst(node.right, val, upper)) return false;
        return true;
        // revert state
    }


    // 3. 迭代版中序遍历
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double miniValue = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= miniValue) return false;
            miniValue = root.val;
            root = root.right;
        }
        return true;
    }

}
