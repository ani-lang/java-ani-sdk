/*
 * Property of Opencore
 */

package com.anilang.sdk;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
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
     * <p>
     * TODO SDK and Ani version must com from the pom itself.
     * get both versions from the pom.
     *
     * @param args Client input.
     */
    @SuppressWarnings("PMD.SystemPrintln")
    public static void main(final String[] args) {
        final Option run = Option.builder()
            .argName("file.ani")
            .desc("Run an Ani file.")
            .option("r")
            .longOpt("run")
            .hasArg()
            .build();
        final Option compile = Option.builder()
            .argName("file.ani")
            .desc("Compile an Ani file.")
            .option("c")
            .longOpt("compile")
            .hasArg()
            .build();
        /* @checkstyle MethodBodyCommentsCheck (5 lines)
         * TODO include syntax check for a directory
         * validate syntax for all files in a directory
         * for ani files only
         */
        final Option syntax = Option.builder()
            .argName("file.ani")
            .desc("Verify syntax of an Ani file.")
            .option("s")
            .longOpt("syntax")
            .hasArg()
            .build();
        final Option version = Option.builder()
            .argName("version")
            .desc("Version of the SDK and Ani.")
            .option("v")
            .longOpt("version")
            .build();
        final Option help = Option.builder()
            .argName("help")
            .desc("Ani SDK usage.")
            .option("h")
            .longOpt("help")
            .build();
        /* @checkstyle MethodBodyCommentsCheck (10 lines)
         * TODO use decorator to apply options
         * some options depend on each other like compile an run
         * others not like version and help.
         * Create decorators to run all the options over the same arg instead of expecting
         * an arg per each option
         */
        final Options options = new Options();
        options.addOption(run);
        options.addOption(compile);
        options.addOption(syntax);
        options.addOption(version);
        options.addOption(help);
        final HelpFormatter formatter = new HelpFormatter();
        final CommandLineParser parser = new DefaultParser();
        try {
            final CommandLine line = parser.parse(options, args);
            if (line.hasOption(run)) {
                System.out.println("Run not implemented.");
            }
            /* @checkstyle MethodBodyCommentsCheck (5 lines)
             * TODO move print options out of the Client
             * too many sout's looks wrong
             * lets move them to an object an make the Client configurable
             */
            if (line.hasOption(compile)) {
                System.out.println("Compile not implemented.");
            }
            if (line.hasOption(syntax)) {
                final String value = line.getOptionValue(syntax).trim();
                new HandleExceptions(
                    new SyntaxOption(
                        value
                    )
                ).run();
            }
            if (line.hasOption(version)) {
                System.out.println("Java Ani SDK Version 0.1.0");
                System.out.println("Anilang Version 0.3.0");
            }
            if (line.hasOption(help)) {
                printHelp(options, formatter);
            }
            if (line.getOptions().length == 0) {
                printHelp(options, formatter);
            }
        } catch (final ParseException exp) {
            System.out.printf("Unexpected error: %s%n", exp.getMessage());
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
