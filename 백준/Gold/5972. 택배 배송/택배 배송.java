import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main
{
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int cost[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split( " ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            input = br.readLine().split( " ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            list.get(v1).add(new Node(v2, cost));
            list.get(v2).add(new Node(v1, cost));
        }

        cost = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        dijkstra(1);

        System.out.println(cost[n]);

    }

    public static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        cost[start] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(Node next : list.get(cur.v)){
                if(cost[next.v] > cur.cost + next.cost){
                    //visited[next.v] = true;
                    cost[next.v] = cur.cost + next.cost;
                    q.add(new Node(next.v, cost[next.v]));
                }
            }
        }

    }

}

class Node implements Comparable<Node>{
    int v;
    int cost;

    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }

    public int compareTo(Node o1){
        return this.cost - o1.cost;
    }
}
