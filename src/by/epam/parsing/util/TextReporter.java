package by.epam.parsing.util;

import by.epam.parsing.composite.Component;
import by.epam.parsing.entity.Sign;
import by.epam.parsing.exception.ReporterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextReporter {
    public static final Logger LOGGER = LogManager.getLogger();

    private Component text;

    public TextReporter(Component text) {
        this.text = text;
    }

    public String createReport() throws ReporterException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.getChildNumber(); ++i) {
            Component paragraph = text.getChild(i);
            for (int j = 0; j < paragraph.getChildNumber(); ++j) {
                result.append(getSentenceString(paragraph.getChild(j))).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public Component getText() {
        return text;
    }

    public void setText(Component text) {
        this.text = text;
    }

    public static String getSentenceString(Component sentence) {
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < sentence.getLexemeNumber(); ++k) {
            Component lexeme = sentence.getChild(k);
            result.append(lexeme);
            if (k < sentence.getLexemeNumber() - 1 && !(sentence.getChild(k + 1) instanceof Sign)) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
