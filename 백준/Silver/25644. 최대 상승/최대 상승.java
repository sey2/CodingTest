import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;

        String in[] = br.readLine().split(" ");
        int ans = 0;
        for(int i=0; i<n; i++) {
            int cur = Integer.parseInt(in[i]);

            min = Math.min(cur, min);
            ans = Math.max(cur - min, ans);
        }
        System.out.println(ans);
    }

}
