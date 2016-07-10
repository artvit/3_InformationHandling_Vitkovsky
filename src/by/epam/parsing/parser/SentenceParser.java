package by.epam.parsing.parser;

import by.epam.parsing.composite.Component;
import by.epam.parsing.composite.Composite;
import by.epam.parsing.composite.LexemeLeaf;
import by.epam.parsing.entity.Expression;
import by.epam.parsing.entity.Sign;
import by.epam.parsing.entity.Word;
import by.epam.parsing.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class SentenceParser implements Parser{
    public static final Logger LOGGER = LogManager.getLogger();

    private static final String PUNCT = "[,.?\"`;:]";
    private static final Pattern PATTERN_WORD = Pattern.compile("[a-zA-Z]+");
    private static final Pattern PATTERN_SIGN = Pattern.compile(PUNCT);
    private static final Pattern PATTERN_EXPRESSION = Pattern.compile("[0-9\\-+*/().]+");
    private static final String REGEX_SPLIT_SENTENCE = "\\s+|(?<=\\w)(?=" + PUNCT +")|(?<=" + PUNCT + ")(?=\\w)|(?<=" + PUNCT + ")(?=" + PUNCT + ")";

    @Override
    public Component parse(String content) {
        Component sentence = new Composite();
        String[] parts = content.split(REGEX_SPLIT_SENTENCE);
        for (String part : parts) {
            try {
                LOGGER.info("Lexeme: " + part);
                LexemeLeaf lexeme = createLexeme(part);
                sentence.add(lexeme);
            } catch (ParserException e) {
                LOGGER.error("Cannot add parsed lexeme to text", e);
            }
        }
        return sentence;
    }

    private LexemeLeaf createLexeme(String lexeme) throws ParserException {
        if (PATTERN_WORD.matcher(lexeme).matches()) {
            return new Word(lexeme);
        } else if (PATTERN_SIGN.matcher(lexeme).matches()) {
            return new Sign(lexeme);
        } else if (PATTERN_EXPRESSION.matcher(lexeme).matches()) {
            Expression expression = new Expression(lexeme);
            expression.count();
            return expression;
        } else {
            throw new ParserException("Cannot parse lexeme: " + lexeme);
        }
    }
}
