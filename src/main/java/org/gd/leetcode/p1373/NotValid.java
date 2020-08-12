package org.gd.leetcode.p1373;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class NotValid implements Result {

    static final NotValid INSTANCE = new NotValid();

    private NotValid() {}

    @Override
    public boolean valid() { return false; }

    @Override
    public int sum() {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    @Override
    public String toString() { return "Not BST"; }
}
