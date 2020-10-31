package org.mickey.homework.week9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mickey
 * @date 10/31/20 11:42
 */
public class _387_FirstUniqueCharacterInString {
    public int solution1(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (m.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int solution2(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

}
