import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main{
    static int arr[][];
    static boolean visited[][];
    static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && arr[i][j] == 1) {
                    bfs(new Pos(i, j), m, n);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void bfs(Pos start,int m, int n){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            for(int i=0; i<8; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if(nextX >=0 && nextX < n && nextY >=0 && nextY < m
                             && !visited[nextY][nextX] && arr[nextY][nextX] == 1){
                    queue.add(new Pos(nextY, nextX));
                    visited[nextY][nextX] = true;
                }
            }
        }
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
