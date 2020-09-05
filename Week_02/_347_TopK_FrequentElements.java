package org.mickey.homework.week2;

import java.util.*;

/**
 * @author mickey
 * @date 9/5/20 22:34
 */
public class _347_TopK_FrequentElements {

    private class Element {
        Integer val;
        Integer frequency;

        public Element(Integer val, Integer frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }


    // 使用优先队列
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) return new int[0];
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(o -> -o.frequency));
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num,0) +1);
        }
        m.forEach((key, value) -> pq.add(new Element(key, value)));
        int[] r = new int[k];
        for (int i = 0; i < r.length; i++) {
            r[i] = pq.remove().val;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] result = new _347_TopK_FrequentElements().topKFrequentUsingBucket(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(result));
    }

    // 1. 用map统计词频
    // 2. 用bucket将词频和对应的元素反转
    public int[] topKFrequentUsingBucket(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer frequency = entry.getValue();
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(entry.getKey());
        }
        int[] res = new int[k];
        int j = 0;
        // 从尾到头遍历是以词频倒序
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (Integer e : bucket[i]) {
                    if (j == k) return res;
                    res[j++] = e;

                }
            }
        }

        return res;

    }


}
