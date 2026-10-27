package Pertemuan4;
import java.util.Scanner;
import java.util.Stack;
public class InfixToPostfixTugas26 {
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
    public static String konversiInfixKePostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); 
                }
            }
            else {
                while (!stack.isEmpty() && stack.peek() != '(' && 
                       presedensi(stack.peek()) >= presedensi(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== RANGGAFIX 😹 ===");
        System.out.print("Masukkan Infix: ");
        String infixInput = scanner.nextLine();
        String postfixHasil = konversiInfixKePostfix(infixInput);
        System.out.println("\nHasil Konversi:");
        System.out.println("Infix   : " + infixInput);
        System.out.println("Postfix : " + postfixHasil);
        scanner.close();
    }
}