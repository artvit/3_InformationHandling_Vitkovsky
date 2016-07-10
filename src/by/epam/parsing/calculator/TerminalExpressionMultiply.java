package by.epam.parsing.calculator;

public class TerminalExpressionMultiply implements MathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue((context.popValue() * context.popValue()));
    }
}
