/*
 * Property of ani-lang project.
 */

package com.anilang.sdk;

import com.anilang.context.AniContext;
import com.anilang.context.impl.BaseAniContext;
import com.anilang.context.listener.IdentifierDeclarationListener;
import com.anilang.context.listener.IdentifierUsageListener;
import com.anilang.context.listener.IdentifierValidationListener;
import com.anilang.context.listener.TypeDefinitionListener;
import com.anilang.context.listener.TypeResolveListener;
import com.anilang.parser.AniFile;
import com.anilang.parser.ParseError;
import com.anilang.parser.antlr.AniParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiConsumer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
        ParseTreeWalker.DEFAULT.walk(
            new IdentifierDeclarationListener(context),
            parser.file()
        );
        parser.reset();
        ParseTreeWalker.DEFAULT.walk(
            new IdentifierUsageListener(context),
            parser.file()
        );
        parser.reset();
        ParseTreeWalker.DEFAULT.walk(
            new IdentifierValidationListener(context, new OutputLineConsumer(this.out)),
            parser.file()
        );
        parser.reset();
        ParseTreeWalker.DEFAULT.walk(
            new TypeDefinitionListener(context),
            parser.file()
        );
        parser.reset();
        ParseTreeWalker.DEFAULT.walk(
            new TypeResolveListener(context),
            parser.file()
        );
        this.out.print("OK");
    }

    private class OutputLineConsumer implements BiConsumer<ParserRuleContext, String> {
        private final OutputLine out;

        public OutputLineConsumer(final OutputLine out) {
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
}
