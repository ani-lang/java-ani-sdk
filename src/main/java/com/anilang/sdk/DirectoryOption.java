/*
 * Property of Opencore
 */

package com.anilang.sdk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Run an option under a directory.
 *
 * @since 0.1.0
 */
public final class DirectoryOption implements RunnableOption {

    /**
     * The option to run.
     */
    private final Function<String, RunnableOption> runnable;

    /**
     * Directory path.
     */
    private final Path directory;

    /**
     * Ctor.
     *
     * @param raw Raw path.
     * @param runnable Runnable option.
     */
    public DirectoryOption(final String raw, final Function<String, RunnableOption> runnable) {
        this.directory = Paths.get(raw);
        this.runnable = runnable;
    }

    @SuppressWarnings("PMD.SystemPrintln")
    @Override
    public void run() throws IOException {
        System.out.printf("Running under directory: %s%n", this.directory.toString());
        try (Stream<Path> paths = Files.list(this.directory)) {
            paths.forEach(
                path -> {
                    try {
                        this.runnable.apply(path.toString()).run();
                    } catch (final IOException exception) {
                        throw new AniSdkException(
                            "Error while running option under directory",
                            exception
                        );
                    }
                }
            );
        }
    }
}
