package org.gd.hackerrank.common;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.gd.leetcode.common.LeetCode;

import java.lang.annotation.*;

/**
 * https://github.com/RodneyShag/HackerRank_solutions
 *
 * https://github.com/RodneyShag/HackerRank_solutions/tree/34a59eda36b06ceb3a459fc34d5c7c7e7b06f0c5
 *
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface HackerRank {

    Level difficulty();

    LeetCode.Tags[] tags() default {};

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    enum Level {EASY, MEDIUM, HARD, ADVANCED}
}
