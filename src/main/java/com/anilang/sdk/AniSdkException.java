/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

/**
 * Ani exception.
 *
 * @since 0.1.0
 */
public final class AniSdkException extends RuntimeException {

    /**
     * Ctor.
     *
     * @param message A message.
     * @param exception Chained exception.
     */
    public AniSdkException(final String message, final Exception exception) {
        super(message, exception);
    }
}
