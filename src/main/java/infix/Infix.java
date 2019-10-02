package infix;

import java.util.Stack;

public class Infix {
    public static void main(String[] args) {
        // (a+b)*c+d = ab+c*d+
        // (a+b)*(c+d) = ab+cd+*
        // a+b*c+d = abc*+d+
        System.out.println(toPostfix("(a+b)*c+d"));
        System.out.println(toPostfix("(a+b)*(c+d)"));
        System.out.println(toPostfix("a+b*c+d"));

        // (a+b)*c+d = +*+abcd
        // (a+b)*(c+d) = *+ab+cd
        // a+b*c+d = +a+*bcd
        System.out.println(toPrefix("(a+b)*c+d"));
        System.out.println(toPrefix("(a+b)*(c+d)"));
        System.out.println(toPrefix("a+b*c+d"));
    }

    public static String toPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : infix.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (stack.peek() != '(')
                    output.append(stack.pop());
                stack.pop();
            } else if ("+-*/".indexOf(c) != -1) {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c))
                    output.append(stack.pop());
                stack.push(c);
            } else
                output.append(c);
        }
        while (!stack.isEmpty())
            output.append(stack.pop());
        return output.toString();
    }


    public static String toPrefix(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : new StringBuilder(infix).reverse().toString().toCharArray()) {
            if (c == ')')
                stack.push(c);
            else if (c == '(') {
                while (stack.peek() != ')')
                    output.append(stack.pop());
                stack.pop();
            } else if ("+-*/".indexOf(c) != -1) {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c))
                    output.append(stack.pop());
                stack.push(c);
            } else
                output.append(c);
        }
        while (!stack.isEmpty())
            output.append(stack.pop());
        return output.reverse().toString();
    }

    private static int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
