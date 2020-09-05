package org.mickey.homework.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mickey
 * @date 8/31/20 17:33
 */
public class _1_TwoSum {
    /**
     * brute force:  traversal nums twice , when  nums[i] + nums[j] == target , return target
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return new int[]{i, j};

        return null;
    }


    /**
     * using map
     * 1. traversal nums and put element into map
     * 2. traversal nums and look up  target - nums[i], if found it in map, return them
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumUsingMap(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            m.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (m.containsKey(result) && m.get(result) != i)
                return new int[]{i, m.get(result)};
        }
        return null;
    }


    /**
     * best practice
     * just traverse nums once
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumUsingMapJustTraverseNumsOnce(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (m.containsKey(result))
                return new int[]{m.get(result), i};

            m.put(nums[i], i);
        }
        return null;
    }
}

