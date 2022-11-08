/*
 * Property of Opencore
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
     * @return properties loaded.
     */
    public Properties load() {
        final InputStream is = this.getClass().getResourceAsStream(this.file);
        final Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (final IOException exception) {
            throw new AniSdkException("Internal error: Properties not found.", exception);
        }
        return properties;
    }
}
