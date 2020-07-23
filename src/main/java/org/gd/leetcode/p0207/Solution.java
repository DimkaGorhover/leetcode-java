package org.gd.leetcode.p0207;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
@LeetCode(
        name = "Course Schedule",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.FIXME,
        tags = {
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.GRAPH,
                LeetCode.Tags.TOPOLOGICAL_SORT
        }
)
class Solution {

    public boolean canFinish(final int numCourses, int[][] arr) {
        if (numCourses < 1)
            throw new IllegalArgumentException();

        Map<Integer, Prerequisite> prerequisitesMap = new HashMap<>(arr.length);
        for (int[] ints : arr) {
            Prerequisite p = new Prerequisite(ints[0]);
            prerequisitesMap.put(p.id, p);
        }

        for (int[] ints : arr) {
            Prerequisite child = prerequisitesMap.get(ints[1]);
            if (child != null)
                prerequisitesMap.get(ints[0]).connect(child);
        }

        for (int[] ints : arr) {
            Prerequisite child = prerequisitesMap.get(ints[0]);
            if (child.hasCycle())
                return false;
        }

        return true;
    }

    static class Prerequisite implements Comparable<Prerequisite> {

        private final int id;
        private final Set<Prerequisite> next = new HashSet<>();

        Prerequisite(int id) {
            this.id = id;
        }

        void connect(Prerequisite prerequisite) {
            next.add(prerequisite);
        }

        boolean hasCycle() {
            return new CycleFinder(this).hasCycle();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Prerequisite)) return false;
            Prerequisite that = (Prerequisite) o;
            return id == that.id;
        }

        @Override
        public int hashCode() { return id; }

        @Override
        public String toString() {
            return "" + id;
        }

        @Override
        public int compareTo(Prerequisite o) {
            return Integer.compare(id, o.id);
        }
    }

    static class CycleFinder {

        private final Set<Prerequisite> visited = new HashSet<>();
        private final Prerequisite head;

        CycleFinder(Prerequisite head) {
            this.head = head;
        }

        boolean hasCycle() {
            return hasCycle(head);
        }

        private boolean hasCycle(Prerequisite node) {
            if (visited.contains(node))
                return true;

            visited.add(node);
            for (Prerequisite next : node.next) {
                if (hasCycle(next))
                    return true;
            }
            return false;
        }
    }
}
