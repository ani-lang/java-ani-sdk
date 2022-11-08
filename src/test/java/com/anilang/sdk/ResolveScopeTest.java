/*
 * Property of Opencore
 */

package com.anilang.sdk;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test file.
 *
 * @since 0.1.0
 */
class ResolveScopeTest {

    // @checkstyle JavadocMethodCheck (500 lines)

    @Test
    void isDirectory() throws ParseException {
        final AniOptions sdk = new AniOptions();
        /* @checkstyle MethodBodyCommentsCheck (5 lines)
         * TODO Wrap Options creation on an object
         *  #20 lets move this object setup into a separate object.
         */
        final Options options = new Options();
        options.addOption(sdk.run());
        options.addOption(sdk.compile());
        options.addOption(sdk.directory());
        options.addOption(sdk.version());
        options.addOption(sdk.help());
        final CommandLineParser parser = new DefaultParser();
        final CommandLine line = parser.parse(options, new String[]{"-d"});
        Assertions.assertTrue(
            new ResolveScope(
                line,
                sdk
            ).isDirectory()
        );
    }
}
