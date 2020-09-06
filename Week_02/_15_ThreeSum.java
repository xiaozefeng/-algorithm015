package org.mickey.homework.week2;

import java.util.*;

/**
 * @author mickey
 * @date 9/6/20 16:49
 */
public class _15_ThreeSum {

    public List<List<Integer>> bruteForce(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] == -nums[k]) {
                        s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }

        }
        return new ArrayList<>(s);
    }


    public List<List<Integer>> hashSolution(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> m = new HashMap<>(nums.length - 1);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = m.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    s.add(list);
                } else {
                    m.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(s);
    }


    // 双指针夹逼法
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        if (nums == null || nums.length < 3) return r;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) { // 留2个位置给两个指针
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    r.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return r;
    }
}
