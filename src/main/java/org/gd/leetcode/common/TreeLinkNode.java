package org.gd.leetcode.common;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-03
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
public class TreeLinkNode {

    public final int val;

    public TreeLinkNode left, right, next;

    TreeLinkNode(int x) { val = x; }
}
