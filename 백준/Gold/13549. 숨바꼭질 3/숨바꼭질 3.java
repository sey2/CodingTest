import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        visited = new boolean[1000001];
        bfs(start, end);


    }

    public static void bfs(int start, int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));


        while(!queue.isEmpty()){
            Node cur = queue.poll();
            visited[cur.idx] = true;

            int curIdx = cur.idx;

            if(cur.idx == end){
                System.out.println(cur.cost);
                break;
            }

            if(curIdx *2 <= 100000 && !visited[curIdx*2]){
                queue.add(new Node(curIdx*2, cur.cost));
            }

            if(curIdx+1 <= 100000 && !visited[curIdx+1]){
                queue.add(new Node(curIdx+1, cur.cost+1));
            }

            if(curIdx-1 >= 0 && !visited[curIdx-1]){
                queue.add(new Node(curIdx-1, cur.cost+1));
            }
        }
    }

}

class Node implements Comparable<Node>{
    int idx;
    int cost;

    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}


