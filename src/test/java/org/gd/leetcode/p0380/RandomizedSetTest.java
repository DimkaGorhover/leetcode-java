package org.gd.leetcode.p0380;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link RandomizedSet}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@DisplayName("LeeCode #380: Insert Delete GetRandom O(1)")
class RandomizedSetTest {

    @Test
    @DisplayName("001")
    void test_001() {

        var set = new RandomizedSet();

        assertTrue(set.insert(0));
        assertTrue(set.insert(1));
        assertTrue(set.remove(0));
        assertTrue(set.insert(2));
        assertTrue(set.remove(1));

        assertEquals(2, set.getRandom());
    }
}