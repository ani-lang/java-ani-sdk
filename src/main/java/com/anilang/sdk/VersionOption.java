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
     * Print the lines to the output.
     */
    private final OutputLine out;

    /**
     * Ctor.
     */
    public VersionOption() {
        this.properties = new MavenProperties();
        this.out = new OutputLine();
    }

    @Override
    public void run() {
        this.out.print(String.format("Ani SDK Version (Java) %s", this.properties.aniSdkVersion()));
        this.out.print(String.format("Anilang Version %s", this.properties.aniCoreVersion()));
    }
}
