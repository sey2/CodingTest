import java.util.*;
class Pos{
    int x;
    int y;
    
    public Pos(int y, int x) { this.y = y; this.x = x;}
}

class Solution {
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int visited[][];
    
    public int solution(int[][] maps) {
            
        return bfs(maps,new Pos(0,0));
    }
    
    public static int bfs(int[][] maps, Pos start){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        
        visited = new int[maps.length][maps[0].length];
        visited[start.y][start.x] = 1;
        
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            
            for(int i=0; i<4; i++){
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];    
                
                if(nextX >=0 && nextX < maps[0].length && nextY >=0 && nextY < maps.length){
                    if(visited[nextY][nextX] == 0 && maps[nextY][nextX]==1){
                        visited[nextY][nextX] = visited[cur.y][cur.x] + 1;
                        queue.add(new Pos(nextY, nextX));
                    }
                }
            }
        }
        
        return (visited[visited.length-1][visited[0].length-1] == 0) ? -1 : visited[visited.length-1][visited[0].length-1];
    }
}
