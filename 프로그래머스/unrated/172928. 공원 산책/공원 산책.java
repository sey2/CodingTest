import java.util.HashMap;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] map = new char[park.length][park[0].length()];

        Pos start = new Pos(0, 0);
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S'){
                    start.setPos(i, j);
                }
            }
        }

        HashMap<String, int[]> hash = new HashMap<>();
        hash.put("E", new int[]{0, 1});
        hash.put("S", new int[]{1, 0});
        hash.put("N", new int[]{-1, 0});
        hash.put("W", new int[]{0, -1});

        loop:
        for(int i=0; i<routes.length; i++){
            String[] cur = routes[i].split(" ");

            int dir[] = hash.get(cur[0]);

            int ny = start.y, nx = start.x ;
            for(int j=0; j<Integer.parseInt(cur[1]); j++){
                ny +=  dir[0];
                nx +=  dir[1];

                if(ny < 0 || ny >= map.length || nx <0 || nx >= map[0].length || map[ny][nx] == 'X')
                    continue loop;
            }

            start.setPos(ny, nx);
        }

        return new int[] {start.y, start.x};
    }
}

class Pos{
    int y, x;

    public Pos(int y, int x){
        this.y = y;
        this.x =x;
    }

    public void setPos(int y, int x){
        this.y = y;
        this.x = x;
    }
}

