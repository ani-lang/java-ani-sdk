/*
 * Property of Opencore
 */

package com.anilang.sdk;

import com.anilang.parser.AniFile;
import com.anilang.parser.ParseError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
     * Ctor.
     *
     * @param raw Raw path to the file.
     */
    public SyntaxOption(final String raw) {
        this.path = Paths.get(raw);
    }

    @SuppressWarnings("PMD.SystemPrintln")
    @Override
    public void run() throws IOException {
        System.out.printf("Syntax analysis over file: %s%n", this.path.getFileName());
        final AniFile file = new AniFile(Files.newInputStream(this.path));
        final List<ParseError> errors = file.errors();
        if (errors.isEmpty()) {
            System.out.println("OK");
        } else {
            for (final ParseError error : errors) {
                System.out.println(error.getError());
            }
        }
    }
}
