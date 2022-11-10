/*
 * Property of Opencore
 */

package com.anilang.sdk;

import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests.
 *
 * @since 0.1.0
 */
class SyntaxOptionTest extends BaseConsoleOutputTest {

    // @checkstyle JavadocMethodCheck (500 lines)
    // @checkstyle StaticAccessToStaticFields (500 lines)

    @Test
    void printErrors() throws IOException {
        System.out.println(Paths.get("").toAbsolutePath());
        new SyntaxOption("/src/test/resources/invalid_Assignation.ani").run();
        Assertions.assertEquals(
            -1,
            outContext.toString().indexOf("OK")
        );
    }

    @Test
    void noErrorsFound() throws IOException {
        System.out.println(Paths.get("").toAbsolutePath());
        new SyntaxOption("/src/test/resources/literal_Assignation.ani").run();
        Assertions.assertEquals(
            51,
            outContext.toString().indexOf("OK")
        );
    }
}
