import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, e;
    static int arr[][];
    static boolean visited[];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];

        for(int i=0; i<e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[n+1];
        visited[1] = true;

        dfs(1);
        System.out.println(ans);


    }

    public static void dfs(int s){

        for(int i=1; i<=n; i++){
            if(arr[s][i] > 0 && !visited[i]) {
                visited[i] = true;
                dfs(i);
                ans ++;
            }
        }

    }

}