import java.io.*;
import java.util.LinkedList;
import java.util.Queue;



public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int dp [][] = new int[46][2];

        int k = Integer.parseInt(br.readLine());

        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;


        if(k <= 1){
            bw.write(dp[k][0] + " " + dp[k][1]);
            bw.close();
            return;
        }

        for(int i=2; i<46; i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }

        bw.write(dp[k][0] + " " + dp[k][1]);
        bw.close();

    }
}
