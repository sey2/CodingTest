import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main{

    static int arr[][] = new int[5][5];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1, 1, 0, 0};
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(1, new Pos(i,j), arr[i][j]);
            }
        }

        System.out.println(set.size());

    }

    public static void dfs(int depth, Pos cur, int str){
        if(depth == 6){
            set.add(str);
            return;
        }

        for(int i=0; i<4; i++){
            int ny = dy[i] + cur.y;
            int nx = dx[i] + cur.x;

            if(check(ny, nx))
                dfs(depth + 1, new Pos(ny, nx), Integer.parseInt((str + "") + (arr[ny][nx] + "")));
            
        }
    }

    public static boolean check(int ny, int nx){
        return (ny >=0 && ny < 5 &&
                nx >=0 && nx < 5);
    }

}

class Pos{
    int y,x;

    public Pos(int y, int x){
        this.y = y;
        this.x = x;
    }
}