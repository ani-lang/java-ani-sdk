/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

import org.apache.commons.cli.Option;

/**
 * Available Ani options.
 * TODO remove this data class
 * #20 it was the easiest way. Lets give a second try.
 *
 * @since 0.1.0
 */
@SuppressWarnings({"PMD.DataClass", "PMD.AvoidFieldNameMatchingMethodName"})
public final class AniOptions {

    /**
     * Run ani file.
     */
    private final Option run;

    /**
     * Compile ani file.
     */
    private final Option compile;

    /**
     * Verify ani syntax.
     */
    private final Option syntax;

    /**
     * Apply directory scope.
     */
    private final Option directory;

    /**
     * Display version.
     */
    private final Option version;

    /**
     * Display help.
     */
    private final Option help;

    /**
     * Verify code consistency for declarations.
     */
    private final Option context;

    /**
     * Ctor.
     */
    public AniOptions() {
        this.run = Option.builder()
            .argName("file.ani")
            .desc("Run an Ani file.")
            .option("r")
            .longOpt("run")
            .hasArg()
            .build();
        this.compile = Option.builder()
            .argName("file.ani")
            .desc("Compile an Ani file.")
            .option("c")
            .longOpt("compile")
            .hasArg()
            .build();
        this.syntax = Option.builder()
            .argName("file.ani")
            .desc("Verify syntax of an Ani file.")
            .option("s")
            .longOpt("syntax")
            .hasArg()
            .build();
        this.directory = Option.builder()
            .desc("Apply option over a directory.")
            .option("d")
            .longOpt("directory")
            .build();
        this.version = Option.builder()
            .argName("version")
            .desc("Version of the SDK and Ani.")
            .option("v")
            .longOpt("version")
            .build();
        this.help = Option.builder()
            .argName("help")
            .desc("Ani SDK usage.")
            .option("h")
            .longOpt("help")
            .build();
        this.context = Option.builder()
            .argName("file.ani")
            .desc("Verify code context consistency.")
            .option("x")
            .longOpt("context")
            .hasArg()
            .build();
    }

    /**
     * Run option.
     *
     * @return An option.
     */
    public Option run() {
        return this.run;
    }

    /**
     * Compile option.
     *
     * @return An option.
     */
    public Option compile() {
        return this.compile;
    }

    /**
     * Syntax option.
     *
     * @return An option.
     */
    public Option syntax() {
        return this.syntax;
    }

    /**
     * Directory option.
     *
     * @return An option.
     */
    public Option directory() {
        return this.directory;
    }

    /**
     * Version option.
     *
     * @return An option.
     */
    public Option version() {
        return this.version;
    }

    /**
     * Help option.
     *
     * @return An option.
     */
    public Option help() {
        return this.help;
    }

    /**
     * Verify context option.
     *
     * @return An option.
     */
    public Option context() {
        return this.context;
    }
}
