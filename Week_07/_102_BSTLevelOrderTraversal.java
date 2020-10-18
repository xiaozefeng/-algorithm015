package org.mickey.homework.week7;

import org.mickey.homework.week2.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _102_BSTLevelOrderTraversal {

    // bfs
    // dfs

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return  r;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left !=null) q.offer(node.left);
                if (node.right!=null) q.offer(node.right);
            }
            r.add(level);
        }
        return r;
    }

    public List<List<Integer>> dfsSolution(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root== null) return r;
        dfs(root, 0, r);
        return r;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> r) {
        // terminator
        if (node == null)return;
        if (level == r.size())
            r.add(new LinkedList<>());
        // process
        r.get(level).add(node.val);
        // drill down
        dfs(node.left, level + 1, r);
        dfs(node.right, level + 1, r);
        // reverse state
    }

}
