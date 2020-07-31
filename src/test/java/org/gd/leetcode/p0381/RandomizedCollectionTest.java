package org.gd.leetcode.p0381;

import org.junit.jupiter.api.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link RandomizedCollection}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
@DisplayName("LeetCode #381: Insert Delete GetRandom O(1) - Duplicates allowed")
class RandomizedCollectionTest {

    @Test
    @DisplayName("001")
    void test_001() {
        var collection = new RandomizedCollection();

        assertTrue(collection.insert(0));
        assertTrue(collection.insert(1));
        assertFalse(collection.insert(1));
        assertFalse(collection.insert(0));
        assertFalse(collection.insert(1));

        var expected = Set.of(0, 1);
        for (int i = 0; i < 1000; i++)
            assertTrue(expected.contains(collection.getRandom()));

        assertTrue(collection.remove(0));

        expected = Set.of(0, 1);
        for (int i = 0; i < 1000; i++)
            assertTrue(expected.contains(collection.getRandom()));

        assertTrue(collection.remove(0));

        for (int i = 0; i < 1000; i++)
            assertEquals(1, collection.getRandom());
    }
}