import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] students = new int[n][5];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int leader = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                for (int k = 0; k < 5; k++) {
                    if (students[i][k] == students[j][k]) {
                        visited[j] = true;
                        break;
                    }
                }
            }

            for (boolean v : visited) {
                if (v) count++;
            }

            if (count > max) {
                max = count;
                leader = i;
            }
        }

        System.out.println(leader + 1);
    }
}