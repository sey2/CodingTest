import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr = new int[5][5];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in;

        for (int i = 0; i < 5; ++i) {
            in = br.readLine().split(" ");
            for (int j = 0; j < 5; ++j) {
                arr[i][j] = Integer.parseInt(in[j]);
            }
        }

        in = br.readLine().split(" ");
        dfs(Integer.parseInt(in[0]), Integer.parseInt(in[1]), 0, 0);

        System.out.println(ans >= 1 ? 1 : 0);
    }

    public static void dfs(int curY, int curX, int depth, int count) {
        if (depth == 3) {
            if (count >= 2) {
                ans = 1;
            }
            return;
        }

        int temp = arr[curY][curX];
        arr[curY][curX] = -1;

        for (int k = 0; k < 4; ++k) {
            int ny = dy[k] + curY;
            int nx = dx[k] + curX;

            if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && arr[ny][nx] != -1) {
                dfs(ny, nx, depth + 1, count + (arr[ny][nx] == 1 ? 1 : 0));
            }
        }

        arr[curY][curX] = temp;
    }
}
