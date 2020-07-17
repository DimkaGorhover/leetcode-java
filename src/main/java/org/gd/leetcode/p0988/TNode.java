package org.gd.leetcode.p0988;

class TNode implements Comparable<TNode> {

    private final TNode parent;
    private final char character;
    private final int level;

    TNode(TNode parent, int val) {
        this.parent = parent;
        this.character = (char) (val + 'a');
        this.level = (parent == null ? 0 : parent.level + 1);
    }

    @Override
    public String toString() {
        char[] chars = new char[level + 1];
        TNode node = this;
        int i = 0;
        while (node != null) {
            chars[i++] = node.character;
            node = node.parent;
        }
        return new String(chars);
    }

    @Override
    public int compareTo(TNode o) {

        int compare = Character.compare(character, o.character);
        if (compare != 0)
            return compare;

        if (parent == null)
            return o.parent == null ? 0: -1;

        if (o.parent == null)
            return 1;

        return parent.compareTo(o.parent);
    }
}
