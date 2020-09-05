package org.mickey.homework.week2;

import java.util.*;

/**
 * @author mickey
 * @date 8/31/20 22:23
 */
public class _94_BinaryTreeInOrderTraversal {


    /**
     * Recursion
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalUsingRecursion(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        inner_inorder(root, r);
        return r;
    }

    private void inner_inorder(TreeNode node, List<Integer> r) {
        if (node == null) return;
        inner_inorder(node.left, r);
        r.add(node.val);
        inner_inorder(node.right, r);
    }


    /**
     * Iteration and using stack
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalUsingIteration(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            r.add(cur.val);
            cur = cur.right;
        }
        return r;
    }


}
