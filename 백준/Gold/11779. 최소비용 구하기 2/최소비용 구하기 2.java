import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int cost[];
    static boolean visited[];
    static int route[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        cost = new int[n+1];
        visited = new boolean[n+1];
        route = new int[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            cost[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<m; i++){
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            graph.get(a).add(new Node(b, cost));
        }

        String input[] = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        dijkstra(start);

        int current = end;
        ArrayList<Integer> list = new ArrayList<>();
        while(current != 0){
            list.add(current);
            current = route[current];
        }

        System.out.println(cost[end]);
        System.out.println(list.size());
        for(int i=list.size() - 1; i>=0; i--) System.out.print(list.get(i) + " ");


    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        cost[start] = 0;
        route[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost > cost[cur.v]) continue;

            for(Node next : graph.get(cur.v)){
                if(!visited[next.v] && cost[next.v] > cost[cur.v] + next.cost){
                    cost[next.v] = cost[cur.v] + next.cost;
                    route[next.v] = cur.v;
                    pq.add(new Node(next.v, cost[next.v]));
                }
            }
        }
    }
}

class Node{
    int v, cost;

    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}




