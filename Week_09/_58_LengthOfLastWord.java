package org.mickey.homework.week9;

/**
 * @author mickey
 * @date 10/30/20 22:58
 */
public class _58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public int solution2(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
