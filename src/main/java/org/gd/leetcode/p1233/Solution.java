package org.gd.leetcode.p1233;

import org.gd.leetcode.common.LeetCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@LeetCode(
        name = "Remove Sub-Folders from the Filesystem",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.STRING
        }
)
class Solution {

    public List<String> removeSubfolders(String[] folder) {
        if (folder == null || folder.length == 0)
            return Collections.emptyList();

        if (folder.length == 1)
            return Collections.singletonList(folder[0]);

        Folder root = Folder.root();
        for (String s : folder) {

        }

        throw new UnsupportedOperationException(new String(new char[]{ 175, 92, 95, 40, 12_484, 41, 95, 47, 175 }));
    }

}
