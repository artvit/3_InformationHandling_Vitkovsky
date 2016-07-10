package by.epam.parsing.parser;

import by.epam.parsing.composite.Component;
import by.epam.parsing.composite.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser {
    public static final Logger LOGGER = LogManager.getLogger();

    private static final Pattern PATTERN_PARAGRAPH = Pattern.compile("(.*)(?=[\\n\\r]*|$)");

    private ParagraphParser paragraphParser;

    public TextParser() {
        this.paragraphParser = new ParagraphParser();
    }

    @Override
    public Component parse(String content) {
        Component text = new Composite();
        Matcher matcher = PATTERN_PARAGRAPH.matcher(content);
        while (matcher.find()) {
            String paragraph = matcher.group(1);
            if (!paragraph.isEmpty()) {
                LOGGER.info("Parsing paragraph:\n" + paragraph);
                Component paragraphComponent = paragraphParser.parse(paragraph);
                text.add(paragraphComponent);
            }
        }
        return text;
    }
}
