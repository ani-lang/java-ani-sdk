/*
 * Property of Opencore
 */

package com.anilang.sdk;

import org.apache.commons.cli.CommandLine;

/**
 * Resolve the scope to for the option.
 *
 * @since 0.1.0
 */
public final class ResolveScope {

    /**
     * Input.
     */
    private final CommandLine line;

    /**
     * Scope options.
     */
    private final AniOptions options;

    /**
     * Ctor.
     *
     * @param line The command.
     * @param options The scopes.
     */
    public ResolveScope(final CommandLine line, final AniOptions options) {
        this.line = line;
        this.options = options;
    }

    /**
     * True if directory option is selected.
     *
     * @return Whether is a directory or not.
     */
    public boolean isDirectory() {
        return this.line.hasOption(this.options.directory());
    }
}
