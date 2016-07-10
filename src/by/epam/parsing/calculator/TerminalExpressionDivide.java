package by.epam.parsing.calculator;

public class TerminalExpressionDivide implements MathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue((context.popValue() / context.popValue()));
    }
}
