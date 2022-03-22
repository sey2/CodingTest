import java.io.*;
import java.util.*;

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}


public class Implement03 {

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        FastScanner sc = new FastScanner();

        String input = sc.next();
        int ans = 0;

        /* 수직 위 두칸 후 왼, 수직 위 두칸 후 오, 수직 아 두칸 후 왼, 수직 아 두칸 후  오
           수평 왼 두칸 후 위, 수평 오 두칸 후 위, 수평 왼 두칸 후 아, 수평 완 두칸 후  아 */
        int [] dx = {-1 ,1 ,-1, 1, -2, 2, -2, 2};
        int [] dy = {-2, -2, 2, 2, 1, 1, -1, -1};

        int column = input.charAt(0) - 'a' + 1;      // 문자열로 받은 열을 숫자로 변환 (아스키 코드 값 이용)
        int row = input.charAt(1) - '0';


        for(int i=0; i<8; i++){
            if((column + dx[i] > 8) || (column + dx[i] < 1) ||  (row + dy[i] > 8) || (row + dy[i] < 1))
                continue;
            ans ++;
        }

        bw.write(Integer.toString(ans));
        bw.close();
    }
}


/*          c2에 위치 할 경우
      a   b   c   d   e   f   g   h
 1  | x |   |   |   | x |   |   |   |
 2  |   |   | O |   |   |   |   |   |
 3  | x |   |   |   | x |   |   |   |
 4  |   | x |   | x |   |   |   |   |
 5  |   |   |   |   |   |   |   |   |
 6  |   |   |   |   |   |   |   |   |
 7  |   |   |   |   |   |   |   |   |
 8  |   |   |   |   |   |   |   |   |

 */