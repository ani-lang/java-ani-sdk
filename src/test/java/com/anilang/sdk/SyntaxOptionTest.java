/*
 * Property of Opencore
 */

package com.anilang.sdk;

import java.io.IOException;
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
        new SyntaxOption(
            new ResourceOf("/invalid_assignation.ani").toString()
        ).run();
        Assertions.assertEquals(
            -1,
            outContext.toString().indexOf("OK")
        );
    }

    @Test
    void noErrorsFound() throws IOException {
        new SyntaxOption(
            new ResourceOf("/literal_assignation.ani").toString()
        ).run();
        Assertions.assertEquals(
            65,
            outContext.toString().indexOf("OK")
        );
    }
}
