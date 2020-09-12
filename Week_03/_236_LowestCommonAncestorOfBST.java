package org.mickey.homework.week3;

import org.mickey.homework.week2.TreeNode;

/**
 * @author mickey
 * @date 9/12/20 17:56
 */
public class _236_LowestCommonAncestorOfBST {

    private TreeNode ans;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        boolean l_son = dfs(node.left, p, q);
        boolean r_son = dfs(node.right, p, q);

        if ((l_son && r_son) || ((node.val == p.val || node.val == q.val) && (l_son || r_son))) {
            ans = node;
        }

        return l_son || r_son || (node.val == p.val || node.val == q.val);
    }


    //lowestCommonAncestor
    public TreeNode recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = recursion(root.left, p, q);
        TreeNode right = recursion(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }


}
