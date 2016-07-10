package by.epam.parsing.entity;

import by.epam.parsing.composite.LexemeLeaf;

public class Expression extends LexemeLeaf {
    private String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public void count() {
        
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return expression;
    }
}
