import java.util.*;


public class Main{
    private static int[][]arr;
    private static int x,y;

    /*
    static int arr[][] = {{2, 0, 0, 0, 0, 0, 0, 1},
                          {2, 1, 1, 0, 1, 1, 0, 1},
                          {2, 0, 0, 1, 0, 0, 0, 1},
                          {2, 1, 0, 0, 1, 1, 0 ,0},
                          {2, 1, 2, 2, 2, 2, 1, 1},
                          {2, 1, 2, 2, 2, 2, 2, 1},
                          {2, 2, 2, 1, 0, 1, 2, 1},
                          {0, 1, 1, 1, 0, 1, 2, 2}};

     */

    //미로 배열 주어짐
    public static void Maze(int x,int y){

        while(true){
            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    arr[i][j]=(int)(Math.random()*2);
                    //첫번째와 마지막은 무조건 0으로 함
                    if((i == 0 && j== 0)|| (i == (x-1) && j == (y-1))) {
                        arr[i][j]=0;
                    }
                }
            }
            if(FindRoad(x,y)){
                printMaze();
                break;
            }
        }
    }

    public static boolean FindRoad(int x, int y) {
        boolean visit[][] = new boolean[x][y];

        // 상, 하, 좌, 우
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        Stack<Location> stack = new Stack<>();

        Location cur = new Location(0,0);

        // 경로를 탐색한다
        while (!(cur.x == x-1 && cur.y == y-1)) {
            int curX = cur.x;
            int curY = cur.y;
            visit[curX][curY] = true;

            arr[curX][curY]=2;

            boolean check = false;
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX >= 0 && nextX < x && nextY >= 0 && nextY < y && !visit[nextX][nextY]) {
                    // 길이 있으면 Stack에 넣어준다.
                    if (arr[nextX][nextY] == 0) {
                        stack.push(new Location(nextX, nextY));
                        check = true;
                    }
                }
            }

            // 출구까지 가는 경로만 2로 출력 해야하므로
            // 2로 체크 되어있는 경로 중 상, 하, 좌, 우 길이 없을 경우와  0으로 바꾸어준다
            // 상 하 좌 우 체크하면서 2로 되어 있는 경로가 있으면 스택에 다시 넣어준다 (왔던 길 되돌아 가는 효과)
            if(!check && stack.size() > 0 && arr[curX][curY] == 2){
                arr[curX][curY] = 0;

                for (int i = 0; i < 4; i++) {
                    int nextX = cur.x + dx[i];
                    int nextY = cur.y + dy[i];

                    if (nextX >= 0 && nextX < x && nextY >= 0 && nextY < y) {

                        if (arr[nextX][nextY] == 2) {
                            stack.push(new Location(nextX, nextY));
                        }
                    }
                }
            }

            if(stack.isEmpty()){
                //System.out.println("길 없음");
                return false;
            }else{
                cur = stack.pop();
            }
        }
        arr[x-1][y-1] = 2;
       // printMaze();
        return true;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("[x][y] 중 X의 값 : ");
        int x = sc.nextInt();
        System.out.print("[x][y] 중 Y의 값 : ");
        int y = sc.nextInt();

        arr = new int[x][y];
        Maze(x,y);
        //System.out.println("--------Find Load --------");
      //  FindRoad(x,y);
    }

    public static void printMaze(){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}

class Location{
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    };
}

/*  경로 가 있는 경우 case test용

    static int arr[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 1, 0, 0, 1, 0, 0, 0},
                          {0, 1, 1, 0, 1, 0, 0, 0},
                          {0, 0, 1, 1, 1, 0, 0, 0},
                          {0, 0, 0, 1, 1, 1, 0, 0},
                          {0, 1, 1, 1, 0, 0, 0, 0},
                          {0, 0, 1, 0, 1, 1, 1, 0},
                          {0, 1, 1, 1, 1, 0, 1, 1},
                          {0, 0, 0, 0, 0, 0, 0, 0}};

       static int arr[][] = {{ 0, 1, 0, 0, 0, 0, 0, 0, 0},
                            { 0, 1, 0, 1, 0, 1, 1, 1, 0},
                            { 0, 1, 0, 1, 0, 1, 0, 0, 0},
                            { 0, 1, 0, 1, 0, 1, 0, 1, 0},
                            { 0, 1, 0, 1, 0, 1, 0, 1, 0},
                            { 0, 1, 0, 1, 0, 1, 0, 1, 1},
                            { 0, 1, 0, 1, 0, 1, 0, 0, 0},
                            { 0, 1, 1, 1, 0, 1, 0, 1, 0},
                            { 0, 0, 0, 0, 0, 1, 0, 1, 0}};

 */
