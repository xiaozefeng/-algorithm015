package org.mickey.homework.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mickey
 * @date 9/18/20 08:52
 */
public class _46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        for (int num : nums) out.add(num);

        int n = nums.length;
        backtrack(0 , n , out, ans);
        return ans;
    }

    private void backtrack(int first, int n, List<Integer> out, List<List<Integer>> ans) {
        // terminator
        if (first == n) {
            ans.add(new ArrayList<>(out));
        }
        // process
        for (int i = first; i < n ; i ++) {
            Collections.swap(out, first, i);

            // drill down
            backtrack(first + 1, n, out, ans);

            //reverse state
            Collections.swap(out, first, i);
        }
    }
}
