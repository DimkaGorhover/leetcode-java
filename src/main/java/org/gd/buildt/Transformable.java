package org.gd.buildt;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-27
 */
public interface Transformable {

    String PREFIX_OFFSET = "    ";

    default void toGradle(StringBuilder sb) { toGradle(sb, ""); }

    void toGradle(StringBuilder sb, String prefix);

    default String toGradle() {
        final StringBuilder sb = new StringBuilder();
        toGradle(sb);
        return sb.toString();
    }

    void toMaven(StringBuilder sb);

    default String toMaven() {
        final StringBuilder sb = new StringBuilder();
        toMaven(sb);
        return sb.toString();
    }
}
