package by.epam.parsing.util;

import by.epam.parsing.action.LexemeSorter;
import by.epam.parsing.action.SentenceSorter;
import by.epam.parsing.composite.Component;
import by.epam.parsing.exception.ReporterException;
import by.epam.parsing.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String FILE_NAME = "data/text.txt";
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            LOGGER.info("File has been read successfully");
            TextParser parser = new TextParser();
            LOGGER.info("Text parser has been created");
            Component text = parser.parse(content);
            LOGGER.info("Text has been parsed");

//            SentenceSorter sentenceSorter = new SentenceSorter();
//            LOGGER.info("Start sorting sentences");
//            sentenceSorter.sortSentences(text);
//            LOGGER.info("Result list:\n" + sentenceSorter.getSentencesString());

            LexemeSorter lexemeSorter = new LexemeSorter();
            LOGGER.info("Start sorting lexemes");
            lexemeSorter.sortLexemes(text);
            LOGGER.info("Result:\n" + lexemeSorter.getResult());

            TextReporter reporter = new TextReporter(text);
            LOGGER.info("Text reporter has been created");
            String result = reporter.createReport();
            LOGGER.info("Result:\n" + result);
        } catch (IOException e) {
            LOGGER.fatal("Cannot read file", e);
        } catch (ReporterException e) {
            LOGGER.error("Cannot report text", e);
        }
    }
}
