/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Load properties file.
 *
 * @since 0.1.0
 */
public final class LoadMavenProperties {

    /**
     * File name.
     */
    private final String file;

    /**
     * Ctor.
     *
     * @param file File name.
     */
    public LoadMavenProperties(final String file) {
        this.file = file;
    }

    /**
     * Load properties to use.
     *
     * @return Properties loaded.
     */
    public Properties load() {
        final InputStream input = this.getClass().getResourceAsStream(this.file);
        final Properties properties = new Properties();
        try {
            properties.load(input);
        } catch (final IOException exception) {
            throw new AniSdkException("Internal error: Properties not found.", exception);
        }
        return properties;
    }
}
