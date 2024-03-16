package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        for (String lexeme : string.split(LEXEME_REGEX)) {
            if (lexeme.matches(WORD_REGEX)) {
                TextComponent textComponent = new TextComponent(TextComponentType.WORD);
                abstractTextComponent.add(textComponent);
                if (nextParser != null) {
                    nextParser.parse(textComponent, lexeme);
                }
            }
        }
    }
}
