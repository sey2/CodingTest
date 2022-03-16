import java.io.*;
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

public class Greedy03 {
    public static void main(String args[]) throws IOException{
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 가장 큰 수를 담을 변수
        int ans = 0;

        int n = sc.nextInt();   // 열
        int m = sc.nextInt();   // 행

        for(int i=0; i<n; i++){
            // 하나의 열 안에 들어있는 숫자들 중 가장 작은 수를 찾기 위한 우선순위 큐
            PriorityQueue<Integer> columnPQ = new PriorityQueue<Integer>();

            for(int j=0; j<m; j++)
                columnPQ.add(sc.nextInt());     // 열을 입력 받는다 (가장 작은 수가 제일 첫 번째에 위치하게 됨)

            ans = Math.max(ans, columnPQ.poll()); // 가장 작은 수들 중에서 가장 큰수 값을 찾는다.
        }



        bw.write(Integer.toString(ans));      // 정답을 출력한다.
        bw.close();
    }

}

/*
* 문제 설명이 좀 길고 빙빙 돌려 말할 뿐이지 그렇지 매우 쉬운 문제이다.
* 각 행마다 가장 작은 수를 찾아서 가장 작은 수 들 중 가장 큰 수를 출력 하면 되는 문제이다.
* 문제의 예시로 예를 들어보자, 아래와 같이 3 * 3 배열이 있다고 가정하면

  | 3  1  2 |       <- 열에서 가장 작은 수 1
  | 4  1  4 |       <- 열에서 가장 작은 수 1
  | 2  2  2 |       <- 열에서 가장 작은 수 2

* 각 열에서 가장 작은 수들 (1, 1, 2) <- 여기서 가장 큰 수를 찾는다.
* 따라서 정답은 2
 */

