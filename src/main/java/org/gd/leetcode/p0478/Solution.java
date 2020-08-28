package org.gd.leetcode.p0478;

import org.gd.leetcode.common.LeetCode;

import java.util.Random;

/**
 * https://leetcode.com/problems/generate-random-point-in-a-circle/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-28
 */
@LeetCode(
        name = "Generate Random Point in a Circle",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.RANDOM,
                LeetCode.Tags.REJECTION_SAMPLING
        }
)
class Solution {

    private final Random random = new Random();
    private final double x_center, y_center, radius, radiusSqr;

    public Solution(double radius, double x_center, double y_center) {

        if (radius <= 0)
            throw new IllegalArgumentException("radius");

        this.radius = radius;
        this.radiusSqr = radius * radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    private static double sqr(double v) {
        return v * v;
    }

    private double randomX() {
        double min = x_center - radius;
        double max = x_center + radius;
        return min + ((max - min) * random.nextDouble());
    }

    private double randomY() {
        double min = y_center - radius;
        double max = y_center + radius;
        return min + ((max - min) * random.nextDouble());
    }

    public double[] randPoint() {
        double x, y, dSqr;
        do {
            x = randomX();
            y = randomY();
            dSqr = sqr(Math.abs(x - x_center)) + sqr(Math.abs(y - y_center));
        } while (Double.compare(dSqr, radiusSqr) > 0);
        return new double[]{x, y};
    }
}

/*
===============================================================================
double radius, x_center, y_center;

public Solution(double radius, double x_center, double y_center) {
    this.radius = radius;
    this.x_center = x_center;
    this.y_center = y_center;
}

public double[] randPoint() {
    double len = Math.sqrt(Math.random()) * radius;
    double deg = Math.random() * 2 * Math.PI;
    double x = x_center + len * Math.cos(deg);
    double y = y_center + len * Math.sin(deg);
    return new double[]{x, y};
}
===============================================================================
 */

/*
===============================================================================
class Solution {

double r, x, y;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * r;
        double deg = Math.random() * 2 * Math.PI;
        return new double[]{x + len * Math.cos(deg), y + len * Math.sin(deg)};
    }
}
===============================================================================
 */