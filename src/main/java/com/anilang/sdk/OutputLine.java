/*
 * Property of Opencore
 */

package com.anilang.sdk;

import java.io.PrintStream;

/**
 * A line to be printed to the output.
 *
 * @since 0.1.0
 */
public final class OutputLine {

    /**
     * Output source.
     */
    private final PrintStream out;

    /**
     * Ctor.
     */
    public OutputLine() {
        this.out = System.out;
    }

    /**
     * Print the message to the output source.
     *
     * @param message The message to print.
     */
    public void print(final String message) {
        this.out.println(message);
    }
}
