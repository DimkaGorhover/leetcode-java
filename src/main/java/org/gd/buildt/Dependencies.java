package org.gd.buildt;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Iterator;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-29
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
public class Dependencies implements Iterable<Dependency>, Transformable {

    private final List<Dependency> dependencies;

    private Dependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public static Dependencies of(Dependency... dependencies) {
        return new Dependencies(List.of(dependencies));
    }

    @Override
    public Iterator<Dependency> iterator() { return dependencies.iterator(); }

    @Override
    public void toGradle(StringBuilder sb, String prefix) {
        if (dependencies.isEmpty()) {
            sb.append("dependencies {}");
            return;
        }
        sb.append("dependencies {\n");
        final String nextPrefix = prefix + PREFIX_OFFSET;
        final Iterator<Dependency> iterator = dependencies.iterator();
        iterator.next().toGradle(sb, nextPrefix);
        while (iterator.hasNext()) {
            sb.append('\n');
            iterator.next().toGradle(sb, nextPrefix);
        }
        sb.append('\n').append(prefix).append('}');
    }

    @Override
    public void toMaven(StringBuilder sb) {
        sb.append("<dependencies>");
        dependencies.forEach(dependency -> dependency.toMaven(sb));
        sb.append("</dependencies>");
    }
}
