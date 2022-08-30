import java.util.*;

class Solution {

    char arr[][];
    ArrayList<Location> overlap;
    int dx[] = {0,1,0,1};
    int dy[] = {0,0,1,1};
    boolean run = true;

    public int solution(int m, int n, String[] board) {
        init(m,n,board);

        while(run) {
            overlap = new ArrayList<>();

            check_overLap(m, n);

            if(overlap.size() == 0) break;

            delete_overlap(m, n);
        }

        return count_deleteBlock(m,n);
    }

    public int count_deleteBlock(int m, int n){
        int answer = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 'x') answer++;
            }
        }
        return answer;
    }

    public void delete_overlap(int m, int n){
        for(var cur : overlap)
            arr[cur.y][cur.x] = 'x';

        for(int i=0; i<n; i++){
            for(int j=m-1; j>=1; j--){
                if(arr[j][i] == 'x'){
                    int idx = j-1;
                    while(idx > 0 && arr[idx][i] == 'x'){
                        idx--;
                    }
                    swap(j,i,idx);
                }
            }
        }
    }

    public void swap(int i, int j, int ti){
        char c = arr[i][j];
        arr[i][j] = arr[ti][j];
        arr[ti][j] = c;
    }

    public void check_overLap(int m, int n){

        for(int i=0; i<m-1; i++){
            loopOut:
            for(int j=0; j<n-1; j++){
                char cur = arr[i][j];

                ArrayList<Location> tmp = new ArrayList<>();
                for(int k=0; k<4; k++) {
                    int nx = dx[k] + j;
                    int ny = dy[k] + i;

                    if (checkRange(nx, ny, m, n, cur)) continue loopOut;

                    tmp.add(new Location(ny,nx));
                }

                add_overlap(tmp);
            }
        }
    }

    public void add_overlap(ArrayList<Location> tmp){
        for(var location : tmp)
            overlap.add(location);
    }

    public boolean checkRange(int dx, int dy, int m, int n, char cur){
        return (dx < 0 || dy < 0 || dx >= n || dy >=m || arr[dy][dx] != cur || arr[dy][dx] == 'x') ? true : false;
    }

    public void init(int m, int n, String[] board){
        arr = new char[m][n];

        for(int i=0; i<m; i++){
            String line = board[i];

            for(int j=0; j<line.length(); j++)
                arr[i][j] = line.charAt(j);

        }
    }
}

class Location{
    int y;
    int x;

    public Location(int y, int x) {this.y = y; this.x = x;}
}
