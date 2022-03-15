import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
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

public class Greedy02 {
    public static void main(String args[]) throws IOException{
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<n; i++)
            pq.add(sc.nextInt());

        int max1 = pq.poll();
        int max2 = pq.poll();
        int sum = 0;
        boolean is_max1 = true;


        loopOut:
        for(int cnt = 0; ;){
            for(int j=0; j<k; j++) {

                if(cnt>=m)
                    break loopOut;

                cnt ++;

                if(is_max1)
                    sum += max1;
                else {
                    sum += max2;
                    break;
                }
            }
            is_max1 = !is_max1;
        }
        


        bw.write(Integer.toString(sum));
        bw.close();
    }

}

