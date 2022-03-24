import java.io.*;
import java.util.StringTokenizer;

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}

public class Implement04 {
    public static void main(String args[]) throws IOException{
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();           // 행
        int m = sc.nextInt();           // 열
        int a = sc.nextInt();           // 북쪽으로 부터 떨어진 칸 개수
        int b = sc.nextInt();           // 서쪽으로 부터 떨어진 칸 개수
        int direction = sc.nextInt();   // 북쪽(0), 동쪽(1), 남쪽(2), 서쪽(3)

        int [][] visited = new int[n][m];
        int [][] map = new int[n][m];       // 육지(0), 바다(1)
        // 북쪽 보고 있을 때, 서쪽 " , 남쪽 ", 동쪽 " 이동을 담은 배열
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};

        // 맵 입력 받기
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                map[i][j] = sc.nextInt();

        visited[a][b] = 1;
        int ans = (map[a][b] == 0) ? 1: 0;
        int turn_count = 0;

        while(true){
            direction = turn_left(direction);

            int curX = a + dx[direction];
            int curY = b + dy[direction];

            // 가보지 않은 칸이 존재 한다면
            if(visited[curX][curY] == 0 && map[curX][curY] == 0){
                visited[curX][curY] = 1;
                a = curX;
                b = curY;
                ans ++;
                turn_count = 0;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 이동 불가능할 경우
            else turn_count++;

            // 네 방향 전부 이동 불가능 할 경우
            if(turn_count == 4){
                curX = a - dx[direction];
                curY = b - dy[direction];

                // 뒤로 갈 수 있다면
                if(map[curX][curY] == 0){
                    a = curX;
                    b = curY;
                }
                // 뒤로 이동 못할 경우 (바다 일 경우)
                else break;
                turn_count = 0;
            }

        }



        bw.write(Integer.toString(ans));      // 정답을 출력한다.
        bw.close();
    }

    public static int turn_left(int direction){
        direction--;
        if(direction == -1) direction =3;

        return direction;
    }

}


/*
    현재 위치에서 왼쪽으로 돌아서 한칸 전진하고 바다인지 육지인지 확인해서 
    구현만 해주면 되는 문제
*/

