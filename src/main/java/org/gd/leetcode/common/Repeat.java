package org.gd.leetcode.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * this annotation means that I have found solution (maybe not solved by myself) and try to solve it again in nearest
 * future
 *
 * @since 2019-09-23
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Repeat {

    String value() default "";
}
