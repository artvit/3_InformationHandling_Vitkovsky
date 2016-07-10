package by.epam.parsing.calculator;

public class NonterminalExpressionNumber implements MathExpression {
    private double number;
    public NonterminalExpressionNumber(double number) {
        this.number = number;
    }
    @Override
    public void interpret(Context c) {
        c.pushValue(number);
    }
}
