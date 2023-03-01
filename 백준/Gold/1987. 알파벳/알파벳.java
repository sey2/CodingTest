import java.io.*;


public class Main
{
    static char board[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int n, m;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new char[n][m];
        for(int i=0; i<n; i++){
            String in = br.readLine();
            for(int j=0; j<m; j++) board[i][j] = in.charAt(j);
        }
        

        dfs(new Loc(0,0), 0, "");


        System.out.println(max);

    }

    public static void dfs(Loc cur, int depth, String str){
        if(str.contains(String.valueOf(board[cur.y][cur.x]))){
            max = Math.max(max, depth);
            return;
        }

        str += board[cur.y][cur.x];

        for(int i=0; i<4; i++){
            int ny = dy[i] + cur.y;
            int nx = dx[i] + cur.x;

            if(check(ny, nx))
                dfs(new Loc(ny, nx), depth + 1, str);
        }

    }

    public static boolean check(int ny, int nx){
        return(ny >= 0 && ny < n && nx >= 0 && nx < m) ? true : false;
    }


}

class Loc{
    int y, x;

    public Loc(int y, int x){
        this.y = y;
        this.x = x;
    }
}


