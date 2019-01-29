package org.gd.buildt;

import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Root};
 *
 * @author Horkhover Dmytro
 * @since 2019-01-29
 */
class RootTest {

    private static Root root() {
        return Root.builder()
                .group("test_group_id")
                .artifactId("test_artifact_id")
                .version("1.0")
                .properties(Properties.of(
                        Property.of("p1", "v1"),
                        Property.of("p2", "v2"),
                        Property.of("p3", "v3")
                ))
                .dependencies(Dependencies.of(
                        Dependency.of("org.junit", "junit", "4.11"),
                        Dependency.builder()
                                .groupId("org.junit")
                                .artifactId("junit")
                                .version("4.12")
                                .exclusions(Set.of(
                                        Exclusion.builder()
                                                .groupId("hamcrest")
                                                .artifactId("hamcrest")
                                                .build(),
                                        Exclusion.builder()
                                                .groupId("hamcrest_1")
                                                .artifactId("hamcrest_1")
                                                .build()
                                ))
                                .build(),
                        Dependency.of("org.junit", "junit", "4.11")
                ))
                .build();
    }

    @Test
    @DisplayName("ToGradle")
    void test_ToGradle() {

        System.out.println(root().toGradle());
    }

    @Test
    @DisplayName("ToMaven")
    void test_ToMaven() {

        System.out.println(root().toMaven());
    }
}