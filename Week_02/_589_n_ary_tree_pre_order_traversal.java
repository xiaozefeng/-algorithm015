package org.mickey.homework.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mickey
 * @date 8/31/20 23:39
 */
public class _589_n_ary_tree_pre_order_traversal {
    /**
     * Recursion
     *
     * @param root
     * @return
     */
    public List<Integer> preorderUsingRecursion(Node root) {
        List<Integer> r = new ArrayList<>();
        inner_preorder(root, r);
        return r;
    }

    private void inner_preorder(Node node, List<Integer> r) {
        if (node == null) return;
        r.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                inner_preorder(child, r);
            }
        }
    }


    /**
     * Iteration
     *
     * @param root
     * @return
     */
    public List<Integer> preorderUsingIterate(Node root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            r.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return r;
    }

}
