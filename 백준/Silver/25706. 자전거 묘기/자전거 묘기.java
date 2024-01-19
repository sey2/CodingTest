import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().split(" ");
        int arr[] = new int[n];

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(in[i]);

        int dp[] = new int[n];
        dp[n-1] = 1;

        for(int i=n-2; i>=0; --i) {
            if(arr[i]!=0 && arr[i] + i >= n-1) dp[i] = 1;
            else if(arr[i]!=0) dp[i] = dp[i + arr[i]+1] + 1;
            else dp[i] = dp[i+1] + 1;
        }

        for(int num : dp)
            System.out.print(num + " ");

    }
}
