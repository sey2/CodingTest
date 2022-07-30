import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main{
    static char arr[][];
    static boolean visited[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int depth[][];
    static int memo[][];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new char[m][n];
        depth = new int [m][n];
        memo = new int[m][n];

        for(int i=0; i<m; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] =  line.charAt(j);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 'L')
                    memo[i][j] =  bfs(new Pos(i, j), m, n);
            }

        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(memo[i][j], ans);
            }
        }
        System.out.println(ans);
    }

    public static int bfs(Pos start,int m, int n){
        visited = new boolean[m][n];
        depth = new int[m][n];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;
        int curMax = 0;

        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if(nextX >=0 && nextX < n && nextY >=0 && nextY < m
                             && !visited[nextY][nextX] && arr[nextY][nextX] == 'L'){
                    queue.add(new Pos(nextY, nextX));
                    visited[nextY][nextX] = true;
                    depth[nextY][nextX] = depth[cur.y][cur.x] + 1;

                    curMax = Math.max(curMax,depth[nextY][nextX]);
                }
            }
        }
        return curMax;
    }
}

class Pos{
    int x;
    int y;

    public Pos(int y, int x){
        this.y = y;
        this.x = x;
    }
}
