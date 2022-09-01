package org.gd.leetcode.p0381;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link RandomizedCollection}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0380.RandomizedSetTest
 * @since 2020-07-31
 */
@SuppressWarnings("JavadocReference")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
@DisplayName("LeetCode #381: Insert Delete GetRandom O(1) - Duplicates allowed")
class RandomizedCollectionTest {

    @Test
    @DisplayName("002")
    void test_002() {
        var set = new RandomizedCollection();

        assertTrue(set.insert(0));
        assertTrue(set.insert(1));
        assertTrue(set.remove(0));
        assertTrue(set.insert(2));
        assertTrue(set.remove(1));

        assertEquals(2, set.getRandom());
    }

    @Test
    @DisplayName("001")
    void test_001() {
        var collection = new RandomizedCollection();

        assertTrue(collection.insert(0));
        assertTrue(collection.insert(1));
        assertFalse(collection.insert(1));
        assertFalse(collection.insert(0));
        assertFalse(collection.insert(1));

        var expected = org.gd.leetcode.common.CollectionUtils.setOf(0, 1);
        for (int i = 0; i < 1000; i++)
            assertTrue(expected.contains(collection.getRandom()));

        assertTrue(collection.remove(0));

        expected = org.gd.leetcode.common.CollectionUtils.setOf(0, 1);
        for (int i = 0; i < 1000; i++)
            assertTrue(expected.contains(collection.getRandom()));

        assertTrue(collection.remove(0));

        for (int i = 0; i < 1000; i++)
            assertEquals(1, collection.getRandom());
    }
}