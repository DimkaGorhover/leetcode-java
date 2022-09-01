package org.gd.leetcode.p0382;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see SimpleSolution
 * @see HeapSolution
 * @since 2020-07-22
 */
@SuppressWarnings("deprecation")
@DisplayName("LeetCode #382: Linked List Random Node")
@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static final BiFunction<Integer, Integer, Integer> INCREMENT =
            (ignore, count) -> 1 + (count == null ? 0 : count);

    private static int diff(Map<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return max - min;
    }

    @Test
    @DisplayName("GetRandom")
    void test_GetRandom() {

        int nodesCount = ThreadLocalRandom.current().nextInt(5, 10);

        ListNode node = ListNode.rangeClosed(1, nodesCount);

        Solution heapSolution = new HeapSolution(node);
        Solution solution = new SimpleSolution(node);

        Map<Integer, Integer> map = new HashMap<>(nodesCount);
        Map<Integer, Integer> mapForHeap = new HashMap<>(nodesCount);

        for (int i = 0; i < 1 << 16; i++) {
            map.compute(solution.getRandom(), INCREMENT);
            mapForHeap.compute(heapSolution.getRandom(), INCREMENT);
        }

        System.out.printf("     Solution: %s; diff: %d%nHeap Solution: %s; diff: %d%n",
                map, diff(map),
                mapForHeap, diff(mapForHeap));
    }
}
