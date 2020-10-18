package org.mickey.homework.week7;

public class TrieSolution2 {

    private static class Node {
        public char val;
        public boolean endOfWord;
        public Node[] children = new Node[26];

        public Node() {
        }

        public Node(char c) {
            Node node = new Node();
            node.val = c;
        }
    }


    private final Node root;

    public TrieSolution2() {
        root = new Node();
        root.val = ' ';
    }


    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Node(c);
            cur = cur.children[c - 'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.endOfWord;
    }


    public boolean startWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }

}
