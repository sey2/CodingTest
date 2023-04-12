import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static int arr[][];
    static boolean visited[][];
    static int depth[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i=0; i<n; i++){
            String input = br.readLine();

            for(int j=0; j<m; j++){
                arr[i][j] =  input.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        depth = new int[n][m];

        bfs(new Pos(0, 0));

    }

    public static void bfs(Pos start){
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            if(cur.y == n-1 && cur.x == m-1)
                break;

            for(int i=0; i<4; i++){
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if(check(ny, nx)){
                    q.add(new Pos(ny, nx));
                    visited[ny][nx] = true;
                    depth[ny][nx] = depth[cur.y][cur.x] + 1;
                }

            }
        }

        System.out.println(depth[n-1][m-1] + 1);

    }

    public static boolean check(int ny, int nx){
        return ny >= 0 && ny < n &&
                nx >= 0 && nx < m &&
                !visited[ny][nx] &&
                arr[ny][nx] == 1;
    }
}

class Pos{
    int y, x;

    public Pos(int y, int x){
        this.y = y;
        this.x = x;
    }
}