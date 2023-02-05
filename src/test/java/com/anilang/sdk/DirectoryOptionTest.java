/*
 * Property of Opencore
 */

package com.anilang.sdk;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests file.
 *
 * @since 0.1.0
 */
class DirectoryOptionTest extends BaseConsoleOutputTest {

    // @checkstyle JavadocMethodCheck (500 lines)

    @Test
    void underDirectoryRun() throws IOException {
        new DirectoryOption(
            "src/test/resources",
            SyntaxOption::new
        ).run();
        Assertions.assertEquals(
            7,
            outContext.toString().indexOf("Running under directory: src/test/resources")
        );
    }
}
