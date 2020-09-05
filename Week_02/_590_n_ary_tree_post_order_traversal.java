package org.mickey.homework.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author mickey
 * @date 8/31/20 23:39
 */
public class _590_n_ary_tree_post_order_traversal {
    public List<Integer> postorderUsingRecursion(Node root) {
        List<Integer> result = new ArrayList<>();
        post_order(root, result);
        return result;
    }

    private void post_order(Node node, List<Integer> data) {
        if (node == null) return;
        if (node.children != null)
            for (Node child : node.children)
                post_order(child, data);

        data.add(node.val);
    }

    public List<Integer> postorderUsingIterate(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }

        }
        Collections.reverse(result);
        return result;
    }

}
