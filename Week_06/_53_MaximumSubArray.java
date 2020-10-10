package org.mickey.homework.week6;

/**
 * @author mickey
 * @date 2020/10/3 07:27
 */
public class _53_MaximumSubArray {

    public int solution1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int solution2(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(pre, ans);
        }
        return ans;
    }

    // dp
    public int solution3(int [] nums) {
        if (nums == null || nums.length ==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i <nums.length; i++) {
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
