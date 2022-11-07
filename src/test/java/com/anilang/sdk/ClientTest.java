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
    void syntaxOption() {
        Client.main(new String[]{"-s src/test/resources/invalid_Assignation.ani"});
        Assertions.assertEquals(
            0,
            outContext.toString().indexOf("Syntax analysis over file: invalid_Assignation.ani")
        );
    }

}
