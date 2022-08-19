import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    static int depth[];
    static int cnt = 1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        init(m,n,br,st);

        for(int i=0; i<graph.size(); i++)
            Collections.sort(graph.get(i));

        dfs(start);

        for(int i=1; i<=m; i++)
            System.out.println(depth[i]);


    }

    public static void dfs(int start){

        if(!visited[start]){
            visited[start] = true;
            depth[start] = cnt++;
            for(var num : graph.get(start)){
                if(!visited[num]){
                    dfs(num);
                }
            }
        }
    }

    public static void init(int m, int n, BufferedReader br, StringTokenizer st) throws IOException {
        visited = new boolean[m+1];
        depth = new int[m+1];
        for(int i=0; i<=m; i++) graph.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

}
