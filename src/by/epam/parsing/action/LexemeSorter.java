package by.epam.parsing.action;

import by.epam.parsing.composite.Component;

import java.util.*;

public class LexemeSorter {
    TreeMap<Character, TreeSet<String>> lexemes;

    public LexemeSorter() {
        lexemes = new TreeMap<>();
    }

    public void sortLexemes(Component text) {
        handleComponent(text);
    }

    public List<String> getResultStrings() {
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<Character, TreeSet<String>> entry : lexemes.entrySet()) {
            TreeSet<String> lexemes = entry.getValue();
            StringBuilder lexemesLine = new StringBuilder();
            for (String lexeme : lexemes) {
                lexemesLine.append(lexeme).append(' ');
            }
            result.add(lexemesLine.toString());
        }
        return result;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        getResultStrings().forEach((x) -> result.append(x).append('\n'));
        return result.toString();
    }

    private void handleComponent(Component component) {
        for (int i = 0; i < component.getChildNumber(); ++i) {
            Component current = component.getChild(i);
            if (current == null) {
                addLexeme(component);
            } else {
                handleComponent(current);
            }
        }
    }

    private void addLexeme(Component lexeme) {
        char firstLetter = lexeme.toString().toLowerCase().charAt(0);
        if (!lexemes.containsKey(firstLetter)) {
            lexemes.put(firstLetter, new TreeSet<>());
        }
        lexemes.get(firstLetter).add(lexeme.toString().toLowerCase());
    }
}
