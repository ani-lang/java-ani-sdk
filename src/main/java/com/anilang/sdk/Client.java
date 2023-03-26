/*
 * Property of Opencore
 */

package com.anilang.sdk;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Command line client implementation for Ani SDK.
 *
 * @since 0.1.0
 */
public final class Client {

    /**
     * Ctor.
     */
    private Client() {
        // main class.
    }

    /**
     * Main method.
     *
     * @param args Client input.
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    public static void main(final String[] args) {
        final OutputLine output = new OutputLine();
        final AniOptions sdk = new AniOptions();
        /* @checkstyle MethodBodyCommentsCheck (10 lines)
         * TODO use decorator to apply options
         * some options depend on each other like compile an run
         * others not like version and help.
         * Create decorators to run all the options over the same arg instead of expecting
         * an arg per each option
         */
        final Options options = new Options();
        options.addOption(sdk.run());
        options.addOption(sdk.compile());
        options.addOption(sdk.syntax());
        options.addOption(sdk.directory());
        options.addOption(sdk.version());
        options.addOption(sdk.help());
        options.addOption(sdk.context());
        final HelpFormatter formatter = new HelpFormatter();
        final CommandLineParser parser = new DefaultParser();
        try {
            final CommandLine line = parser.parse(options, args);
            if (line.hasOption(sdk.run())) {
                output.print("Run not implemented.");
            }
            if (line.hasOption(sdk.compile())) {
                output.print("Compile not implemented.");
            }
            if (line.hasOption(sdk.syntax())) {
                new HandleExceptions(
                    new ScopedOption(
                        new ResolveScope(
                            line,
                            sdk
                        ),
                        /* @checkstyle MethodBodyCommentsCheck (5 lines)
                         * TODO Trim input object
                         *  #20 create an object that trims the input.
                         */
                        line.getOptionValue(sdk.syntax()).trim(),
                        SyntaxOption::new
                    )
                ).run();
            }
            if (line.hasOption(sdk.version())) {
                new HandleExceptions(
                    new VersionOption()
                ).run();
            }
            if (line.hasOption(sdk.help())) {
                printHelp(options, formatter);
            }
            if (line.hasOption(sdk.context())) {
                new HandleExceptions(
                    new ScopedOption(
                        new ResolveScope(
                            line,
                            sdk
                        ),
                        line.getOptionValue(sdk.context()).trim(),
                        ContextOption::new
                    )
                ).run();
            }
            if (line.getOptions().length == 0) {
                printHelp(options, formatter);
            }
        } catch (final ParseException exp) {
            output.print(String.format("Unexpected error: %s", exp.getMessage()));
            printHelp(options, formatter);
        }
    }

    /**
     * Print help information.
     *
     * @param options Command options.
     * @param formatter Help format message.
     */
    private static void printHelp(final Options options, final HelpFormatter formatter) {
        formatter.printHelp("Ani", options);
    }
}
