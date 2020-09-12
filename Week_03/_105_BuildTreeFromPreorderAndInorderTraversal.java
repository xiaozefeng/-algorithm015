package org.mickey.homework.week3;

import org.mickey.homework.week2.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mickey
 * @date 9/12/20 21:36
 */
public class _105_BuildTreeFromPreorderAndInorderTraversal {

    Map<Integer, Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++)
            m.put(inorder[i], i);

        return build_tree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build_tree(int[] preorder, int[] inorder, int preorder_l, int preorder_r, int inorder_l, int inorder_r) {
        // terminator
        if (preorder_l > preorder_r) return null;

        // process
        int inorder_root = m.get(preorder[preorder_l]);

        TreeNode root = new TreeNode(preorder[preorder_l]);

        int size_left_subtree = inorder_root - inorder_l;

        // drill down
        root.left = build_tree(preorder, inorder, preorder_l + 1, preorder_l + size_left_subtree, inorder_l, inorder_root - 1);
        root.right = build_tree(preorder, inorder, preorder_l + size_left_subtree + 1, preorder_r, inorder_root + 1, inorder_r);

        return root;
        // reverse state if needed
    }
}
