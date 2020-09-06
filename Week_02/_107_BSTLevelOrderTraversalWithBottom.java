package org.mickey.homework.week2;

import java.util.*;

/**
 * @author mickey
 * @date 9/6/20 16:16
 */
public class _107_BSTLevelOrderTraversalWithBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return r;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            TreeNode node = queue.poll();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                level.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            r.add(level);
        }
        Collections.reverse(r);
        return r;
    }
}
