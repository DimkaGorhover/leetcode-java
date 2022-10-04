package org.gd.leetcode.p1146;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link org.gd.leetcode.p1146.SnapshotArray}.
 *
 * @author Horkhover Dmytro
 * @see SnapshotArray
 * @since 2022-10-04
 */
@DisplayName("LeetCode #1146: Snapshot Array")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SnapshotArrayTest {

    @Test
    @SneakyThrows
    void test_001() {
        val snapshotArr = new SnapshotArray(3);
        snapshotArr.set(0, 5);
        assertEquals(0, snapshotArr.snap());
        snapshotArr.set(0, 6);
        assertEquals(5, snapshotArr.get(0, 0));
    }

    @Test
    @SneakyThrows
    void test_002() {
        val snapshotArr = new SnapshotArray(1);
        snapshotArr.set(0, 4);
        snapshotArr.set(0, 16);
        snapshotArr.set(0, 13);
        assertEquals(0, snapshotArr.snap());
        assertEquals(13, snapshotArr.get(0, 0));
        assertEquals(1, snapshotArr.snap());
    }

    @Test
    @SneakyThrows
    void test_003() {
        val snapshotArr = new SnapshotArray(2);
        assertEquals(0, snapshotArr.snap());
        assertEquals(0, snapshotArr.get(1, 0));
        assertEquals(0, snapshotArr.get(0, 0));
        snapshotArr.set(1, 8);
        assertEquals(0, snapshotArr.get(1, 0));
        snapshotArr.set(0, 20);
        assertEquals(0, snapshotArr.get(0, 0));
        snapshotArr.set(0, 7);
    }

    @Test
    @DisplayName("Test for 004")
    @SneakyThrows
    void test_004() {
        val snapshotArr = new SnapshotArray(3);
        snapshotArr.set(1, 18);
        snapshotArr.set(1, 4);

        assertEquals(0, snapshotArr.snap());

        assertEquals(0, snapshotArr.get(0, 0));
        snapshotArr.set(0, 20);

        assertEquals(1, snapshotArr.snap());

        snapshotArr.set(0, 2);
        snapshotArr.set(1, 1);
        assertEquals(4, snapshotArr.get(1, 1));
        assertEquals(4, snapshotArr.get(1, 0));
    }
}
