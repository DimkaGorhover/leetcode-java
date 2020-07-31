package org.gd.leetcode.p1006;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@SuppressWarnings("EnhancedSwitchMigration")
class MathSolution implements Solution {

    @Override
    public int clumsy(int N) {

        switch (N) {
            case 1:
            case 2: return N;
            case 3: return 6;
            case 4: return 7;
        }

        switch (N % 4) {
            case 1:
            case 2: return N + 2;
            case 3: return N - 1;
        }

        return N + 1;
    }
}
