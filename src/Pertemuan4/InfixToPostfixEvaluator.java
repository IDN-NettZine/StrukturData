package Pertemuan4;

import javax.swing.JOptionPane;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class InfixToPostfixEvaluator {
    private static int presedensi(char op) {
        switch (op) {
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
    private static List<String> tokenize(String ekspresi) {
        List<String> tokens = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < ekspresi.length(); i++) {
            char c = ekspresi.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)) {
                numberBuffer.append(c);
            } else {
                if (numberBuffer.length() > 0) {
                    tokens.add(numberBuffer.toString());
                    numberBuffer.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }

        if (numberBuffer.length() > 0) {
            tokens.add(numberBuffer.toString());
        }

        return tokens;
    }
    public static List<String> infixKePostfix(String ekspresi) {
        List<String> tokens = tokenize(ekspresi);
        List<String> hasil = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for (String token : tokens) {
            char c = token.charAt(0);

            if (Character.isDigit(c)) {
                hasil.add(token);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    hasil.add(String.valueOf(stack.pop()));
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && stack.peek() != '(' && 
                       presedensi(stack.peek()) >= presedensi(c)) {
                    hasil.add(String.valueOf(stack.pop()));
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            hasil.add(String.valueOf(stack.pop()));
        }

        return hasil;
    }

    public static double evaluasiPostfix(List<String> tokensPostfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : tokensPostfix) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();

                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                    case '^': stack.push(Math.pow(a, b)); break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String infixInput = JOptionPane.showInputDialog(
            null, 
            "Infix form:", 
            "Input", 
            JOptionPane.QUESTION_MESSAGE
        );

        if (infixInput != null && !infixInput.trim().isEmpty()) {
            try {
                List<String> postfixTokens = infixKePostfix(infixInput);
                String postfixStr = String.join(" ", postfixTokens);

                double hasil = evaluasiPostfix(postfixTokens);

                String hasilFormatted = (hasil % 1 == 0) ? String.format("%.0f", hasil) : String.valueOf(hasil);

                System.out.println("Infix form     : " + infixInput);
                System.out.println("Postfix form   : " + postfixStr);
                System.out.println("Hasil evaluasi adalah " + hasilFormatted);

                JOptionPane.showMessageDialog(
                    null, 
                    "Postfix form: " + postfixStr + "\n\nHasil evaluasi adalah " + hasilFormatted, 
                    "Hasil", 
                    JOptionPane.INFORMATION_MESSAGE
                );

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    null, 
                    "Format ekspresi infix tidak valid!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}