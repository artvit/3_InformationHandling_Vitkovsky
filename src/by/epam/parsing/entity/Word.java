package by.epam.parsing.entity;

import by.epam.parsing.composite.LexemeLeaf;

public class Word extends LexemeLeaf {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}
