package org.mickey.homework.week4;

import java.util.Arrays;

/**
 * @author mickey
 * @date 2020/9/15 17:06
 */
public class _455_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookies = 0;
        int children = 0;

        while (cookies < s.length && children < g.length) {
            if (g[children] <= s[cookies]) children++;
            cookies++;
        }
        return cookies;
    }

    public int greedy(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; j < s.length && i < g.length; j++) {
            if (g[i] <= s[j]) i++;
        }
        return i;
    }


}
