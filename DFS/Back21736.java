import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char graph[][];
    static boolean visited[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int cnt = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());   // 세로
        int n = Integer.parseInt(st.nextToken());   // 가로

        dfs(init(m, n, br), m, n);

        if(cnt != 0)
            System.out.println(cnt);
        else
            System.out.println("TT");
    }

    public static void dfs(Pos start, int y, int x){

        visited[start.y][start.x] = true;
        cnt += graph[start.y][start.x] == 'P' ? 1 : 0;

        for(int i=0; i<4; i++){
            int nextX = start.x + dx[i];
            int nextY = start.y + dy[i];

            if(checkRange(nextX,nextY,y,x)) continue;

            dfs(new Pos(nextY, nextX), y, x);
        }
    }

    public static boolean checkRange(int nextX, int nextY, int y, int x){
        if(nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) return true;
        else if (visited[nextY][nextX] || graph[nextY][nextX] == 'X') return true;

        return false;
    }

    public static Pos init(int m, int n, BufferedReader br) throws IOException {
        Pos start = null;

        graph = new char[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            String str = br.readLine();

            for(int j=0; j<n; j++){
                graph[i][j] = str.charAt(j);
                if(graph[i][j] == 'I') start = new Pos(i,j);
            }

        }
        return start;
    }

}

class Pos{
    int x;
    int y;

    public Pos(int y, int x){this.y = y; this.x=x;}
}
