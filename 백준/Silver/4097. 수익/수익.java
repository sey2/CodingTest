import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            int arr[] = new int[n];
            int dp[] = new int[n];

            for(int i=0; i<n; ++i)
                arr[i] = Integer.parseInt(br.readLine());

            int max = arr[0];
            dp[0] = arr[0];

            for(int i=1; i<n; i++) {
                dp[i] = Math.max(arr[i] + dp[i-1], arr[i]);
                max = Math.max(dp[i], max);
            }

            System.out.println(max);
        }

    }
}
