package by.epam.parsing.parser;

import by.epam.parsing.composite.Component;
import by.epam.parsing.composite.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    public static final Logger LOGGER = LogManager.getLogger();

    private static final Pattern PATTERN_SENTENCE = Pattern.compile("\\s?([a-zA-Z,;:'\"\\s]+[.!?])\\s*");

    private SentenceParser sentenceParser;

    public ParagraphParser() {
        this.sentenceParser = new SentenceParser();
    }

    @Override
    public Component parse(String content) {
        Component paragraph = new Composite();
        Matcher matcher = PATTERN_SENTENCE.matcher(content);
        while (matcher.find()) {
            String sentence = matcher.group(1);
            LOGGER.info("Parsing sentence:\n" + sentence);
            Component sentenceComponent = sentenceParser.parse(sentence);
            paragraph.add(sentenceComponent);
        }
        return paragraph;
    }
}
