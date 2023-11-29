class Solution {
    int dx[] = {0, 0, -1, 1};
    int dy[] = {-1, 1, 0, 0};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        for(int i=0; i<4; i++) {
            int nh = dy[i] + h;
            int nw = dx[i] + w;
            
            if(nh >=0 && nh < board.length && nw >=0 && nw < board[0].length) {
                if(board[h][w].equals(board[nh][nw])) answer ++;
            }
        }
        
        return answer;
    }
}