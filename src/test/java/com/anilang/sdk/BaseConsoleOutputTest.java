/*
/*
 * Property of Opencore
 */

package com.anilang.sdk;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Base implementation of tests that print to console.
 *
 * @since 0.1.0
 */
@SuppressWarnings({"PMD.FieldNamingConventions", "PMD.StaticAccessToStaticFields"})
class BaseConsoleOutputTest {

    // @checkstyle JavadocMethodCheck (500 lines)
    // @checkstyle StaticVariableNameCheck (500 lines)
    // @checkstyle StaticAccessToStaticFields (500 lines)
    // @checkstyle VisibilityModifierCheck (500 lines)
    // @checkstyle DeclarationOrderCheck (500 lines)

    /**
     * The output stream.
     */
    private static PrintStream printStream;

    /**
     * Bites to read output.
     */
    protected static ByteArrayOutputStream outContext;

    /**
     * To restore the output after the tests are finished.
     */
    private static final PrintStream ORIGINAL_OUT = System.out;

    @BeforeEach
    void setUpStreams() {
        if (Objects.nonNull(printStream)) {
            printStream.close();
        }
        outContext = new ByteArrayOutputStream();
        printStream = new PrintStream(outContext);
        System.setOut(printStream);
    }

    @AfterAll
    static void restoreStreams() {
        printStream.close();
        System.setOut(ORIGINAL_OUT);
    }
}
