package org.gd.hackerrank.common;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.*;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface HackerRank {

    Level difficulty();

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    enum Level {EASY, MEDIUM, HARD}
}
