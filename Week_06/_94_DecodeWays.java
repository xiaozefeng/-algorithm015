package org.mickey.homework.week6;

/**
 * @author mickey
 * @date 2020/10/1 20:30
 */
public class _94_DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        char[] chars = s.toCharArray();
        dp[1] = chars[0] != '0' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            if (chars[i] != '0' ){
                dp[i + 1] = dp[i];
            }
            int num = 10 * (chars[i - 1] - '0') + (chars[i] - '0');
            if (num>= 10 && num<=26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }

}
