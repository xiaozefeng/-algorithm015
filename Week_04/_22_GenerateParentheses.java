package org.mickey.homework.week4;


import java.util.ArrayList;
import java.util.List;

/**
 * @author mickey
 * @date 9/15/20 09:22
 */
public class _22_GenerateParentheses {
    public List<String> bruteForce(int n) {
        List<String> ans = new ArrayList<>();
        generate_parenthesis(new char[2 *n], 0 , ans);
        return ans;
    }

    private void generate_parenthesis(char[] current, int pos, List<String> ans) {
        if (pos == current.length) {
            if (valid(current))
                ans.add(String.valueOf(current));
        }else {
            current[pos] = '(';
            generate_parenthesis(current, pos +1, ans);
            current[pos] = ')';
            generate_parenthesis(current, pos + 1, ans);
        }

    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance --;
            if (balance <0) return false;
        }
        return balance ==0;
    }



    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(0, 0, n, "", ans);
        return ans;
    }

    private void backtracking(int left , int right, int n, String current, List<String> ans) {
        //terminator
        if (left == n && right == n) {
            ans.add(current);
            return;
        }
        // process

        // drill down
        if (left < n)
            backtracking(left +1, right, n , current + '(', ans);

        if (right < left)
            backtracking(left, right +1 , n , current + ')', ans);

        // reverse state
    }


}
