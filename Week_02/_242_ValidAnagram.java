package org.mickey.homework.week2;


import java.util.Arrays;

/**
 * @author mickey
 * @date 8/31/20 16:23
 */
public class _242_ValidAnagram {

    /**
     * 1. traverse String s , find s.charAt in alphabet and increase
     * 2. traverse String t , find t.charAt in alphabet and decrease
     * 3. traverse alphabet , judge element value
     */
    public boolean isAnagramUsingCharArray(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    /**
     * is better for isAnagramUsingCharArray
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramTraversalTwice(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if (alphabet[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }


    /**
     * sort s,t and compare them
     */
    public boolean isAnagramUsingSort(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        Arrays.sort(c1);
        char[] c2 = t.toCharArray();
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
