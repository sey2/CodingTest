import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean visited[];
    static int arr[];

    static int ans = Integer.MIN_VALUE;
    static int ansIdx = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            visited = new boolean[n+1];

            bfs(i);
        }

        System.out.println(ansIdx);


    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.poll();

            if(!visited[arr[cur]]){
                cnt ++;
                q.add(arr[cur]);
                visited[arr[cur]] = true;
            }
        }

        if(cnt > ans){
            ans = cnt;
            ansIdx = start;
        }
    }
}