package org.mickey.homework.week4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mickey
 * @date 9/15/20 08:49
 */
public class _433_MinimumGeneticMutation {

    int miniStepCount = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<>(), 0, start, end, bank);
        return miniStepCount == Integer.MAX_VALUE ? -1 : miniStepCount;
    }

    private void dfs(Set<String> step, int stepCount, String current, String end, String[] bank) {
        if (current.equals(end)) {
            miniStepCount = Math.min(stepCount, miniStepCount);
        } else {
            for (String str : bank) {
                int diff = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (current.charAt(i) != str.charAt(i))
                        if (++diff > 1) break;
                }
                if (diff == 1 && !step.contains(str)) {
                    step.add(str);
                    dfs(step, stepCount + 1, str, end, bank);
                    step.remove(str);
                }
            }
        }
    }
}
