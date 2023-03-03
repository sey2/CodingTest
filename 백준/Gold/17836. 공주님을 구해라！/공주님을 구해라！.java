import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static boolean visited[][];
    static boolean haveGram;
    static int cost[][];
    static int map[][];
    static int n,m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int t = Integer.parseInt(input[2]);

        map = new int[n][m];
        Loc gram = null;

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 2) gram = new Loc(i,j);
            }
        }


        // 그람이 없을 때 최단 경로
        int ans = Integer.MAX_VALUE;
        bfs(new Loc(0,0), new Loc(n-1, m-1));

        ans = Math.min(ans, cost[n-1][m-1]);

        // 그람까지의 최단 경로
        bfs(new Loc(0, 0), gram);

        if(cost[gram.y][gram.x] == -1){
            // 그람을 얻지 못하지만 공주를 구출할 수 있을 때
            if(ans != -1 && ans <= t && cost[n-1][m-1] != -1){
                System.out.println(ans);
                return;
            }else { // 공주를 구출하지 못할 때
                System.out.println("Fail");
                return;
            }
        }

        ans = (cost[n-1][m-1] == -1 && ans == -1) ? Integer.MAX_VALUE :
                (cost[n-1][m-1] == -1) ? ans : Math.min(cost[n-1][m-1], ans);

        int sum = cost[gram.y][gram.x];
        // 그람을 가지고 있을 때 최단 경로
        haveGram = true;
        bfs(gram, new Loc(n-1, m-1));

        ans = Math.min(ans, sum + cost[n-1][m-1]);

        if(t >= ans && ans != 1)
            System.out.println(ans);
        else
            System.out.println("Fail");

    }

    public static void bfs(Loc start, Loc end){
        visited = new boolean[n][m];
        cost = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(cost[i], -1);

        Queue<Loc> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;
        cost[start.y][start.x] = 0;

        while(!q.isEmpty()){
            Loc cur = q.poll();

            if(cur.y == end.y && cur.x == end.x) return;

            for(int i=0; i<4; i++){
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if(check(ny, nx)){
                    q.add(new Loc(ny, nx));
                    visited[ny][nx] = true;
                    cost[ny][nx] = cost[cur.y][cur.x] + 1;
                }

            }

        }
    }

    public static boolean check(int ny, int nx){
        if(haveGram)
            return (ny >= 0 && ny < n && nx >=0 && nx < m && !visited[ny][nx]) ? true : false;
        else
            return (ny >= 0 && ny < n && nx >=0 && nx < m && !visited[ny][nx] && map[ny][nx] != 1) ? true : false;
    }
}

class Loc{
    int y, x;

    public Loc(int y, int x){
        this.y = y;
        this.x = x;
    }
}




