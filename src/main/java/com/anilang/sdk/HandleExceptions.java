/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

import java.io.IOException;

/**
 * Handle exceptions for runnable.
 *
 * @since 0.1.0
 */
public final class HandleExceptions implements Runnable {

    /**
     * Runnable.
     */
    private final RunnableOption runnable;

    /**
     * Ctor.
     *
     * @param runnable The unsafe runnable.
     */
    public HandleExceptions(final RunnableOption runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        try {
            this.runnable.run();
        } catch (final IOException exception) {
            throw new AniSdkException("Unexpected error", exception);
        }
    }
}
