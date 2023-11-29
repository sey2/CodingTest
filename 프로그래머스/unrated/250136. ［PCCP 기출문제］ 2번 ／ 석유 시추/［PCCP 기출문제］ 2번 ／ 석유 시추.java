import java.util.*;

class Solution {
    public boolean visited[][]; 
    
    int dx[] = {0, 0, -1, 1};
    int dy[] = {1, -1, 0, 0};
    int cost[];
    
    int r = 0;
    int c = 0;
    
    public int solution(int[][] land) {
        int answer = 0;
        r = land.length;
        c = land[0].length;
        cost = new int[c];
                
        visited = new boolean[r][c];
        
        for(int i=0; i<r; i++) {  
            for(int j=0; j<c; j++) { 
                if(!visited[i][j] && land[i][j] == 1) {
                     bfs(new Pos(j, i), land);
                }
            }
        }
        
        for(int i=0; i<c; i++) {
            answer = Math.max(answer, cost[i]);
        }
        
        return answer;
    }
    
    public void bfs(Pos start, int[][] land) {
        Queue<Pos> q = new LinkedList<>(); 
        q.add(start);
        visited[start.y][start.x] = true;
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        int cnt = 1;
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            set.add(cur.x);
            
            for(int i=0; i<4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                
                if(nx >= 0 && nx < c && ny >= 0 && ny < r && land[ny][nx] == 1 && !visited[ny][nx]) {
                    q.add(new Pos(nx, ny));
                    visited[ny][nx] = true;
                    cnt ++;
                }
            }
        }
            
        for(var num: set) {
            cost[num] += cnt;
        }
    }
}

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
