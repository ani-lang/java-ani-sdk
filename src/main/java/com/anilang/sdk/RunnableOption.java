/*
 * Property of Opencore
 */

package com.anilang.sdk;

import java.io.IOException;

/**
 * Represents all options that can be run.
 *
 * @since 0.1.0
 */
public interface RunnableOption {

    /**
     * Run the option.
     *
     * @throws IOException Something goes wrong.
     */
    void run() throws IOException;
}
