import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int move[] = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Long> visited = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // 0: 현재위치, 1: 샘터로부터 거리
        Queue<long[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            long location = Integer.parseInt(st.nextToken());
            q.add(new long[]{location, 0});
            visited.add(location);
        }

        long ans = 0;
        while(!q.isEmpty()){
            long cur[] = q.poll();

            for(int i=0; i<2; i++){
                long nl = move[i] + cur[0];
                long nd = cur[1] + 1;

                if(visited.contains(nl)) continue;

                ans += nd;

                if(--k == 0){
                    System.out.println(ans);
                    return;
                }

                visited.add(nl);
                q.add(new long[]{nl,nd});
            }
        }
    }
}