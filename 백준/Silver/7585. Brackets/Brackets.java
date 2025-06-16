import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        loop:
        while (true) {
            input = br.readLine();

            if (input.equals("#")) break;

            Stack<Character> stack = new Stack<>();


            for (int i = 0; i < input.length(); i++) {
                final char ch = input.charAt(i);

                switch (ch) {
                    case '{':
                    case '(':
                    case '[':
                        stack.add(ch);
                        break;
                    case '}':
                    case ')':
                    case ']': {
                        if(stack.isEmpty() || !isCheck(stack.pop(), ch)) {
                            System.out.println("Illegal");
                            continue loop;
                        }
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("Legal");
            } else {
                System.out.println("Illegal");
            }
        }
    }

    public static boolean isCheck(char top, char current) {
        if (top == '{' && current == '}') return true;
        if (top == '(' && current == ')') return true;
        return top == '[' && current == ']';
    }
}
