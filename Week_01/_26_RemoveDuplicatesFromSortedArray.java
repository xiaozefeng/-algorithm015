package org.mickey.homework.week1;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author mickey
 * @date 2020/8/28 15:21
 */
public class _26_RemoveDuplicatesFromSortedArray {

    /**
     * using TreeSet
     *
     * @param nums
     * @return
     */
    public int usingTreeSet(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        // traversal the nums and put element into TreeSet
        for (int num : nums) set.add(num);

        // put set element into nums
        int index = 0;
        for (Integer element : set)
            nums[index++] = element;

        return set.size();
    }


    /**
     * fast runner adn fast runner
     *
     * @param nums
     * @return
     */
    public int slowRunnerAndFastRunner(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;  // slow-runner
        int j = 1; // fast-runner
        for (j = 1; j < nums.length; j++)
            if (nums[j] != nums[i])
                nums[i++] = nums[j];

        return i + 1;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;

        return i;
    }

}
