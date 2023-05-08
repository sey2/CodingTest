import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int graph[][] = new int[e][3];

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        int parent[] = new int[v + 1];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        System.out.println(kruskal(graph, parent));
    }

    public static void union(int parent[], int x, int y){
        x = find(parent, x);
        y = find(parent, y);

        if(x < y) parent[y] = x;
        else parent[x] = y;
    }

    public static int find(int parent[], int x){
        if(parent[x] == x) return x;
        else return find(parent, parent[x]);
    }

    public static int kruskal(int [][] graph, int parent[]){
        int cost = 0;
        for(int i=0; i< graph.length; i++){
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
                cost += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }
        return cost;
    }
}