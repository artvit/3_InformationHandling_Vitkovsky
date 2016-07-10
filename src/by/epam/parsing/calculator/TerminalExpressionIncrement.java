package by.epam.parsing.calculator;

public class TerminalExpressionIncrement implements MathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() + 1);
    }
}
