package by.epam.parsing.calculator;

import java.util.ArrayDeque;

public class ExpressionParser {
public String parsePostfixNotation(String infixNotation) {
        StringBuilder result = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean processingNumber = false;
        for (int i = 0; i < infixNotation.length(); ++i) {
            char a = infixNotation.charAt(i);
            switch (a) {
                case '+':
                case '-':
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        result.append(' ').append(stack.pop());
                    }
                    result.append(' ');
                    stack.push(a);
                    break;
                case '*':
                case '/':
                    result.append(' ');
                    stack.push(a);
                    break;
                case '(':
                    stack.add(a);
                    break;
                case ')':
                    for (char c = stack.poll(); c != '('; c = stack.poll()) {
                        result.append(' ').append(c);
                    }
                    break;
                default:
                    result.append(a);
            }
        }
        for (Character c : stack) {
            result.append(' ').append(c);
        }
        return result.toString();
    }
}
