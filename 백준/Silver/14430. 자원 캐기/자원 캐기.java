import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static int arr[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().split(" ");

        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        arr = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; ++i) {
            in = br.readLine().split(" ");
            for(int j = 0; j < m; ++j)
                arr[i][j] = Integer.parseInt(in[j]);
        }


        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + arr[i][j];
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
}
