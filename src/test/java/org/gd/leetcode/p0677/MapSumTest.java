package org.gd.leetcode.p0677;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link MapSum}
 *
 * @author Horkhover Dmytro
 * @since 2020-10-30
 */
@DisplayName("LeetCode #677: Map Sum Pairs")
class MapSumTest {

    @Test
    @DisplayName("test")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_test() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertEquals(3, mapSum.sum("ap"));
        mapSum.insert("app", 2);
        assertEquals(5, mapSum.sum("app"));
        mapSum.insert("apple", 2);
        mapSum.insert("app", 4);
    }
}
