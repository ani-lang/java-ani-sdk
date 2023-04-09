/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

import com.anilang.context.AniContext;
import com.anilang.context.analysis.FileAnalysisBuilder;
import com.anilang.context.impl.BaseAniContext;
import com.anilang.parser.AniFile;
import com.anilang.parser.ParseError;
import com.anilang.parser.antlr.AniParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.antlr.v4.runtime.ParserRuleContext;

public final class ContextOption implements RunnableOption {

    /**
     * Print the lines to the output.
     */
    private final OutputLine out;

    /**
     * File path to verify context.
     */
    private final Path path;

    public ContextOption(final String raw) {
        this.path = Paths.get(raw);
        this.out = new OutputLine();
    }

    @Override
    public void run() throws IOException {
        new SyntaxOption(
            this.path.toString(),
            // TODO duplicated code
            // #37
            errors -> {
                for (final ParseError error : errors) {
                    new OutputLine().print(error.getError());
                }
                System.exit(1);
            }
        ).run();
        this.out.print(String.format("Context analysis over file: %s", this.path.getFileName()));
        final AniParser parser = new AniFile(Files.newInputStream(this.path)).parse();
        final AniContext context = new BaseAniContext();
        new FileAnalysisBuilder(context, parser)
            .analyzeDeclaration()
            .analyzeUsageBuilder()
            .analyzeIdentifierValidation(new OutputLineBiConsumer(this.out))
            .analyzeTypeDefinition()
            .analyzeTypeResolve()
            .analyzeTypesValidation(new OutputLineConsumer(this.out))
            .build()
            .run();
        this.out.print("OK");
    }

    private class OutputLineBiConsumer implements BiConsumer<ParserRuleContext, String> {
        private final OutputLine out;

        public OutputLineBiConsumer(final OutputLine out) {
            this.out = out;
        }

        @Override
        public void accept(final ParserRuleContext ctx, final String identifier) {
            this.out.err(
                String.format(
                    "Var '%s' at position [%s:%s] is not defined.",
                    identifier,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine() + 1
                )
            );
            System.exit(1);
        }
    }

    private class OutputLineConsumer implements Consumer<String> {
        private final OutputLine out;

        public OutputLineConsumer(final OutputLine out) {
            this.out = out;
        }

        @Override
        public void accept(final String error) {
            this.out.err(error);
            System.exit(1);
        }
    }
}
