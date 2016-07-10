package by.epam.parsing.calculator;

public class TerminalExpressionMinus implements MathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() + context.popValue());
    }
}
