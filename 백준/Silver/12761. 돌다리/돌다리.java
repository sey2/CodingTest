import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;


public class Main {
    static int a, b, n, m;
    static int cost[];

    static int move[];
    static int jump[];
    static int ab[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cost = new int[100001];
        Arrays.fill(cost, Integer.MAX_VALUE);

        move = new int[]{1, -1, +a, -a, +b, -b};
        jump = new int[]{1, -1, 1, -1};
        ab = new int[]{a, a, b, b};

        bfs();
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        cost[n] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == m){
                System.out.println(cost[m]);
                return;
            }

            for(int i=0; i<move.length; i++){
                if(boundCheck(cur + move[i]) && cost[cur + move[i]] == Integer.MAX_VALUE){
                    q.add(cur + move[i]);
                    cost[cur + move[i]] = cost[cur] + 1;
                }
            }

            for(int i=0; i<jump.length; i++){
                int next = (jump[i] * ab[i]) * cur;

                if(boundCheck(next) && cost[next] == Integer.MAX_VALUE){
                    q.add(next);
                    cost[next] = cost[cur] + 1;
                }
            }

        }
    }

    public static boolean boundCheck(int idx){
        return (idx >=0 && idx <= 100000) ? true : false;
    }


}
