import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        int cnt = 1;
        while(T-->0) {
            String in[] = br.readLine().split(" ");
            Stack<Character> stack = new Stack<>();

            stack.push(in[1].charAt(0));
            for(int i=1; i<in[1].length(); i++) {
                if(!stack.isEmpty() && stack.peek() == in[1].charAt(i)) {
                    stack.pop();
                    continue;
                }
                stack.push(in[1].charAt(i));
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<stack.size(); i++) {
                sb.append(stack.get(i));
            }

            System.out.println("#" + cnt++ + " " +  sb);
        }
    }


}
