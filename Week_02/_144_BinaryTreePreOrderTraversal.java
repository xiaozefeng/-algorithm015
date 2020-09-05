package org.mickey.homework.week2;

import java.util.*;

/**
 * @author mickey
 * @date 8/31/20 22:23
 */
public class _144_BinaryTreePreOrderTraversal {

    /**
     * Recursion
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalUsingRecursion(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        inner_preorder(root, r);
        return r;
    }

    private void inner_preorder(TreeNode node, List<Integer> r) {
        if (node == null) return;
        r.add(node.val);
        inner_preorder(node.left, r);
        inner_preorder(node.right, r);
    }


    /**
     * Iteration and using stack
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalUsingIteration(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            r.add(node.val);
            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }
        return r;
    }
}
