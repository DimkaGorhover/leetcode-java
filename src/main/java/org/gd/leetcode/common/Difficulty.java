package org.gd.leetcode.common;

import java.lang.annotation.*;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Difficulty {

    Level value();

    enum Level {EASY, MEDIUM, HARD}
}
