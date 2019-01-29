package org.gd.buildt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-29
 */
@Getter
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
public class Root implements Transformable {

    private final String       pomVersion;
    private final String       version;
    private final String       group;
    private final String       artifactId;
    private final String       name;
    private final String       packaging;
    private final Properties   properties;
    private final Dependencies dependencies;

    @lombok.Builder(builderClassName = "Builder")
    private Root(@NonNull String pomVersion,
                 @NonNull String version,
                 @NonNull String group,
                 @NonNull String artifactId,
                 String name,
                 String packaging,
                 @NonNull Properties properties,
                 @NonNull Dependencies dependencies) {
        this.pomVersion = pomVersion;
        this.version = version;
        this.group = group;
        this.artifactId = artifactId;
        this.name = name;
        this.packaging = packaging;
        this.properties = properties;
        this.dependencies = dependencies;
    }


    @Override
    public void toGradle(StringBuilder sb, String prefix) {
        properties.toGradle(sb);
        sb.append('\n');
        dependencies.toGradle(sb);
    }

    @Override
    public void toMaven(StringBuilder sb) {
        sb.append("<project " +
                "xmlns=\"http://maven.apache.org/POM/4.0.0\" " +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xsi:schemaLocation=\"" +
                "http://maven.apache.org/POM/4.0.0 " +
                "http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
        sb.append("<modelVersion>").append(pomVersion).append("</modelVersion>");
        sb.append("<groupId>").append(group).append("</groupId>");
        sb.append("<artifactId>").append(artifactId).append("</artifactId>");
        sb.append("<version>").append(version).append("</version>");
        if (name != null)
            sb.append("<name>").append(name).append("</name>");
        if (packaging != null)
            sb.append("<packaging>").append(packaging).append("</packaging>");

        properties.toMaven(sb);
        dependencies.toMaven(sb);
        sb.append("</project>");
    }

    public static class Builder {

        Builder() {
            pomVersion = "4.0.0";
        }
    }
}
