
import java.io.*;
import java.util.*;


public class Main {
    public static int arr[][];
    public static int dx[] = {0, 0, -1, 1};
    public static int dy[] = {-1, 1, 0, 0};
    public static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        PriorityQueue<Cor> q = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] != 0)
                    q.add(new Cor(i,j, arr[i][j]));
            }
        }

        int s, y, x;
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        while(!q.isEmpty() && s--> 0){
            int virusCnt = q.size();

            PriorityQueue<Cor> tmp = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);
            for(int i=0; i<virusCnt; i++) {
                Cor cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur.y + dy[j];
                    int nx = cur.x + dx[j];

                    if (boundCheck(ny, nx)) {
                        tmp.add(new Cor(ny, nx, arr[cur.y][cur.x]));
                        arr[ny][nx] = arr[cur.y][cur.x];
                    }
                }
            }

            for(Cor cor : tmp)
                q.add(cor);
        }

        System.out.println(arr[y-1][x-1]);
    }

    public static boolean boundCheck(int ny, int nx){
        return (ny >= 0 && ny < n &&
                nx >= 0 && nx < n &&
                arr[ny][nx] == 0);
    }
}

class Cor{
    int y,x;
    int num;

    Cor(int y, int x, int num){this.y = y; this.x = x; this.num = num;}
}

