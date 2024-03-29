import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;


public class Main {
    static int n, m, s, e;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int cost[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        cost = new int[300001];

        for(int i=0; i<=300000; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        bfs();
    }
    
    public static void bfs(){

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        cost[s] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == e){
                System.out.println(cost[cur]);
                return;
            }

            if(boundCheck(cur+1) && cost[cur + 1] == Integer.MAX_VALUE) {
                q.add(cur + 1);
                cost[cur+1] = Math.min(cost[cur] + 1, cost[cur+1]);
            }

            if(boundCheck(cur-1) && cost[cur - 1] == Integer.MAX_VALUE){
                q.add(cur - 1);
                cost[cur-1] = Math.min(cost[cur] + 1, cost[cur-1]);
            }

            for(var num : list.get(cur)){
                if(boundCheck(num) && cost[num] == Integer.MAX_VALUE){
                    q.add(num);
                    cost[num] = Math.min(cost[cur] + 1, cost[num]);
                }
            }
        }

    }

    public static boolean boundCheck(int idx){
        return (idx >= 0 && idx <= 300000) ? true : false;
    }


}
