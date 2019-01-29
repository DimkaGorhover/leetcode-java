package org.gd.buildt;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-29
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
public class Property implements Transformable {

    private final String name, value;

    private Property(@NonNull String name,
                     @NonNull String value) {
        this.name = name;
        this.value = value;
    }

    public static Property of(String name, String value) {
        return new Property(name, value);
    }

    @Override
    public void toGradle(StringBuilder sb, String prefix) {
        sb.append(prefix)
                .append('"').append(name).append("\" = \"")
                .append(value).append('"');
    }

    @Override
    public void toMaven(StringBuilder sb) {
        sb.append('<').append(name).append('>');
        sb.append(value);
        sb.append('<').append('/').append(name).append('>');
    }
}
