package org.gd.buildt;

import lombok.*;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-29
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
public class Repository implements Transformable {

    private final String id, url;
    private final Policy releases, snapshots;

    @lombok.Builder(builderClassName = "Builder")
    private Repository(String id, @NonNull String url, Policy releases, Policy snapshots) {
        this.id = id;
        this.url = url;
        this.releases = releases;
        this.snapshots = snapshots;
    }

    public static Repository ofUrl(@NonNull String url) {
        return builder().url(url).build();
    }

    @Override
    public void toGradle(StringBuilder sb, String prefix) {
        sb.append(prefix).append("maven {").append('\n');
        if (id != null && id.length() > 0)
            sb.append(prefix).append(PREFIX_OFFSET).append("name = \"").append(id).append('"').append('\n');
        sb.append(prefix).append(PREFIX_OFFSET).append("url = \"").append(url).append('"').append('\n');
        sb.append(prefix).append('}');
    }

    @Override
    public void toMaven(StringBuilder sb) {
        sb.append("<repository>");
        sb.append("<id>").append(id).append("</id>");
        sb.append("<url>").append(url).append("</url>");
        if (releases != null) {
            sb.append("<releases>");
            releases.toMaven(sb);
            sb.append("</releases>");
        }
        if (snapshots != null) {
            sb.append("<snapshots>");
            snapshots.toMaven(sb);
            sb.append("</snapshots>");
        }
        sb.append("</repository>");
    }

    public interface Policy extends Transformable {

        static Policy disabled() { return DisabledPolicy.INSTANCE; }

        static Policy enabled(UpdatePolicy updatePolicy) { return new EnabledPolicy(updatePolicy); }

        @Override
        default void toGradle(StringBuilder sb, String prefix) {}


        @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
        class UpdatePolicy {

            final String name;

            public static UpdatePolicy always() { return new UpdatePolicy("always"); }

            public static UpdatePolicy daily() { return new UpdatePolicy("daily"); }

            public static UpdatePolicy interval(int minutes) { return new UpdatePolicy("interval:" + minutes); }

            public static UpdatePolicy never() { return new UpdatePolicy("never"); }
        }
    }

    static class DisabledPolicy implements Policy {

        static final DisabledPolicy INSTANCE = new DisabledPolicy();

        private DisabledPolicy() {}

        @Override
        public void toMaven(StringBuilder sb) { sb.append("<enabled>false</enabled>"); }
    }

    static class EnabledPolicy implements Policy {

        private final UpdatePolicy updatePolicy;

        EnabledPolicy(UpdatePolicy updatePolicy) {
            this.updatePolicy = updatePolicy;
        }

        @Override
        public void toMaven(StringBuilder sb) {
            sb.append("<enabled>true</enabled>");
            if (updatePolicy != null)
                sb.append("<updatePolicy>").append(updatePolicy.name).append("</updatePolicy>");
        }
    }
}
