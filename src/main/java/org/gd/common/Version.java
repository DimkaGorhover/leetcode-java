package org.gd.common;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.Optional;

/**
 * @author Gorkhover D.
 * @since 2018-11-01
 */
@EqualsAndHashCode(doNotUseGetters = true)
public class Version implements Comparable<Version> {

    private final int major, minor, build;

    @lombok.Builder(builderClassName = "Builder")
    private Version(int major, int minor, int build) {
        this.major = major;
        this.minor = minor;
        this.build = build;
    }

    @NonNull
    public static Optional<Version> of(String text) {
        if (text == null || text.isEmpty())
            return Optional.empty();

        throw new UnsupportedOperationException();
    }

    @NonNull
    public Version nextBuild() {
        return new Version(major, minor, Math.addExact(build, 1));
    }

    @NonNull
    public Version nextMinor() {
        return new Version(major, Math.addExact(minor, 1), 0);
    }

    @NonNull
    public Version nextMajor() {
        return new Version(Math.addExact(major, 1), 0, 0);
    }

    @Override
    public String toString() { return major + "." + minor + (build > 0 ? "." + build : ""); }

    @Override
    public int compareTo(Version o) {
        int c = 0;
        if (o == null) return c;
        if ((c = Integer.compare(o.major, major)) != 0) return c;
        if ((c = Integer.compare(o.minor, minor)) != 0) return c;
        if ((c = Integer.compare(o.build, build)) != 0) return c;
        return 0;
    }
}
