package com.mjc.stage2;

import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.parser.AbstractTextParser;
import com.mjc.stage2.parser.ChainParserBuilder;
import com.mjc.stage2.parser.LexemeParser;
import com.mjc.stage2.parser.WordParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Task3Application {
    public static void main(String[] args) {
        AbstractTextParser parser = new ChainParserBuilder()
                .setParser(new LexemeParser())
                .setParser(new WordParser())
                .build();

        TextComponent sentence = new TextComponent(TextComponentType.SENTENCE);
        try (
                InputStream is = Task3Application.class.getResourceAsStream("/data/textdata.txt");
                InputStreamReader reader = new InputStreamReader(is);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            String s = bufferedReader.readLine();
            parser.parse(sentence, s);
        } catch (IOException e) {

        }
        System.out.println(sentence);
    }
}
