package org.mickey.homework.week2;


import java.util.*;

/**
 * @author mickey
 * @date 8/31/20 18:38
 */
public class _49_GroupAnagrams {

    /**
     * 将字符串数组中的字符，排序后放入 map中
     *
     * @return
     */
    public List<List<String>> groupAnagramsUsingSort(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<String>() {{
                    add(str);
                }});
            } else {
                m.get(key).add(str);
            }
        }
        return new ArrayList<>(m.values());
    }


    /**
     * 用 alpha beta 替代 排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] alphaBeta = new char[26];
            for (char c : str.toCharArray())
                alphaBeta[c - 'a']++;

            String key = String.valueOf(alphaBeta);
            if (!m.containsKey(key))
                m.put(key, new ArrayList<String>() {{
                    add(str);
                }});
            else
                m.get(key).add(str);

        }
        return new ArrayList<>(m.values());
    }
}
