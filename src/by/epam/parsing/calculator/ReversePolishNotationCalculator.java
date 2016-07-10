package by.epam.parsing.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class ReversePolishNotationCalculator {
    private ArrayList<MathExpression> listExpression;
    public ReversePolishNotationCalculator(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }
    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextDouble()) {
                        listExpression.add(
                                new NonterminalExpressionNumber(scan.nextDouble()));
                    }
            }
        }
    }
    public Double calculate() {
        Context context = new Context();
        for (MathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
