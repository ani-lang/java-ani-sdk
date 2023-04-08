/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

import java.util.Properties;

/**
 * Maven properties from the pom.xml.
 *
 * @since 0.1.0
 */
public final class MavenProperties {

    /**
     * Maven properties.
     */
    private final Properties properties;

    /**
     * Ctor.
     */
    public MavenProperties() {
        this.properties = new LoadMavenProperties("/maven.properties").load();
    }

    /**
     * Version of ani lang core.
     *
     * @return String version.
     */
    public String aniCoreVersion() {
        return this.properties.getProperty("ani.core.version");
    }

    /**
     * Version of ani sdk.
     *
     * @return String version.
     */
    public String aniSdkVersion() {
        return this.properties.getProperty("ani.sdk.version");
    }
}
