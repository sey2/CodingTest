import java.io.*;
import java.util.StringTokenizer;

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

public class Greedy04 {
    public static void main(String args[]) throws IOException{
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;

        for(; N>=K; ans ++){
            for(; N % K !=0;){
                N -=1;
                ans ++;
            }
            N /= K;
        }

        for(; N>1; ans++)
            N -= 1;


        bw.write(Integer.toString(ans));      // 정답을 출력한다.
        bw.close();
    }

}

