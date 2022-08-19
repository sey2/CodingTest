import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char graph[][];
    static boolean visited[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 가로
        int m = Integer.parseInt(st.nextToken());   // 세로

        init(m, n, br);

        int enemy = 0;
        int army = 0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<= n; j++){
                if(!visited[i][j]){
                    if(graph[i][j] == 'W') army += bfs(new Pos(i,j), m, n, graph[i][j]);
                    else enemy +=  bfs(new Pos(i,j), m, n, graph[i][j]);
                }
            }
        }

        System.out.println(army + " " + enemy);
    }

    public static int bfs(Pos start, int m, int n, char checkTeam){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        int countTeam = 1;
        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(checkRange(nextX, nextY, m, n)) continue;

                if(!visited[nextY][nextX] && checkTeam == graph[nextY][nextX]){
                    queue.add(new Pos(nextY,nextX));
                    visited[nextY][nextX] = true;
                    countTeam ++;
                }
            }
        }

        return countTeam * countTeam;
    }

    public static boolean checkRange(int nextX, int nextY, int y, int x){
        if(nextX < 0 || nextX > x || nextY < 0 || nextY > y) return true;
        return false;
    }

    public static void init(int m, int n, BufferedReader br) throws IOException {

        graph = new char[m+1][n+1];
        visited = new boolean[m+1][n+1];

        for(int i=1; i<=m; i++){
            String str = br.readLine();

            for(int j=1; j<=n; j++)
                graph[i][j] = str.charAt(j-1);

        }
    }

}

class Pos{
    int x;
    int y;

    public Pos(int y, int x){this.y = y; this.x=x;}
}

