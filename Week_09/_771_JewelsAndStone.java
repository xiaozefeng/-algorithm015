package org.mickey.homework.week9;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mickey
 * @date 10/30/20 23:31
 */
public class _771_JewelsAndStone {

    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> setJ = new HashSet<>();
        for (char j: J.toCharArray())
            setJ.add(j);
        for (char s: S.toCharArray())
            if (setJ.contains(s)) res++;
        return res;
    }
}
