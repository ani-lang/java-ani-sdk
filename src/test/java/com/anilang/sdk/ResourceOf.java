/*
 * Property of Opencore
 */

package com.anilang.sdk;

import java.util.Objects;

/**
 * Read a resource file.
 *
 * @since 0.1.0
 */
public final class ResourceOf {

    /**
     * File path.
     */
    private final String file;

    /**
     * Ctor.
     *
     * @param file Path to the file.
     */
    public ResourceOf(final String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return Objects.requireNonNull(this.getClass().getResource(this.file)).getPath();
    }
}
