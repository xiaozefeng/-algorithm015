package org.mickey.homework.week7;

import java.util.HashMap;
import java.util.Map;

public class TrieSolution1 {

    private static class Node {
        public Map<Character, Node> next;
        public boolean endOfWord;

        public Node() {
            this(false);
        }

        public Node(boolean endOfWord) {
            this.endOfWord = endOfWord;
            this.next = new HashMap<>();
        }
    }

    private final Node root;

    /** Initialize your data structure here. */
    public TrieSolution1() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next.get(c) == null)
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }
        if (!cur.endOfWord){
            cur.endOfWord = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for( char c:prefix.toCharArray()) {
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */