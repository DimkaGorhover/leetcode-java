package org.gd.buildt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-28
 */
@Getter
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
public class Exclusion implements Transformable {

    private final String groupId;
    private final String artifactId;
    private final String version;

    @lombok.Builder(builderClassName = "Builder")
    private Exclusion(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public static Exclusion of(String group, String artifact) {
        return builder()
                .groupId(group)
                .artifactId(artifact)
                .build();
    }

    @Override
    public void toGradle(StringBuilder sb, String prefix) {
        boolean start = false;
        sb.append(prefix).append("exclude ");
        if (groupId != null && groupId.length() > 0) {
            start = true;
            sb.append("group: ").append(groupId);
        }
        if (artifactId != null && artifactId.length() > 0) {
            if (start) sb.append(", ");
            else start = true;
            sb.append("module: \"").append(artifactId).append('"');
        }
        if (version != null && version.length() > 0) {
            if (start) sb.append(", ");
            sb.append("version: \"").append(version).append('"');
        }
    }

    @Override
    public void toMaven(StringBuilder sb) {
        requireNonNull(groupId, "\"groupId\" cannot be null");
        requireNonNull(artifactId, "\"artifactId\" cannot be null");
        sb.append("<exclusion>")
                .append("<groupId>").append(groupId).append("</groupId>")
                .append("<artifactId>").append(artifactId).append("</artifactId>");
        if (version != null && version.length() != 0)
            sb.append("<version>").append(version).append("</version>");
        sb.append("</exclusion>");
    }
}
