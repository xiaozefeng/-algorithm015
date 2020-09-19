package org.mickey.homework.week4;

import org.mickey.homework.week2.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mickey
 * @date 9/14/20 22:54
 */
public class _102_BST_LevelOrderTraversal {

    // bfs
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(level);
        }
        return ans;
    }


    // dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> ans) {
        if (node == null) return ;
        if (level == ans.size()) {
            ans.add(new LinkedList<>());
        }

        ans.get(level).add(node.val);
        dfs(node.left, level + 1, ans);
        dfs(node.right, level + 1, ans);
    }


}
