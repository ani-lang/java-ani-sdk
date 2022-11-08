/*
 * Property of Opencore
 */

package com.anilang.sdk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests.
 *
 * @since 0.1.0
 */
class MavenPropertiesTest {

    /**
     * Properties.
     */
    private final MavenProperties properties = new MavenProperties();

    // @checkstyle JavadocMethodCheck (500 lines)

    @Test
    void nonNullAniCoreVersion() {
        Assertions.assertNotNull(
            properties.aniCoreVersion()
        );
    }

    @Test
    void nonNullAniSdkVersion() {
        Assertions.assertNotNull(
            properties.aniSdkVersion()
        );
    }
}
