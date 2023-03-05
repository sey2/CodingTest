import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main
{
    static int n;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int last = 0;
    static long cost[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) list.add(new ArrayList<>());
        cost = new long[n+1];

        st = new StringTokenizer(br.readLine());
        st.nextToken(); // 1번 노드

        for(int i=2; i<=n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            list.get(parent).add(i);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[v] += c;
        }

        dfs(1, cost[1]);


        for(int i=1; i<=n; i++) {
            System.out.print(cost[i] + " ");
        }

    }

    public static void dfs(int cur, long c){

        if(list.get(cur).size() == 0) {
            cost[cur] += c;
            return;
        }

        ArrayList<Integer> tmp = list.get(cur);

        for(int next : tmp) {
            cost[next] += cost[cur];
            dfs(next, c);
        }
    }

}



