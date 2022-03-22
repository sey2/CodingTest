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


public class Implement02 {

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int ans = 0;

        for(int i=0; i<n+1; i++){
            for(int j=0; j<60; j++){
                for(int k=0; k<60; k++){
                    String time = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
                    if(time.indexOf("3") >=0) ans ++;
                }
            }
        }

        bw.write(Integer.toString(ans));
        bw.close();
    }


}