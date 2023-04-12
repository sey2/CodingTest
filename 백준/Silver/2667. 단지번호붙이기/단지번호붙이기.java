import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static int arr[][];
    static boolean visited[][];
    static int total = 0;

    static int dfCount = 0;
    static PriorityQueue<Integer> ansPq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for(int i=0; i<n; i++){
            String input = br.readLine();

            for(int j=0; j<n; j++){
                arr[i][j] =  input.charAt(j) - '0';
            }
        }

        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1 && !visited[i][j]) {
                    //  bfs(new Pos(i, j));
                    visited[i][j] = true;
                    dfCount = 0;
                    dfs(new Pos(i, j));
                    ansPq.add(dfCount + 1);
                    total++;
                }
            }   // loop 2 end
        }   // loop 1   end


        System.out.println(total);
        while(!ansPq.isEmpty()){
            System.out.println(ansPq.poll());
        }

    }

    public static void bfs(Pos start){
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        int cnt = 1;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            for(int i=0; i<4; i++){
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if(check(ny, nx)){
                    cnt ++;
                    q.add(new Pos(ny,nx));
                    visited[ny][nx] = true;
                }
            }
        }

        ansPq.add(cnt);
        total++;
    }

    public static void dfs(Pos cur){
        for(int i=0; i<4; i++){
            int ny = dy[i] + cur.y;
            int nx = dx[i] + cur.x;

            if(check(ny, nx)){
                dfCount ++;
                visited[ny][nx] = true;
                dfs(new Pos(ny, nx));
            }
        }
    }

    public static boolean check(int ny, int nx){
        return ny >= 0 && ny < n &&
                nx >= 0 && nx < n &&
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
