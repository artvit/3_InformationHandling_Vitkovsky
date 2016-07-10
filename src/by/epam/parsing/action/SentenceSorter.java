package by.epam.parsing.action;

import by.epam.parsing.composite.Component;
import by.epam.parsing.util.TextReporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceSorter {
    private ArrayList<Component> sentences;

    public SentenceSorter() {
        sentences = new ArrayList<>();
    }

    public void sortSentences(Component text) {
        for (int i = 0; i < text.getChildNumber(); ++i) {
            Component paragraph = text.getChild(i);
            for (int j = 0; j < paragraph.getChildNumber(); ++j) {
                sentences.add(paragraph.getChild(j));
            }
        }
        Collections.sort(sentences, (o1, o2) -> Integer.compare(o1.getLexemeNumber(), o2.getLexemeNumber()));
    }

    public List<String> getSentencesStringList() {
        return  sentences.stream().map(TextReporter::getSentenceString).collect(Collectors.toList());
    }

    public String getSentencesString() {
        return  sentences.stream().map(TextReporter::getSentenceString).collect(Collectors.joining("\n"));
    }
}
