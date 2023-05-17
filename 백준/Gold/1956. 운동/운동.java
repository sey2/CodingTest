import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[][] dist;
    static int ans = Integer.MAX_VALUE;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V+1][V+1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(i==j) continue;
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], cost);
        }

        for (int k = 1; k <= V; k++)
            for (int i = 1; i <= V; i++)
                for (int j = 1; j <= V; j++) {
                    if(i == j) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }


        for(int i=1; i<=V; i++)
            for(int j=1; j<=V; j++) {
                if(i==j) continue;
                if (dist[i][j] != INF && dist[j][i] != INF) {
                    ans = Math.min(ans, dist[i][j] + dist[j][i]);
                }
            }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }
}