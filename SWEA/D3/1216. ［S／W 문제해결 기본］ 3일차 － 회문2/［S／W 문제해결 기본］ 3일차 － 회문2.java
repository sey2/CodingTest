import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    static int max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        int cnt = 1;
        while(T-->0) {
            int n = Integer.parseInt(br.readLine());

            max = 1;
            char arr[][] = new char[100][100];

            for(int i=0; i<100; i++){
                String in = br.readLine();
                for(int j=0; j<100; j++) {
                    arr[i][j] = in.charAt(j);
                }
            }

            for(int k=0; k<=100; k++) {
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <= 100 - k; j++) {
                        isPal(makeStr(arr, i, j, k, true));
                    }
                }
            }

            for(int k=0; k<=100; k++) {
                for (int j = 0; j < 100; j++) {
                    for (int i = 0; i <= 100 - k; i++) {
                        isPal(makeStr(arr, i, j, k, false));
                    }
                }
            }

            System.out.println("#" + cnt++ + " " +  max);
        }
    }

    public static String makeStr(char arr[][], int i, int j, int n, boolean horizontal) {
        StringBuilder sb = new StringBuilder();

        if(horizontal) {
            for(int k=0; k<n; k++)
                sb.append(arr[i][j+k]);
        }else {
            for(int k=0; k<n; k++)
                sb.append(arr[i+k][j]);
        }

        return sb.toString();
    }

    public static void isPal(String in) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<in.length(); i++)
            stack.add(in.charAt(i));

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        if(in.equals(sb.toString())) {
            max = Math.max(max, sb.length());
        }
    }
}
