/*
 * Property of Opencore
 */

package com.anilang.sdk;

/**
 * Display the versions.
 *
 * @since 0.1.0
 */
public final class VersionOption implements RunnableOption {

    /**
     * Properties.
     */
    private final MavenProperties properties;

    /**
     * Ctor.
     */
    public VersionOption() {
        this.properties = new MavenProperties();
    }

    @Override
    public void run() {
        System.out.printf("Ani SDK Version (Java) %s%n", this.properties.aniSdkVersion());
        System.out.printf("Anilang Version %s%n", this.properties.aniCoreVersion());
    }
}
