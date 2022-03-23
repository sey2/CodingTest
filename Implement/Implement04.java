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

        int [][] map = new int[n][m];       // 육지(0), 바다(1)
        // 북쪽 보고 있을 때, 서쪽 " , 남쪽 ", 동쪽 " 이동을 담은 배열
        int [] dx = { };
        int [] dy = { };

        // 맵 입력 받기
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                map[i][j] = sc.nextInt();

        int visit = (map[(n-1)-a][(m-1)-b] == 0) ? 1: 0;        // 첫 위치가 육지면 방문 처리




        bw.write("");      // 정답을 출력한다.
        bw.close();
    }

}



