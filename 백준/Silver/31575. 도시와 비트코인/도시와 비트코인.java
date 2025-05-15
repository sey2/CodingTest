import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] graph;
    static int widthSize;
    static int heightSize;

    static int[] dx = {0, 1};
    static int[] dy = {1,0};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        widthSize = Integer.parseInt(st.nextToken());
        heightSize = Integer.parseInt(st.nextToken());

        graph = new int[heightSize][widthSize];
        for (int i = 0; i < heightSize; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < widthSize; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean canReach = bfs(new Pos(0, 0));
        System.out.println(canReach ? "Yes" : "No");
    }

    public static boolean bfs(Pos startPos) {
        final Queue<Pos> queue = new LinkedList<>();
        queue.add(startPos);
        boolean[][] visited = new boolean[heightSize][widthSize];
        visited[startPos.y][startPos.x] = true;

        while (!queue.isEmpty()) {
            Pos current = queue.poll();

            if(current.x == widthSize -1 && current.y == heightSize-1) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                final int nx = current.x + dx[i];
                final int ny = current.y + dy[i];

                final boolean canMove = canVisited(visited, nx, ny);

                if (canMove) {
                    queue.add(new Pos(nx, ny));
                    visited[ny][nx] = true;
                }
            }

        }

        return false;
    }

    public static boolean canVisited(boolean[][] visited, int nx, int ny) {
        // graph boundary check
        if (nx < 0 || nx >= widthSize || ny < 0 || ny >= heightSize) {
            return false;
        }

        return !visited[ny][nx] && graph[ny][nx] == 1;
    }
}

class Pos {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}