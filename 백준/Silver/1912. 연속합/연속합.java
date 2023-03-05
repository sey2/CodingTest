import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n];

        String input[] = br.readLine().split(" ");
        for(int i=0; i<input.length; i++) arr[i] = Integer.parseInt(input[i]);

        dp[0] = arr[0];

        int ans = dp[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);




    }
}


