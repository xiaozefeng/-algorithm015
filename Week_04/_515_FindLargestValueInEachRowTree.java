package org.mickey.homework.week4;

import org.mickey.homework.week2.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mickey
 * @date 2020/9/15 11:03
 */
public class _515_FindLargestValueInEachRowTree {

    // bfs
    public List<Integer> bfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(max);
        }
        return ans;
    }

    // dfs
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode node, int level, List<Integer> ans) {
        if (node == null) return;
        if (level == ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(level, Math.max(ans.get(level), node.val));
        }

        dfs(node.left, level + 1, ans);
        dfs(node.right, level + 1, ans);
    }
}

