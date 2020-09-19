package org.mickey.homework.week4;

import org.mickey.homework.week2.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 2020/9/17 19:01
 */
public class _297_SerializeAndDeserializeBinaryTree {

    static class DFSCodec {
        private final static String delimiter = ",";
        private final static String placeHolder = "X";

        public String serialize(TreeNode root) {
            StringBuilder result = new StringBuilder();
            convertToString(root, result);
            return result.toString();
        }

        private void convertToString(TreeNode node, StringBuilder result) {
            if (node == null) {
                result.append(placeHolder).append(delimiter);
            } else {
                result.append(node.val).append(delimiter);
                convertToString(node.left, result);
                convertToString(node.right, result);
            }
        }

        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Deque<String> nodes) {
            String val = nodes.remove();
            if (val.equals(placeHolder)) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
    }

}
