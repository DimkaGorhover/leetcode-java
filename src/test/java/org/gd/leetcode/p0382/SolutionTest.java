package org.gd.leetcode.p0382;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
@SuppressWarnings("deprecation")
@DisplayName("LeetCode #382: Linked List Random Node")
class SolutionTest {

    private static final BiFunction<Integer, Integer, Integer> INCREMENT =
            (ignore, count) -> 1 + (count == null ? 0 : count);

    @Test
    @DisplayName("GetRandom")
    void test_GetRandom() {

        ListNode node = ListNode.rangeClosed(1, 5);

        HeapSolution heapSolution = new HeapSolution(node.copy());
        Solution solution = new Solution(node.copy());

        final int nodesCount = node.count();
        Map<Integer, Integer> map = new HashMap<>(nodesCount);
        Map<Integer, Integer> mapForHeap = new HashMap<>(nodesCount);

        for (int i = 0; i < 1 << 15; i++) {
            map.compute(solution.getRandom(), INCREMENT);
            mapForHeap.compute(heapSolution.getRandom(), INCREMENT);
        }

        System.out.println("     Solution: " + map);
        System.out.println("Heap Solution: " + mapForHeap);
    }
}