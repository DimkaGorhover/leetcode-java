package org.gd.leetcode.p0116;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0117.Solution
 * @since 2019-01-03
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Populating Next Right Pointers in Each Node",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        })
interface Solution {

    void connect(TreeLinkNode root);
}
