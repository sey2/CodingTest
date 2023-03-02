import java.io.*;
import java.util.*;

public class Main {

    static int map[][];
    static boolean visited[][];
    static int n,m;
    static int[][] dp;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        visited = new boolean[n][m];
        dp = new int[n][m];

        for(int i=0; i<n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[n-1][m-1] = 1;
        dfs(new Loc(0, 0));

        System.out.println(dp[0][0]);

    }

    public static void dfs(Loc cur){
        if(cur.y == n - 1 && cur.x == m -1)
            return;

        if(visited[cur.y][cur.x]) 
            return;
        
        visited[cur.y][cur.x] = true;

        for(int i=0; i<4; i++){
            int ny = dy[i] + cur.y;
            int nx = dx[i] + cur.x;

            if(check(ny, nx) && map[ny][nx] < map[cur.y][cur.x]){
                if(dp[ny][nx] != 0){
                    dp[cur.y][cur.x] += dp[ny][nx];
                    continue;
                }else {
                    dfs(new Loc(ny, nx));
                    dp[cur.y][cur.x] += dp[ny][nx];
                }
            }

        }
    }

    public static boolean check(int dy, int dx){
        return (dy >= 0 && dy < n && dx >=0 && dx < m) ? true : false;
    }

}


class Loc{
    int y,x;

    public Loc(int y, int x){
        this.y = y;
        this.x = x;
    }
}


