package org.mickey.homework.week4;

import javafx.util.Pair;

import java.util.*;

/**
 * @author mickey
 * @date 2020/9/19 11:44
 */
public class _127_WordLadder {


    // BFS
    public int bfs(String beginWord, String endWord, List<String> wordList) {
        int l = beginWord.length();
        Map<String, List<String>> m = new HashMap<>();

        // 预处理 word list
        for (String word : wordList) {
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, l);
                List<String> transformations = m.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                m.put(newWord, transformations);
            }
        }

        // BFS
        Deque<Pair<String, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.poll();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, l);

                for (String adjacentWord : m.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        q.offer(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }


}
