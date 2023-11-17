import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = 1;
        while(T-->0) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                String in = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.charAt(j) - '0';
                }
            }

            int num = n/2;
            boolean reverse = false;
            int sum = 0;

            for(int i=0; i<n; i++) {
                for(int j=num; j<n - num; j++) {
                    sum += arr[i][j];
                }

                if(!reverse) num --;
                else num++;
                if(i == n/2) {
                    num = 1;
                    reverse = true;
                }

            }
            System.out.println("#" + cnt++ + " " + sum);
        }
    }
}
