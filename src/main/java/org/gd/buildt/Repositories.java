package org.gd.buildt;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Iterator;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-31
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
public class Repositories implements Transformable, Iterable<Repository> {

    private final List<Repository> repositories;

    private Repositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public static Repositories of(Repository... repositories) {
        return new Repositories(List.of(repositories));
    }

    @Override
    public Iterator<Repository> iterator() { return repositories.iterator(); }

    @Override
    public void toGradle(StringBuilder sb, String prefix) {
        if (repositories.isEmpty()) {
            sb.append("repositories {}");
            return;
        }
        sb.append(prefix).append("repositories {");
        final String next = prefix + PREFIX_OFFSET;
        for (Repository repository : repositories) {
            sb.append('\n');
            repository.toGradle(sb, next);
        }
        sb.append('\n').append(prefix).append('}');
    }

    @Override
    public void toMaven(StringBuilder sb) {
        sb.append("<repositories>");
        for (Repository repository : repositories)
            repository.toMaven(sb);
        sb.append("</repositories>");
    }
}
