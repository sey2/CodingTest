import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int p[] = new int[6];

        String in[] = br.readLine().split(" ");
        for(int i=1; i<=5; i++) p[i] = Integer.parseInt(in[i-1]);

        PriorityQueue<Integer> pq[] = new PriorityQueue[6];
        for(int i=0; i<=5; i++) pq[i] = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            in = br.readLine().split(" ");
            int k = Integer.parseInt(in[0]);
            int t = Integer.parseInt(in[1]);

            pq[k].add(t);
        }

        int ans = 0;
        for(int i=1; i<=5; i++) {
            int prev = pq[i].peek();
            for(int j=1; j<=p[i]; j++) {
                int cur = pq[i].poll();
                ans += (cur - prev) + cur;
                prev = cur;
            }
            ans += 60;
        }

        System.out.println(ans - 60);
    }
}
