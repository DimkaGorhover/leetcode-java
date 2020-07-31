package org.gd.leetcode.p0381;

import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link RandomizedCollection}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@DisplayName("Test for org.gd.leetcode.p0381.RandomizedCollection")
class RandomizedCollectionTest {

    @Test
    @DisplayName("001")
    void test_001() {
        var collection = new RandomizedCollection();

        assertTrue(collection.insert(0));
        assertFalse(collection.insert(0));
        assertTrue(collection.insert(1));
        assertFalse(collection.insert(1));
        assertFalse(collection.insert(1));

        assertTrue(Set.of(0, 1).contains(collection.getRandom()));
    }
}