import java.io.*;
import java.util.*;


public class Main {

    static int n, m;
    static Node graph[];
    static int parent[];
    static long allCost = 0;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new Node[m];
        parent = new int[n+1];

        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            graph[i] = new Node(a,b,cost);

            list.get(a).add(b);
            list.get(b).add(a);

            allCost += cost;
        }

        for(int i=0; i<parent.length; i++)
            parent[i] = i;

        kruskal();
    }

    public static void kruskal(){
        Arrays.sort(graph);

        long sum = 0;
        for(int i=0; i<graph.length; i++){
            if(find(graph[i].a) != find(graph[i].b)){
                union(graph[i].a, graph[i].b);
                sum += graph[i].c;
            }
        }

        long ans = (bfs() == true) ? allCost - sum : -1;

        System.out.println(ans);

    }

    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a == b) return;

        if(parent[a] < parent[b]) parent[a] = b;
        else parent[b] = a;
    }

    public static int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);

    }

    public static boolean bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean visited[] = new boolean[n+1];
        visited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int num : list.get(cur)){
                if(!visited[num]){
                    visited[num] = true;
                    q.add(num);
                }
            }
        }

        for(int i=1; i<=n; i++)
            if(!visited[i]) return false;

        return true;
    }

}

class Node implements Comparable<Node>{
    int a, b;
    long c;

    Node(int a, int b, long c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return this.c < o.c ? -1: 1;
    }
}

