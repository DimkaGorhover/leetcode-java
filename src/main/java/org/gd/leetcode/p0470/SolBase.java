package org.gd.leetcode.p0470;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class SolBase {

    SolBase() {}

    int rand7() {
        return ThreadLocalRandom.current().nextInt(0, 7);
    }
}
