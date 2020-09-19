package org.mickey.homework.week4;

import org.mickey.homework.week2.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mickey
 * @date 2020/9/17 15:02
 */
public class _98_ValidateBST {

    // determine if it is a bst
    // bst 中序遍历时有序的
    // 1. 对中序遍历的结果，判断是否有序
    public boolean bruteForce(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        inorder(root, r);
        for (int i = 1; i < r.size(); i++) {
            if (r.get(i) <= r.get(i - 1)) return false;
        }
        return true;
    }

    private void inorder(TreeNode node, List<Integer> r) {
        if (node == null) return;
        inorder(node.left, r);
        r.add(node.val);
        inorder(node.right, r);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer low, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (low != null && low >= val) return false;

        if (upper != null && upper <= val) return false;

        if (!dfs(node.left, low, val)) return false;

        if (!dfs(node.right, val, upper)) return false;

        return true;
    }


}
