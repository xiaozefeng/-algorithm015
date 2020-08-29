package org.mickey.homework.week1;

/**
 * @author mickey
 * @date 8/29/20 01:31
 */
public class _283_MoveZeros {

    public void moveZeroes(int[] nums) {
        // define head pointer: j = 0
        // when find out no zero element , swap j and current element
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j]  = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }

                j++;
            }
        }

    }
}
