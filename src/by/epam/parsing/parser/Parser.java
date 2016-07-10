package by.epam.parsing.parser;

import by.epam.parsing.composite.Component;

public interface Parser {
    Component parse(String content);
}
