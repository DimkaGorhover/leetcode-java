package org.gd.leetcode.p0460;

import org.junit.jupiter.api.*;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link LFUCache};
 *
 * @author Gorkhover D.
 * @since 2018-10-18
 */
class LFUCacheTest {

    @Test
    @DisplayName("prio_queue")
    void test_prio_queue() {
        final PriorityQueue<Object> queue = new PriorityQueue<>();
        var u1 = new User(1);
        u1.time = 1;
        var u2 = new User(1);
        u2.time = 2;

        queue.add(u1);
        queue.add(u2);

        System.out.println(queue);

        u1.time = 3;

        System.out.println(queue);
    }

    static class User implements Comparable<User> {

        final int id;

        long time;

        User(int id) { this.id = id; }

        @Override
        public int compareTo(User o) {
            return Long.compare(o.time, time);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", time=" + time +
                    '}';
        }
    }

    @Test
    @DisplayName("Get")
    void test_Get() {

        var cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);    // evicts key 2
        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));
        cache.put(4, 4);    // evicts key 1.
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}