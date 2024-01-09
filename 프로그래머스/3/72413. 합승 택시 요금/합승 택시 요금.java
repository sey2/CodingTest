import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    public int[][] ans;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        ans = new int[n+1][n+1];

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<fares.length; i++) {
            graph.get(fares[i][0]).add(new int[]{ fares[i][1], fares[i][2]});
            graph.get(fares[i][1]).add(new int[]{ fares[i][0], fares[i][2]});
        }

        dijkstra(s, n);
        dijkstra(a, n);
        dijkstra(b, n);

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            int cost = ans[s][i] + ans[a][i] + ans[b][i];
             if(cost == 0) continue;
            min = Math.min(cost, min);
        }

        return min;

    }

    public void dijkstra(int start, int n) {
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        dist[start] = 0;
        ans[start][start] = 0;

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int cur[] = pq.poll();

            for(int next[] : graph.get(cur[0])) {
                int nextCost = cur[1] + next[1];

                if(dist[next[0]] > nextCost) {
                    dist[next[0]] = nextCost;
                    pq.add(new int[] {next[0], nextCost});
                    ans[start][next[0]] = nextCost;
                }
            }
        }
    }
}

