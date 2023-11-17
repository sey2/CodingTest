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
            int n = Integer.parseInt(br.readLine());

            int ans = 0;
            char arr[][] = new char[8][8];
            for(int i=0; i<8; i++){
                String in = br.readLine();
                for(int j=0; j<8; j++) {
                    arr[i][j] = in.charAt(j);
                }
            }

            for(int i=0; i<8; i++) {
                for(int j=0; j<=8-n; j++) {
                    if(isPal(makeStr(arr, i, j, n, true)))
                        ans ++;
                }
            }

            for(int j=0; j<8; j++) {
                for(int i=0; i<=8-n; i++) {
                    if(isPal(makeStr(arr, i, j, n, false)))
                        ans ++;
                }
            }

            System.out.println("#" + cnt++ + " " +  ans);
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

    public static boolean isPal(String in) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<in.length(); i++)
            stack.add(in.charAt(i));

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return in.equals(sb.toString());
    }
}
