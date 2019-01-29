package org.gd.buildt;

import lombok.*;

import java.util.Collections;
import java.util.Set;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-27
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
public class Dependency implements Transformable {

    private final String         groupId;
    private final String         artifactId;
    private final String         version;
    private final Scope          scope;
    private final Set<Exclusion> exclusions;

    @lombok.Builder(builderClassName = "Builder")
    private Dependency(@NonNull String groupId,
                       @NonNull String artifactId,
                       String version,
                       Scope scope,
                       Set<Exclusion> exclusions) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.scope = scope != null ? scope : Scope.COMPILE;
        this.exclusions = exclusions == null ? Collections.emptySet() : exclusions;
    }

    public static Dependency of(String group, String name, String version) {
        return builder()
                .groupId(group)
                .artifactId(name)
                .version(version)
                .build();
    }

    @Override
    public void toGradle(StringBuilder sb, String prefix) {
        sb.append(prefix).append(scope.gradle).append("(\"").append(groupId).append(":").append(artifactId);
        if (version != null && version.length() > 0) {
            sb.append(':').append(version);
        }
        sb.append("\")");
        if (!exclusions.isEmpty()) {
            final String nextPrefix = prefix + Transformable.PREFIX_OFFSET;
            sb.append(' ').append('{').append('\n');
            for (Exclusion exclusion : exclusions) {
                exclusion.toGradle(sb, nextPrefix);
                sb.append('\n');
            }
            sb.append(prefix).append('}');
        }
    }

    @Override
    public void toMaven(StringBuilder sb) {
        sb.append("<dependency>")
                .append("<groupId>").append(groupId).append("</groupId>")
                .append("<artifactId>").append(artifactId).append("</artifactId>")
                .append("<version>").append(version).append("</version>");
        if (scope.isNeedToPrintForMaven())
            sb.append("<scope>").append(scope.maven).append("</scope>");
        if (!exclusions.isEmpty()) {
            sb.append("<exclusions>");
            for (Exclusion exclusion : exclusions)
                exclusion.toMaven(sb);
            sb.append("</exclusions>");
        }
        sb.append("</dependency>");
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    enum Scope {
        COMPILE("compile", "compile") {
            @Override
            public boolean isNeedToPrintForMaven() { return false; }
        },
        RUNTIME("runtime", "compile"),
        TEST("test", "testCompile"),
        SYSTEM("system", "compile"),
        PROVIDED("provided", "compileOnly");

        final String maven, gradle;

        public boolean isNeedToPrintForMaven() { return false; }

    }
}
