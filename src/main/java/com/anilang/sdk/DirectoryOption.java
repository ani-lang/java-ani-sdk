/*
 * Property of ani-lang project.
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
     * Print the lines to the output.
     */
    private final OutputLine out;

    /**
     * Ctor.
     *
     * @param raw Raw path.
     * @param runnable Runnable option.
     */
    public DirectoryOption(final String raw, final Function<String, RunnableOption> runnable) {
        this.directory = Paths.get(raw);
        this.runnable = runnable;
        this.out = new OutputLine();
    }

    @Override
    public void run() throws IOException {
        this.out.print(String.format("Running under directory: %s", this.directory.toString()));
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
