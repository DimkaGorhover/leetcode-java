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
public class Properties implements Transformable, Iterable<Property> {

    private final List<Property> properties;

    private Properties(List<Property> properties) {
        this.properties = properties;
    }

    public static Properties of(Property... properties) {
        return new Properties(List.of(properties));
    }

    @Override
    public Iterator<Property> iterator() { return properties.iterator(); }

    @Override
    public void toGradle(StringBuilder sb, String prefix) {
        if (properties.isEmpty())
            sb.append("ext {}");

        sb.append("ext {").append('\n');
        final String nextPrefix = prefix + PREFIX_OFFSET;
        final Iterator<Property> iterator = iterator();
        iterator.next().toGradle(sb, nextPrefix);
        while (iterator.hasNext()) {
            sb.append(',').append('\n');
            iterator.next().toGradle(sb, nextPrefix);
        }
        sb.append('\n').append('}');
    }

    @Override
    public void toMaven(StringBuilder sb) {
        sb.append("<properties>");
        properties.forEach(property -> property.toMaven(sb));
        sb.append("</properties>");
    }
}
