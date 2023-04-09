/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

import java.io.IOException;
import java.util.function.Function;

/**
 * Run an option under a scope.
 *
 * @since 0.1.0
 */
public final class ScopedOption implements RunnableOption {

    /**
     * The scope.
     */
    private final ResolveScope scope;

    /**
     * The param.
     */
    private final String value;

    /**
     * The option to run.
     */
    private final Function<String, RunnableOption> runnable;

    /**
     * Ctor.
     *
     * @param scope Scope.
     * @param value Param.
     * @param runnable Option.
     */
    public ScopedOption(
        final ResolveScope scope,
        final String value,
        final Function<String, RunnableOption> runnable
    ) {
        this.scope = scope;
        this.value = value;
        this.runnable = runnable;
    }

    @Override
    public void run() throws IOException {
        if (this.scope.isDirectory()) {
            new DirectoryOption(
                this.value,
                this.runnable
            ).run();
        } else {
            this.runnable.apply(this.value).run();
        }
    }
}
