package infix;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        int ans = Calculator.calcPostfix(Infix.toPostfix("(1+2)*(3+4)"));
        System.out.println(ans);
        ans = Calculator.calcPrefix(Infix.toPrefix("(1+2)*(3+4)"));
        System.out.println(ans);
    }

    public static int calcPostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            if ("+-*/".indexOf(c) != -1)
                stack.push(calc(c, stack.pop(), stack.pop()));
            else
                stack.push(Integer.valueOf(String.valueOf(c)));
        }
        return stack.pop();
    }

    public static int calcPrefix(String prefix) {
        Stack<Integer> stack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if ("+-*/".indexOf(c) != -1)
                stack.push(calc(c, stack.pop(), stack.pop()));
            else
                stack.push(Integer.valueOf(String.valueOf(c)));
        }
        return stack.pop();
    }

    private static int calc(char operator, Integer x, Integer y) {
        switch (operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                throw new ArithmeticException();
        }
    }
}
