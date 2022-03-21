
public class Implement01 {
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        sc.nextLine();
        String [] input = sc.nextLine().split(" ");

        int x = 1, y = 1;       // 시작점
        // L, R, U, D
        int [] dx = {0, 0,-1, 1};  
        int [] dy = {-1, 1, 0, 0};

        char [] type = {'L', 'R', 'U', 'D'};

        for(int i=0; i<input.length; i++){
            int nx = -1, ny = -1;

            for(int j=0; j<4; j++){
                if(input[i].charAt(0) == type[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            if(nx < 1 || ny < 1 || nx > n || ny > n) continue;

            x = nx;
            y = ny;
        }



        bw.write(Integer.toString(x) + " " + Integer.toString(y));      // 정답을 출력한다.
        bw.close();
    }

}

