import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine().trim();
        
        int totalB = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'B') totalB++;
        }

        int ans = N;
        int prefixB = 0;
        int prefixD = 0;

        ans = Math.min(ans, totalB);


        for (int i = 1; i <= N; i++) {
            char c = S.charAt(i - 1);
            if (c == 'B') {
                prefixB++;
            } else {
                prefixD++;
            }

            int flips = prefixD + (totalB - prefixB);
            ans = Math.min(ans, flips);
        }

        System.out.println(ans);
    }
}