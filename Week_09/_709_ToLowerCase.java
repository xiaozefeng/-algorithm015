package org.mickey.homework.week9;


public class _709_ToLowerCase {

    // solution1
    public String solution1(String str) {
        if (str == null) return null;
        return str.toLowerCase();
    }

    // solution2
    public String solution2(String str) {
        if (str == null || str.length() == 0) return str;
        char[] chars = str.toCharArray();
        for (int i =0 ; i<chars.length; i ++) {
            if ( chars[i] >='A' && chars[i] <='Z')
                chars[i] += 32;
        }
        return String.valueOf(chars);
    }

    // solution3
    public String solution3(String str) {
        if (str == null || str.length() == 0) return str;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >='A' && chars[i] <='Z')
                chars[i] |=32;
        }
        return String.valueOf(chars);
    }

    // solution4
    public String solution4(String str) {
        if (str == null || str.length() ==0) return str;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A'<= chars[i] && chars[i] <='Z')
                chars[i] = (char)(chars[i] -'A' + 'a');
        }
        return String.valueOf(chars);
    }
}

