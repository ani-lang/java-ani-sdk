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
 * <p>
 * TODO add unit tests for the Client
 * unit tests are missing
 * will be empty for now but is a must.
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
     * TODO move print options out of the Client
     * too many sout's looks wrong
     * lets move them to an object an make the Client configurable
     * <p>
     * TODO SDK and Ani version must com from the pom itself.
     * get both versions from the pom.
     *
     * @param args Client input.
     */
    @SuppressWarnings("PMD.SystemPrintln")
    public static void main(final String[] args) {
        final Option compile = Option.builder()
            .argName("file.ani")
            .desc("Compile an Ani file.")
            .option("c")
            .longOpt("compile")
            .hasArg()
            .build();
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
        final Options options = new Options();
        options.addOption(compile);
        options.addOption(syntax);
        options.addOption(version);
        options.addOption(help);
        final HelpFormatter formatter = new HelpFormatter();
        final CommandLineParser parser = new DefaultParser();
        try {
            final CommandLine line = parser.parse(options, args);
            if (line.hasOption(compile)) {
                System.out.println("Compile not implemented.");
            }
            if (line.hasOption(syntax)) {
                System.out.println("Syntax not implemented.");
            }
            if (line.hasOption(version)) {
                System.out.println("Java Ani SDK Version 0.1.0");
                System.out.println("Anilang Version 0.3.0");
            }
            if (line.hasOption(help)) {
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
