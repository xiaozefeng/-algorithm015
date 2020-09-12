package org.mickey.homework.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mickey
 * @date 2020/9/11 15:14
 */
public class _22_GenerateParenthesis {

    public List<String> bruteForce(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> combinations) {
        //terminator
        if (pos == current.length) {
            if (valid(current))
                combinations.add(String.valueOf(current));
        } else {
            // process current level logic
            current[pos] = '(';
            // drill down
            generateAll(current, pos + 1, combinations);
            current[pos] = ')';
            generateAll(current, pos + 1, combinations);
        }
        // revert state
    }

    private boolean valid(char[] chars) {
        int balance = 0;
        for (char c : chars) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }


    // 回溯
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }

    private void generate(List<String> ans, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            ans.add(current);
            return;
        }

        if (open < max) 
            generate(ans, current + "(", open + 1, close, max);
        if (close < open)
            generate(ans, current + ")", open, close + 1, max);
    }




}
