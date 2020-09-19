package org.mickey.homework.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mickey
 * @date 9/17/20 23:42
 */
public class _78_SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        dfs(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index) {
        // terminator
        if (index == nums.length){
            ans.add(new ArrayList<>(list));
            return ;
        }
        // process

        // drill down
        dfs(ans, nums, list, index + 1);
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);

        // reverse state
        list.remove(list.size() - 1);
    }
}
