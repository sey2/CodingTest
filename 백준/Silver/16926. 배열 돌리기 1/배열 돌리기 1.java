
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int arr[][];
    static private int[] dx = {1,0,-1,0};
    static private int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(r-->0) {
            rotation(m,n);
        }

        for(int line[] : arr){
            for(int num: line){
                System.out.print(num + " ");
            }
            System.out.println();
        }


    }


    public static void rotation(int x2, int y2){

        for (int i = 0; i < Math.min(x2, y2) / 2; i++) {
            int idx = 0;
            int curX = i;
            int curY = i;

            int temp = arr[curY][curX];

            while (idx < 4) {
                int nx = curX + dx[idx];
                int ny = curY + dy[idx];

                if (check(nx, ny, i, x2, y2)) idx++;
                else {
                    arr[curY][curX] = arr[ny][nx];
                    curX = nx;
                    curY = ny;
                }

            }
            arr[i+1][i] = temp;
        }
    }

    public static boolean check(int nx, int ny, int i, int m, int n){
        return (nx < i || ny < i || nx >= m-i || ny >= n-i) ? true : false;
    }

}
