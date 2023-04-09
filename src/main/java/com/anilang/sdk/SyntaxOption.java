/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

import com.anilang.parser.AniFile;
import com.anilang.parser.ParseError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

/**
 * Syntax validation option.
 *
 * @since 0.1.0
 */
public final class SyntaxOption implements RunnableOption {

    /**
     * File path to validate syntax.
     */
    private final Path path;

    /**
     * Print the lines to the output.
     */
    private final OutputLine out;

    /**
     * Error consumer.
     */
    private final Consumer<List<ParseError>> onErrors;

    /**
     * Ctor.
     *
     * @param raw Raw path to the file.
     */
    public SyntaxOption(final String raw) {
        this(
            raw,
            errors -> {
                for (final ParseError error : errors) {
                    new OutputLine().print(error.getError());
                }
            }
        );
    }

    public SyntaxOption(
        final String raw,
        final Consumer<List<ParseError>> onErrors
    ) {
        this.path = Paths.get(raw);
        this.out = new OutputLine();
        this.onErrors = onErrors;
    }

    @Override
    public void run() throws IOException {
        this.out.print(String.format("Syntax analysis over file: %s", this.path.getFileName()));
        final AniFile file = new AniFile(Files.newInputStream(this.path));
        final List<ParseError> errors = file.errors();
        if (errors.isEmpty()) {
            this.out.print("OK");
        } else {
            this.onErrors.accept(errors);
        }
    }
}
