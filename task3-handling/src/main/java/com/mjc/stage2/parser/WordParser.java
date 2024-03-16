package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;

public class WordParser extends AbstractTextParser {
    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        int stringLength = string.length();
        for (int i = 0; i < stringLength; i++) {
            SymbolLeaf symbolLeaf = new SymbolLeaf(string.charAt(i));
            abstractTextComponent.add(symbolLeaf);
        }
    }
}
