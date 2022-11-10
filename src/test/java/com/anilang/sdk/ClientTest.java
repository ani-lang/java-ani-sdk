/*
 * Property of Opencore
 */

package com.anilang.sdk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test.
 *
 * @since 0.1.0
 */
class ClientTest extends BaseConsoleOutputTest {

    // @checkstyle JavadocMethodCheck (500 lines)

    @Test
    void runOption() {
        final String file = new ResourceOf("/invalid_assignation.ani").toString();
        Client.main(new String[]{String.format("-r %s", file)});
        Assertions.assertEquals(
            0,
            outContext.toString().indexOf("Run not implemented.")
        );
    }

    @Test
    void compileOption() {
        final String file = new ResourceOf("/invalid_assignation.ani").toString();
        Client.main(new String[]{String.format("-c %s", file)});
        Assertions.assertEquals(
            0,
            outContext.toString().indexOf("Compile not implemented.")
        );
    }

    @Test
    void syntaxOption() {
        final String file = new ResourceOf("/invalid_assignation.ani").toString();
        Client.main(new String[]{String.format("-s %s", file)});
        Assertions.assertEquals(
            0,
            outContext.toString().indexOf("Syntax analysis over file: invalid_assignation.ani")
        );
    }

    @Test
    void directoryOption() {
        Client.main(new String[]{"-d", "-s src/test/resources"});
        Assertions.assertEquals(
            0,
            outContext.toString().indexOf("Running under directory: src/test/resources")
        );
    }

    @Test
    void versionOption() {
        Client.main(new String[]{"-v"});
        Assertions.assertEquals(
            0,
            outContext.toString().indexOf("Ani SDK Version (Java)")
        );
    }

    @Test
    void helpOption() {
        Client.main(new String[]{"-h"});
        Assertions.assertEquals(
            0,
            outContext.toString().indexOf("usage: Ani")
        );
    }

    @Test
    void nonOption() {
        Client.main(new String[]{""});
        Assertions.assertEquals(
            0,
            outContext.toString().indexOf("usage: Ani"),
            "display help by default."
        );
    }
}
