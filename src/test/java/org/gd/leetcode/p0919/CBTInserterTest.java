package org.gd.leetcode.p0919;

import lombok.SneakyThrows;
import lombok.val;
import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link org.gd.leetcode.p0919.CBTInserter}.
 *
 * @author Horkhover Dmytro
 * @see CBTInserter
 * @since 2022-09-27
 */
@DisplayName("LeetCode #919: Complete Binary Tree Inserter")
class CBTInserterTest {

    @Test
    @SneakyThrows
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void test_001() {
        val cBTInserter = new CBTInserter(TreeNode.of(1, 2));
        assertThat(cBTInserter.insert(3)).isEqualTo(1);
        assertThat(cBTInserter.insert(4)).isEqualTo(2);
        assertThat(cBTInserter.get_root()).isEqualTo(TreeNode.of(1, 2, 3, 4));
    }

    @Test
    @SneakyThrows
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void test_002() {
        val cBTInserter = new CBTInserter(TreeNode.of(1, 2, 3, 4, 5, 6));
        assertThat(cBTInserter.insert(7)).isEqualTo(3);
        assertThat(cBTInserter.insert(8)).isEqualTo(4);
        assertThat(cBTInserter.get_root()).isEqualTo(TreeNode.of(1, 2, 3, 4, 5, 6, 7, 8));
    }
}
