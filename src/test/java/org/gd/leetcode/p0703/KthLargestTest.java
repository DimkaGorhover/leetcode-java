package org.gd.leetcode.p0703;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @see KthLargest
 */
@DisplayName("LeetCode #703: Kth Largest Element in a Stream")
class KthLargestTest {

    @Test
    void name() {
        var kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        assertThat(kthLargest.add(3)).isEqualTo(4);
        assertThat(kthLargest.add(5)).isEqualTo(5);
        assertThat(kthLargest.add(10)).isEqualTo(5);
        assertThat(kthLargest.add(9)).isEqualTo(8);
        assertThat(kthLargest.add(4)).isEqualTo(8);
    }
}