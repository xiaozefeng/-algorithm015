package org.mickey.homework.week3;

import org.mickey.homework.week2.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 9/12/20 16:57
 */
public class _297_SerializeAndDeSerializeBST {
    private static final String SPLITER = ",";
    private static final String PLACEHOLDER = "X";

    public String serialize(TreeNode root) {
        StringBuilder r = new StringBuilder();
        inner_serialize(root, r);
        return r.toString();
    }

    private void inner_serialize(TreeNode node, StringBuilder r) {
        if (node == null) {
            r.append(PLACEHOLDER).append(SPLITER);
        } else {
            r.append(node.val).append(SPLITER);
            inner_serialize(node.left, r);
            inner_serialize(node.right, r);
        }
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(SPLITER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(PLACEHOLDER))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

}
