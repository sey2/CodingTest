import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    char [][] map;
    int [][] depth;

    int width = 0;
    int height = 0;

    int dx[] = {0, 0, -1, 1};
    int dy[] = {-1, 1, 0 ,0};

    public int solution(String[] maps) {
        int answer = 0;

        width = maps[0].length();
        height = maps.length;

        // init map
        map = new char[height][width];
        depth = new int[height][width];

        for(int i=0; i<height; i++) Arrays.fill(depth[i], -1);

        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++)
                map[i][j] = maps[i].charAt(j);


        Pos start = findIndex('S');
        Pos lever = findIndex('L');
        Pos exit = findIndex('E');

        bfs(start, lever);
        answer = depth[lever.y][lever.x];

        if(answer == -1) return -1;

        depth = new int[height][width];
        for(int i=0; i<height; i++) Arrays.fill(depth[i], -1);
        bfs(lever, exit);

        if(depth[exit.y][exit.x] == -1) return -1;
        answer += depth[exit.y][exit.x];

        return answer;
    }

    public void bfs(Pos start, Pos endPoint){
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        depth[start.y][start.x] = 0;

        if(start.x == endPoint.x && start.y == endPoint.y)
            return;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(check(nx, ny) && depth[ny][nx] == -1){
                    q.add(new Pos(ny, nx));
                    depth[ny][nx] = depth[cur.y][cur.x] + 1;
                }

                if(endPoint.x == nx && endPoint.y == ny) return;
            }

        }
    }

    public boolean check(int nx, int ny){
        return (nx >= 0 && nx < width && ny >=0 && ny < height && map[ny][nx] != 'X') ? true : false;
    }

    public Pos findIndex(char c){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(c == map[i][j]) return new Pos(i, j);
            }
        }
        return new Pos(-1,-1);
    }
}

class Pos{
    int x, y;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // System.out.println(new Solution().solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(new Solution().solution(new String[]{"EOOOO","XXXXX ","LOOSO","XXXXX","OOOOX"}));
    }



}

