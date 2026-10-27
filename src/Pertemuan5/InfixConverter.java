package Pertemuan5;

import java.util.Scanner;
import java.util.Stack;

public class InfixConverter {

    // Menentukan prioritas/kekuatan operator
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Fungsi untuk membalikkan string Infix & menukar kurung (Formula Infix)
    public static String reverseInfix(String infix) {
        StringBuilder reversed = new StringBuilder();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (c == '(') {
                reversed.append(')');
            } else if (c == ')') {
                reversed.append('(');
            } else {
                reversed.append(c);
            }
        }
        return reversed.toString();
    }

    public static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    public static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.length() == 1 && isOperator(token.charAt(0))) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String temp = token.charAt(0) + " " + op1 + " " + op2;
                stack.push(temp);
            } else {
                stack.push(token);
            }
        }

        return stack.pop();
    }

    // 3. Fungsi Utama Infix ke Prefix
    public static String infixToPrefix(String infix) {
        String postfix = infixToPostfix(infix);
        return postfixToPrefix(postfix);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. Masukkan Infix : ");
        String inputInfix = scanner.nextLine().replaceAll("\\s+", "");
        String formulaInfix = reverseInfix(inputInfix);
        System.out.println("2. Formula Infix (Reversed Infix) : " + formulaInfix);

        String reversedPostfix = infixToPostfix(formulaInfix);
        System.out.println("3. Hasil Reversed Infix -> Postfix : " + reversedPostfix);

        String prefixResult = infixToPrefix(inputInfix);
        String postfixResult = infixToPostfix(inputInfix);
        System.out.println("4. Postfix Anda : " + postfixResult);
        System.out.println("4. Prefix Anda : " + prefixResult);

        scanner.close();
    }
}
