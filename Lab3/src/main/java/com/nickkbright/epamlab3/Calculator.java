package com.nickkbright.epamlab3;

import java.util.Stack;

public class Calculator {

    private boolean isDelimiter(char symbol) {
        return symbol == ' ';
    }

    private boolean isOperation(char symbol) {
        return (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' || symbol == '(' || symbol == ')');
    }

    private int getPriority(char symbol) {
        switch (symbol) {
            case '(': return 0;
            case ')': return 1;
            case '+': return 2;
            case '-': return 3;
            case '*': return 4;
            case '/': return 4;
            default: return 6;
        }
    }

    public double calculate(String input) {
        String output = getExpression(input);
        double result = counting(output);
        return result;
    }

    public String getExpression(String expression) {
        String output = "";
        Stack<Character> operators = new Stack<Character>();

        for (int i =0; i < expression.length(); i++) {
            if (isDelimiter(expression.charAt(i))) {
                continue;
            }
            if (Character.isDigit(expression.charAt(i))) {
                while (!isDelimiter(expression.charAt(i)) && !isOperation(expression.charAt(i))) {
                    output += expression.charAt(i);
                    i++;

                    if (i == expression.length()) {
                        break;
                    }
                }
                output += " ";
                i--;
            }
            if (isOperation(expression.charAt(i))) {
                if (expression.charAt(i) == '(') {
                    operators.push(expression.charAt(i));
                } else if (expression.charAt(i) == ')') {
                    char symbol = operators.pop();
                    while (symbol != '(') {
                        output +=symbol + " ";
                        symbol = operators.pop();
                    }
                } else {
                    if (operators.size() > 0) {
                        if (getPriority(expression.charAt(i)) <= getPriority(operators.peek())) {
                            output += operators.pop().toString() + " ";
                        }
                    }
                    operators.push(expression.charAt(i));
                }
            }
        }
        while (operators.size() > 0) {
            output += operators.pop() + " ";
        }
        return output;
    }

    private double counting(String expression) {
        double result = 0;
        Stack<Double> temp = new Stack<Double>();

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                String a = "";
                while (!isDelimiter(expression.charAt(i)) && !isOperation(expression.charAt(i))) {
                    a += expression.charAt(i);
                    i++;
                    if (i == expression.length()) {
                        break;
                    }
                }
                temp.push(Double.parseDouble(a));
                i--;
            } else if (isOperation(expression.charAt(i))) {
                double a = temp.pop();
                double b = temp.pop();

                switch (expression.charAt(i))
                {
                    case '+':
                        result = b + a;
                        break;
                    case '-':
                        result = b - a;
                        break;
                    case '*':
                        result = b * a;
                        break;
                    case '/':
                        if (a == 0.0) {
                            throw new ArithmeticException();
                        }
                        result = b / a;
                        break;
                }
                temp.push(result);
            }
        }
        return temp.peek();
    }

}