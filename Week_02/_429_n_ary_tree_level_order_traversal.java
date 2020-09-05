package org.mickey.homework.week2;

import java.util.*;

/**
 * @author mickey
 * @date 8/31/20 23:39
 */
public class _429_n_ary_tree_level_order_traversal {

    /**
     * BFS 使用队列是最好理解的方式
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderUsingQueue(Node root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return r;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                level.add(node.val);
                queue.addAll(node.children);
            }
            r.add(level);
        }
        return r;
    }


    List<List<Integer>> r = new ArrayList<>();

    /**
     * Using Recursion
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderUsingRecursion(Node root) {
        if (root != null) traverseNode(root, 0);
        return r;
    }

    private void traverseNode(Node node, int level) {
        if (r.size() <= level) {
            r.add(new ArrayList<>());
        }
        r.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }


}
