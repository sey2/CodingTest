class Solution {
    int arr[][];
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    private static int min;

    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows+1][columns+1];

        int count = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                arr[i][j] = count++;
            }
        }

        Arrays.fill(arr[0], 0);

        int len = queries.length;

        int[] answer = new int[len];

        for(int i=0; i< queries.length; i++){
            min = Integer.MAX_VALUE;
            answer[i] = rotation(queries[i][1],queries[i][0],queries[i][3],queries[i][2]);
        }

        return answer;
    }

    public int rotation(int x1, int y1, int x2, int y2){
        int temp = arr[y1][x1];

        int idx = 0;
        int curX = x1;
        int curY = y1;

        while(idx < 4){
            int nx = curX + dx[idx];
            int ny = curY + dy[idx];

            if(check(nx,ny,x1,x2,y1,y2)) idx++;
            else{
                arr[curY][curX] = arr[ny][nx];
                min = Math.min(min, arr[curY][curX]);
                curX = nx;
                curY = ny;
            }
        }

        arr[curY][curX+1] = temp;

        return Math.min(min,arr[curY][curX+1]);
    }

    public boolean check(int nx, int ny, int x1, int x2, int y1, int y2){
        return (nx < x1 || ny < y1 || nx > x2 || ny > y2) ? true : false;
    }
}
